package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import java.util.List;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);

    Vegetable getById(Long id);

    List<Vegetable> findAll();

    Vegetable delete(Long id);

    boolean existsById(Long id);

    List<Vegetable> findAllByOrderByPriceDesc();

    List<Vegetable> findAllByOrderByPriceAsc();

    List<Vegetable> findByNameContainingIgnoreCase(String name);
}