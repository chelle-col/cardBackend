package com.cardApp.cardGames.controllers;

import com.cardApp.cardGames.exceptions.RequestException;
import com.cardApp.cardGames.pojos.ExceptionResopnse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RequestException.class)
    public ResponseEntity<?> nullPointer(RequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResopnse(ex.getMessage()));
    }
}
