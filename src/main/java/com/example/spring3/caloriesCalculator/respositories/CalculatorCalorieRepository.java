package com.example.spring3.caloriesCalculator.respositories;
import com.example.spring3.caloriesCalculator.dtos.request.IngredientDTO;

import java.util.List;

public interface CalculatorCalorieRepository {
    public List<IngredientDTO> findCalories(List<IngredientDTO> listaIng);
    public double findCaloriesIngredient(IngredientDTO ing);
}
