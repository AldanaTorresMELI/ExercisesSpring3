package com.example.spring3.caloriesCalculator.dtos.response;

import com.example.spring3.caloriesCalculator.dtos.request.IngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlateResponseDTO {
    private double totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO moreCaloriesIngredient;
}
