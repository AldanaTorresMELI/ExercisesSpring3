package com.example.spring3.starWars.repositories;

import com.example.spring3.starWars.dtos.request.CharacterDTO;

import java.util.List;

public interface StarWarsRepository {
    public List<CharacterDTO> findName(String name);
}
