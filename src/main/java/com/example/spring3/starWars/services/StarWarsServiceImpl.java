package com.example.spring3.starWars.services;

import com.example.spring3.starWars.dtos.request.CharacterDTO;
import com.example.spring3.starWars.repositories.StarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService{

    StarWarsRepository starWarsRepository;

    public StarWarsServiceImpl(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    @Override
    public List<CharacterDTO> getName(String name) {
        return starWarsRepository.findName(name);
    }
}
