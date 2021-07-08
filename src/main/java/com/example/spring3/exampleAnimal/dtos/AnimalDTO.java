package com.example.spring3.exampleAnimal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
    private String patas;
    private String sonido;
    private String nombreObj;
}
