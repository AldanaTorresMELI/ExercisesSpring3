package com.example.spring3.exampleAnimal.controller;

import com.example.spring3.exampleAnimal.dtos.AnimalDTO;
import com.example.spring3.exampleAnimal.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowired")
public class AutowiredController {

    @Autowired
    @Qualifier("perro")
    AnimalService animalService;

    @GetMapping("/{animal}")
    public AnimalDTO buscarAnimal(@PathVariable String animal){
        return new AnimalDTO(
          animalService.cantidadPatas(animal),
          animalService.hacerRuido(animal),
          animalService.toString()
        );
    }
}
