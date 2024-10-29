package com.w_farooq_group.slicemagic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class PizzaDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private List<String> ingredients;
    private Integer stock;
    private Boolean isSoldOut;
    private String imageUrl;
}
