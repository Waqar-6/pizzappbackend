package com.w_farooq_group.slicemagic.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class PizzaDto {
    private Long id;
    @NotEmpty(message = "Pizza name can not be empty")
    @Size(min = 4, max = 30, message = "Pizza name has to more then 4 characters and at no more then 30")
    private String name;
    @NotNull
    @Positive(message = "Price can not be negative")
    @DecimalMin(value = "0.50", message = "Price can not be lower then 0.50")
    private BigDecimal price;
    @NotEmpty(message = "ingredients can not be empty")
    private List<String> ingredients;
    @Positive(message = "stock can not be zero")
    private Integer stock;
    private Boolean isSoldOut;
    @NotEmpty(message = "image can not be empty")
    private String imageUrl;
}
