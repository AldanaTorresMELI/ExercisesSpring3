package com.example.spring3.caloriesCalculator.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class PlateDTO {
    private String name;
    private List<IngredientDTO> ingredients;
}
