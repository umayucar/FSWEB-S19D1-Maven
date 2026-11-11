package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    // Fiyata göre azalan
    List<Vegetable> findAllByOrderByPriceDesc();

    // Fiyata göre artan
    List<Vegetable> findAllByOrderByPriceAsc();

    // İsmin içerisinde geçen kelimeye göre arama
    List<Vegetable> findByNameContainingIgnoreCase(String name);
}
