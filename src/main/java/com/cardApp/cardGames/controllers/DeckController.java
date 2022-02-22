package com.cardApp.cardGames.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {
    
    @GetMapping("/newDeck")
    public ResponseEntity<?> createNewDeck(){
        return null;
    }
    
}
