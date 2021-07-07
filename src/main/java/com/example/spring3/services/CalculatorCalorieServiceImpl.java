package com.example.spring3.services;

import com.example.spring3.dtos.request.IngredientDTO;
import com.example.spring3.dtos.request.PlateDTO;
import com.example.spring3.dtos.response.PlateResponseDTO;
import com.example.spring3.respositories.CalculatorCalorieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorCalorieServiceImpl implements CalculatorCalorieService{

    CalculatorCalorieRepository calculatorCalorieRepository;

    @Override
    public PlateResponseDTO calculate(PlateDTO plate) {
        List<IngredientDTO> list = new ArrayList<>();
        for(IngredientDTO i : plate.getIngredients()){
            list.add(calculateCaloriesIng(i));
        }

        PlateResponseDTO response = new PlateResponseDTO(
                calculateCaloriesPlate(plate),
                list,
                moreCalories(plate)
                );
        return response;
    }

    public CalculatorCalorieServiceImpl(CalculatorCalorieRepository calculatorCalorieRepository) {
        this.calculatorCalorieRepository = calculatorCalorieRepository;
    }

    public double calculateCaloriesPlate(PlateDTO plate) {
        double total = 0;
        for(IngredientDTO ingredient : plate.getIngredients()){
            total += (ingredient.getWeight()/100)* calculatorCalorieRepository.findCaloriesIngredient(ingredient);
        }
        return total;
    }

    public IngredientDTO calculateCaloriesIng(IngredientDTO ingredientDTO) {
        double total = (ingredientDTO.getWeight()/100) * (calculatorCalorieRepository.findCaloriesIngredient(ingredientDTO));
        ingredientDTO.setCalories(total);
        return ingredientDTO;

    }

    public IngredientDTO moreCalories(PlateDTO plate) {
        IngredientDTO moreCalories = plate.getIngredients().get(0);
        for(IngredientDTO ingredient : plate.getIngredients()){
            if(calculatorCalorieRepository.findCaloriesIngredient(ingredient) > moreCalories.getCalories()){
                moreCalories = ingredient;
            }
        }
        return moreCalories;
    }


}
