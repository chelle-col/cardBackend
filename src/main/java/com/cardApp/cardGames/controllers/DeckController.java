package com.cardApp.cardGames.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.cardApp.cardGames.entities.Deck;
import com.cardApp.cardGames.pojos.DeckResponseBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {
    Map<UUID, Deck> decks = new HashMap<UUID, Deck>();

    @GetMapping("/newDeck")
    public ResponseEntity<?> createNewDeck(){
        Deck newDeck = new Deck();
        UUID id = UUID.randomUUID();
        decks.put(id, newDeck);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new DeckResponseBody(
                newDeck.getCreatedAt(), 
                newDeck.getCreatedAt().plusDays(25), 
                newDeck, 
                id));
    }
    
}
