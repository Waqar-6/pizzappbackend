package com.w_farooq_group.slicemagic.controller;

import com.w_farooq_group.slicemagic.constants.PizzaConstants;
import com.w_farooq_group.slicemagic.constants.ResponseStatusConstants;
import com.w_farooq_group.slicemagic.dto.PizzaDto;
import com.w_farooq_group.slicemagic.dto.ResponseDto;
import com.w_farooq_group.slicemagic.entity.Pizza;
import com.w_farooq_group.slicemagic.service.IPizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pizza", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class PizzaController {

    private final IPizzaService iPizzaService;

    @PostMapping
    public ResponseEntity<ResponseDto> createPizza (@RequestBody PizzaDto pizzaDto) {
        iPizzaService.createPizza(pizzaDto);
        ResponseDto responseDto = new ResponseDto(ResponseStatusConstants.STATUS_201, PizzaConstants.PIZZA_MSG_201);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PizzaDto>> fetchAllPizzas () {
        List<PizzaDto> allPizza = iPizzaService.fetchAllPizza();
        return new ResponseEntity<>(allPizza, HttpStatus.OK);
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaDto> fetchPizza (@PathVariable Long pizzaId) {
        PizzaDto pizzaDto = iPizzaService.fetchPizza(pizzaId);
        return new ResponseEntity<>(pizzaDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updatePizza (@RequestBody PizzaDto pizzaDto) {
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
