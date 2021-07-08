package com.example.spring3.exampleAnimal.services;

import org.springframework.stereotype.Service;

@Service("perro")
public class PerroService implements AnimalService {
    @Override
    public String cantidadPatas(String animal) {
        return "El " + animal + " tiene 4 patas";
    }

    @Override
    public String hacerRuido(String animal) {
        return "El " + animal + " ladra";
    }
}
