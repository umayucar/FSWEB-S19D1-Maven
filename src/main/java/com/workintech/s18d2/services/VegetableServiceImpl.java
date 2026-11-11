package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable getById(Long id) {
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException(
                        "Vegetable not found with id: " + id
                ));
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException(
                        "Vegetable not found with id: " + id
                ));

        vegetableRepository.delete(vegetable);

        return vegetable;
    }

    @Override
    public boolean existsById(Long id) {
        return vegetableRepository.existsById(id);
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceDesc() {
        return vegetableRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceAsc() {
        return vegetableRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Vegetable> findByNameContainingIgnoreCase(String name) {
        return vegetableRepository.findByNameContainingIgnoreCase(name);
    }
}
