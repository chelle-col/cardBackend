package com.cardApp.cardGames.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.cardApp.cardGames.entities.Card;
import com.cardApp.cardGames.entities.Deck;
import com.cardApp.cardGames.exceptions.NotFoundException;
import com.cardApp.cardGames.pojos.DeckDrawResponse;
import com.cardApp.cardGames.pojos.DeckResponseBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deck")
public class DeckController {
    Map<UUID, Deck> decks = new HashMap<UUID, Deck>();
    {
        decks.put(UUID.fromString("177eafca-93ff-11ec-b909-0242ac120002"), new Deck());
    }
    private int expiresIn = 25;

    @PostMapping("/newDeck")
    public ResponseEntity<?> createNewDeck(@RequestParam(required = false) Boolean shuffle){
        Deck newDeck = new Deck();
        UUID id = UUID.randomUUID();
        decks.put(id, newDeck);
        if(shuffle != null && shuffle){
            newDeck.shuffle();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new DeckResponseBody(
                newDeck.getCreatedAt(), 
                newDeck.getCreatedAt().plusDays(expiresIn), 
                newDeck, 
                id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getDeck(@RequestParam String id){
        UUID uuid = UUID.fromString(id);
        Deck deck = decks.get(uuid);
        if(deck == null) throw new NotFoundException("Deck with id "+ id +" not Found. To make new deck send get request to /deck/newDeck");
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new DeckResponseBody(
                deck.getCreatedAt(),
                deck.getCreatedAt().plusDays(expiresIn), 
                deck, 
                uuid));
    }
    
    @GetMapping("/draw")
    public ResponseEntity<?> drawDeck(
            @RequestParam String id, 
            @RequestParam(required = false) Boolean fromBottom
        ){
        UUID uuid = UUID.fromString(id);
        Deck deck = decks.get(uuid);
        Card card;
        if(fromBottom){
            card = deck.drawBottomCard();
        }else{
            card = deck.drawTopCard();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new DeckDrawResponse(
                deck.getCreatedAt(), 
                deck.getCreatedAt().plusDays(expiresIn), 
                deck, 
                uuid,
                card));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDeck(@RequestParam String id){
        UUID uuid = UUID.fromString(id);
        Deck deck = decks.remove(uuid);
        if(deck == null) throw new NotFoundException("No Deck with id of " + id + " found.");
        return ResponseEntity.status(HttpStatus.OK).body(id + " successfully deleted");
    }
}
