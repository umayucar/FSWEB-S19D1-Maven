package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {

    Fruit save(Fruit fruit);

    Fruit getById(Long id);

    List<Fruit> findAll();

    Fruit delete(Long id);

    boolean existsById(Long id);

    List<Fruit> getByPriceDesc();

    List<Fruit> getByPriceAsc();

    List<Fruit> searchByName(String name);
}
