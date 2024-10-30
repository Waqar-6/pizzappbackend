package com.w_farooq_group.slicemagic.controller;

import com.w_farooq_group.slicemagic.constants.PizzaConstants;
import com.w_farooq_group.slicemagic.constants.ResponseStatusConstants;
import com.w_farooq_group.slicemagic.dto.PizzaDto;
import com.w_farooq_group.slicemagic.dto.ResponseDto;
import com.w_farooq_group.slicemagic.service.IPizzaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pizza", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PizzaController {

    private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
    private final IPizzaService iPizzaService;



    @PostMapping
    public ResponseEntity<ResponseDto> createPizza (@Valid @RequestBody PizzaDto pizzaDto) {
        log.info("post request for pizza at: {}", LocalDateTime.now());
        iPizzaService.createPizza(pizzaDto);
        ResponseDto responseDto = new ResponseDto(ResponseStatusConstants.STATUS_201, PizzaConstants.PIZZA_MSG_201);
        log.info("new pizza created: {} , at: {}", pizzaDto.getName(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PizzaDto>> fetchAllPizzas () {
        log.info("get all Pizza invoked");
        List<PizzaDto> allPizza = iPizzaService.fetchAllPizza();
        return new ResponseEntity<>(allPizza, HttpStatus.OK);
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaDto> fetchPizza (@PathVariable Long pizzaId) {
        log.info("fetch single pizza by id get method invoked at : {}", LocalDateTime.now());
        PizzaDto pizzaDto = iPizzaService.fetchPizza(pizzaId);
        log.info("fetch single pizza by id get method finished at : {}", LocalDateTime.now());
        return new ResponseEntity<>(pizzaDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updatePizza (@Valid @RequestBody PizzaDto pizzaDto) {
        boolean isUpdated = iPizzaService.updateExistingPizza(pizzaDto);
        ResponseDto updatedSuccessfulResponse = new ResponseDto(ResponseStatusConstants.STATUS_200, PizzaConstants.PIZZA_MSG_200_UPDATE);
        ResponseDto updateFailedResponse = new ResponseDto(ResponseStatusConstants.STATUS_417, PizzaConstants.PIZZA_MSG_417_UPDATE);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body(updatedSuccessfulResponse) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(updateFailedResponse);
    }

    @DeleteMapping("/{pizzaId}")
    public ResponseEntity<ResponseDto> deletePizza (@PathVariable Long pizzaId) {
        boolean isDeleted = iPizzaService.deletePizza(pizzaId);
        ResponseDto deletedSuccessfulResponse = new ResponseDto(ResponseStatusConstants.STATUS_200, PizzaConstants.PIZZA_MSG_200_DELETE);
        ResponseDto deleteFailedResponse = new ResponseDto(ResponseStatusConstants.STATUS_417, PizzaConstants.PIZZA_MSG_417_DELETE);
        return isDeleted ? ResponseEntity.status(HttpStatus.OK).body(deletedSuccessfulResponse) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(deleteFailedResponse);
    }
}
