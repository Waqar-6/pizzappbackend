package com.w_farooq_group.slicemagic.service.impl;

import com.w_farooq_group.slicemagic.dto.PizzaDto;
import com.w_farooq_group.slicemagic.entity.Pizza;
import com.w_farooq_group.slicemagic.exception.PizzaAlreadyExistsException;
import com.w_farooq_group.slicemagic.exception.ResourceNotFoundException;
import com.w_farooq_group.slicemagic.mapper.PizzaMapper;
import com.w_farooq_group.slicemagic.repository.PizzaRepository;
import com.w_farooq_group.slicemagic.service.IPizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements IPizzaService {

    private final PizzaRepository pizzaRepository;

    /**
     * @param pizzaDto - PizzaDto Object
     */
    @Override
    public void createPizza(PizzaDto pizzaDto) {
        boolean pizzaExists = pizzaRepository.existsByName(pizzaDto.getName());
        if (pizzaExists)
            throw new PizzaAlreadyExistsException("Pizza with the name: " + pizzaDto.getName() + " already exists");
        Pizza newPizza = PizzaMapper.mapToPizza(pizzaDto, new Pizza());
        pizzaRepository.save(newPizza);
    }

    /**
     * @return List of PizzaDto Objects
     */
    @Override
    public List<PizzaDto> fetchAllPizza() {
        List<Pizza> allPizza = pizzaRepository.findAll();
        return allPizza.stream()
                .map(pizza -> PizzaMapper.mapToPizzaDto(pizza, new PizzaDto())).toList();
    }

    /**
     * @param pizzaId - Long
     * @return PizzaDto Object
     */
    @Override
    public PizzaDto fetchPizza(Long pizzaId) {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza", "id", pizzaId.toString()));
        return PizzaMapper.mapToPizzaDto(pizza, new PizzaDto());
    }

    /**
     * @param pizzaDto - updatedPizzaDto Object
     * @return True or False based on deletion
     */
    @Override
    public boolean updateExistingPizza(PizzaDto pizzaDto) {
        Pizza pizza = pizzaRepository.findById(pizzaDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Pizza", "id", pizzaDto.getId().toString()));
        Pizza updatedPizza = PizzaMapper.mapToPizza(pizzaDto, pizza);
        pizzaRepository.save(updatedPizza);
        return true;
    }

    /**
     * @param pizzaId - Long
     * @return True or False based on delete
     */
    @Override
    public boolean deletePizza(Long pizzaId) {
        Pizza pizzaToDelete = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza", "id", pizzaId.toString()));
        pizzaRepository.delete(pizzaToDelete);
        return true;
    }
}