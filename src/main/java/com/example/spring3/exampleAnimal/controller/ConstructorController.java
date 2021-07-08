package com.example.spring3.exampleAnimal.controller;

import com.example.spring3.exampleAnimal.dtos.AnimalDTO;
import com.example.spring3.exampleAnimal.services.AnimalService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/constructor")
public class ConstructorController {

    AnimalService animalService;

    public ConstructorController(@Qualifier("pato") AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{animal}")
    public AnimalDTO buscarAnimal(@PathVariable String animal){
        return new AnimalDTO(
                animalService.cantidadPatas(animal),
                animalService.hacerRuido(animal),
                animalService.toString()
        );
    }
}
