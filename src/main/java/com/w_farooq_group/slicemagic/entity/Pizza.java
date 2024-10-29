package com.w_farooq_group.slicemagic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private List<String> ingredients;
    private Integer stock;
    private Boolean isSoldOut;
    private String imageUrl;
}

