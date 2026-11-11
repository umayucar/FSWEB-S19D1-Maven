package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException(
                        "Fruit not found with id: " + id
                ));
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException(
                        "Fruit not found with id: " + id
                ));

        fruitRepository.delete(fruit);

        return fruit;
    }

    @Override
    public boolean existsById(Long id) {
        return fruitRepository.existsById(id);
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
