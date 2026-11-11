package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    // GET /workintech/vegetables
    @GetMapping
    public List<Vegetable> getAllVegetables() {
        return vegetableService.findAllByOrderByPriceAsc();
    }

    // GET /workintech/vegetables/desc
    @GetMapping("/desc")
    public List<Vegetable> getAllVegetablesDesc() {
        return vegetableService.findAllByOrderByPriceDesc();
    }

    // GET /workintech/vegetables/{id}
    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    // POST /workintech/vegetables
    @PostMapping
    public Vegetable saveVegetable(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    // POST /workintech/vegetables/{name}
    @PostMapping("/{name}")
    public List<Vegetable> getVegetablesByName(@PathVariable String name) {
        return vegetableService.findByNameContainingIgnoreCase(name);
    }

    // DELETE /workintech/vegetables/{id}
    @DeleteMapping("/{id}")
    public Vegetable deleteVegetable(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}
