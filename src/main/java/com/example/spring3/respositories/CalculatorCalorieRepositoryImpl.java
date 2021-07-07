package com.example.spring3.respositories;

import com.example.spring3.dtos.request.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CalculatorCalorieRepositoryImpl implements CalculatorCalorieRepository{

    @Override
    public List<IngredientDTO> findCalories(List<IngredientDTO> listaIng){
        List<IngredientDTO> ingredientDTOS;
        ingredientDTOS = loadDatabase();

        List<IngredientDTO> result = ingredientDTOS.stream().filter(ing -> listaIng.contains(ing)).collect(Collectors.toList());
        return result;
    }

    @Override
    public double findCaloriesIngredient(IngredientDTO ing) {
        List<IngredientDTO> ingredientDTOS;
        ingredientDTOS = loadDatabase();
        IngredientDTO result = null;
        double calories = 0;

        if(Objects.nonNull(ingredientDTOS)){
            Optional<IngredientDTO> item = ingredientDTOS.stream().filter(ingred -> ingred.getName().equals(ing.getName())).findFirst();
            if (item.isPresent()){
                result = item.get();
                calories = result.getCalories();
            }
        }

        return calories;
    }

    private List<IngredientDTO> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/food.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }

    private List<IngredientDTO> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeReference = new TypeReference<>(){};
        List<IngredientDTO> ingredientDTOS = null;
        try {
            ingredientDTOS = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }

        return ingredientDTOS;
    }
}
