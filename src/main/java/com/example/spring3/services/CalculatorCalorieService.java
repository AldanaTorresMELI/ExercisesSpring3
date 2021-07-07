package com.example.spring3.services;

import com.example.spring3.dtos.request.IngredientDTO;
import com.example.spring3.dtos.request.PlateDTO;
import com.example.spring3.dtos.response.PlateResponseDTO;

public interface CalculatorCalorieService {
    //private final CalculatorCalorieRepository;

    public PlateResponseDTO calculate(PlateDTO plate);

}
