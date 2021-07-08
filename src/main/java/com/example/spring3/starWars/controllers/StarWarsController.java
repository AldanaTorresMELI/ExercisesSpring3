package com.example.spring3.starWars.controllers;

import com.example.spring3.starWars.dtos.request.CharacterDTO;
import com.example.spring3.starWars.services.StarWarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/getAll/{name}")
    public List<CharacterDTO> getAllCharacters(@Valid @PathVariable("name") String name){
        return starWarsService.getName(name);
    }
}
