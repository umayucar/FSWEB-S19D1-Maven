package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    // GET /workintech/fruits
    @GetMapping
    public List<Fruit> getAllFruits() {
        return fruitService.getByPriceAsc();
    }

    // GET /workintech/fruits/desc
    @GetMapping("/desc")
    public List<Fruit> getAllFruitsDesc() {
        return fruitService.getByPriceDesc();
    }

    // GET /workintech/fruits/{id}
    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    // POST /workintech/fruits
    @PostMapping
    public Fruit saveFruit(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    // POST /workintech/fruits/{name}
    @GetMapping("/name/{name}")
    public List<Fruit> getFruitsByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }
    // DELETE /workintech/fruits/{id}
    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@PathVariable Long id) {
        return fruitService.delete(id);
    }
}
