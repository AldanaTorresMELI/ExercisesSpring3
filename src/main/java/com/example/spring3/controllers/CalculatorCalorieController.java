package com.example.spring3.controllers;

import com.example.spring3.dtos.request.PlateDTO;
import com.example.spring3.dtos.response.PlateResponseDTO;
import com.example.spring3.services.CalculatorCalorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/calories")
public class CalculatorCalorieController {

    CalculatorCalorieService calculatorCalorieService;

    public CalculatorCalorieController(CalculatorCalorieService calculatorCalorieService) {
        this.calculatorCalorieService = calculatorCalorieService;
    }

    @PostMapping("/plate")
    public ResponseEntity<PlateResponseDTO> plate(@Valid @RequestBody PlateDTO plate){
        return new ResponseEntity<>(calculatorCalorieService.calculate(plate), HttpStatus.OK);
    }
}
