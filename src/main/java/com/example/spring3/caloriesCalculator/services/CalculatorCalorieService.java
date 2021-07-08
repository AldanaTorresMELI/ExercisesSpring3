package com.example.spring3.caloriesCalculator.services;

import com.example.spring3.caloriesCalculator.dtos.request.PlateDTO;
import com.example.spring3.caloriesCalculator.dtos.response.PlateResponseDTO;

public interface CalculatorCalorieService {
    //private final CalculatorCalorieRepository;

    public PlateResponseDTO calculate(PlateDTO plate);

}
