package com.w_farooq_group.slicemagic.mapper;

import com.w_farooq_group.slicemagic.dto.PizzaDto;
import com.w_farooq_group.slicemagic.entity.Pizza;

public final class PizzaMapper {

    // DONT WANT ANY OBJECT OF THIS CLASS BEING CREATED
    private PizzaMapper () {}

    public static PizzaDto mapToPizzaDto (Pizza pizza, PizzaDto pizzaDto) {
        pizzaDto.setId(pizza.getId());
        pizzaDto.setName(pizza.getName());
        pizzaDto.setPrice(pizza.getPrice());
        pizzaDto.setIngredients(pizza.getIngredients());
        pizzaDto.setStock(pizza.getStock());
        pizzaDto.setIsSoldOut(pizza.getIsSoldOut());
        pizzaDto.setImageUrl(pizza.getImageUrl());
        return pizzaDto;
    }


    public static Pizza mapToPizza (PizzaDto pizzaDto, Pizza pizza) {
        pizza.setName(pizzaDto.getName());
        pizza.setPrice(pizzaDto.getPrice());
        pizza.setIngredients(pizzaDto.getIngredients());
        pizza.setStock(pizzaDto.getStock());
        pizza.setIsSoldOut(pizzaDto.getIsSoldOut());
        pizza.setImageUrl(pizzaDto.getImageUrl());
        return pizza;
    }
}
