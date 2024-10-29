package com.w_farooq_group.slicemagic.service;

import com.w_farooq_group.slicemagic.dto.PizzaDto;

import java.util.List;

public interface IPizzaService {

    /**
     *
     * @param pizzaDto - PizzaDto Object
     */
    void createPizza (PizzaDto pizzaDto);

    /**
     *
     * @return List of PizzaDto Objects
     */
    List<PizzaDto> fetchAllPizza ();

    /**
     *
     * @param pizzaId - Long
     * @return PizzaDto Object
     */
    PizzaDto fetchPizza (Long pizzaId);

    /**
     *
     * @param pizzaDto - updatedPizzaDto Object
     * @return True or False based on deletion
     */
    boolean updateExistingPizza (PizzaDto pizzaDto);

    /**
     *
     * @param pizzaId - Long
     * @return True or False based on delete
     */
    boolean deletePizza (Long pizzaId);
}
