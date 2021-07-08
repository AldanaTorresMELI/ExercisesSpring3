package com.example.spring3.starWars.repositories;

import com.example.spring3.caloriesCalculator.dtos.request.IngredientDTO;
import com.example.spring3.starWars.dtos.request.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository{
    @Override
    public List<CharacterDTO> findName(String name) {
        List<CharacterDTO> characterDTOS;
        characterDTOS = loadDatabase();

        List<CharacterDTO> result = characterDTOS.stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
        return result;
    }

    private List<CharacterDTO> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/starwars_characters.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }

    private List<CharacterDTO> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeReference = new TypeReference<>(){};
        List<CharacterDTO> starwars = null;
        try {
            starwars = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }

        return starwars;
    }
}
