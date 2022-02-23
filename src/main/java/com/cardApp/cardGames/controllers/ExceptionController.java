package com.cardApp.cardGames.controllers;

import com.cardApp.cardGames.exceptions.NotFoundException;
import com.cardApp.cardGames.pojos.ExceptionResopnse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> nullPointer(NullPointerException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResopnse(ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResopnse(ex.getMessage()));
    }
}
