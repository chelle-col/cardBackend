package com.cardApp.cardGames.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.cardApp.cardGames.entities.Deck;

import org.springframework.stereotype.Service;

@Service
public class Decks {
    Map<UUID, Deck> decks = new HashMap<UUID, Deck>();
    {
        decks.put(UUID.fromString("177eafca-93ff-11ec-b909-0242ac120002"), new Deck());
    }
    public UUID add(Deck d){
        UUID id = UUID.randomUUID();
        decks.put(id, d);
        return id;
    }

    public Deck findDeckByID(UUID id){
        return decks.get(id);
    }

    public boolean remove(UUID id){
        Deck d = decks.remove(id);
        if(d == null){
            return false;
        }
        return true;
    }
}
