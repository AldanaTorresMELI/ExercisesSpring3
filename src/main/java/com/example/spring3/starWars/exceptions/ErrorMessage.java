package com.example.spring3.starWars.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorMessage {
    private Integer status;
    private String error;
    private Map<String, String> message;

    public ErrorMessage(){

    }

    public ErrorMessage(Integer status, String error, Map<String, String> message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }


}
