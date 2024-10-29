package com.w_farooq_group.slicemagic.repository;

import com.w_farooq_group.slicemagic.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Boolean existsByName (String name);
}
