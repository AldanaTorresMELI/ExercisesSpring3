package com.example.spring3.exampleAnimal.services;

import org.springframework.stereotype.Service;

@Service("pato")
public class PatoService implements AnimalService{
    @Override
    public String cantidadPatas(String animal) {
        return "El " + animal + " tiene 2 patas";
    }

    @Override
    public String hacerRuido(String animal) {
        return "El " + animal + " parpea";
    }
}
