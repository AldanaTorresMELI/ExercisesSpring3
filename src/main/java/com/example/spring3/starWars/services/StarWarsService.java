package com.example.spring3.starWars.services;

import com.example.spring3.starWars.dtos.request.CharacterDTO;

import java.util.List;

public interface StarWarsService {
    List<CharacterDTO> getName(String name);
}
