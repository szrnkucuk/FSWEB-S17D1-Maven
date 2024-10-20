package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @PostConstruct
    public void loadAll(){
        this.animals=animals;
        this.animals.put(1,new Animal(1,"Maymun"));
    }

    @GetMapping
    public List<Animal> findAllAnimals(){
        return new ArrayList<>(animals.values());
    }
    @GetMapping("/{id}")
    public Animal animalById(@PathVariable int id){
        return this.animals.get(id);
    }
    @PostMapping
    public void addNewAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        animals.replace(id,animal);
        return animals.get(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id){
        animals.remove(id);
    }

}
