package com.example.spring3.respositories;

import com.example.spring3.dtos.request.IngredientDTO;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface CalculatorCalorieRepository {
    public List<IngredientDTO> findCalories(List<IngredientDTO> listaIng);
    public double findCaloriesIngredient(IngredientDTO ing);
}
