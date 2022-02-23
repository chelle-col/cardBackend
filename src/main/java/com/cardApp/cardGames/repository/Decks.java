package com.cardApp.cardGames.repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.cardApp.cardGames.entities.Deck;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Decks {
    Map<UUID, Deck> decks = new HashMap<UUID, Deck>();
    {
        UUID id = UUID.fromString("177eafca-93ff-11ec-b909-0242ac120002");
        decks.put(id, new Deck(1));
    }

    public UUID add(Deck d){
        decks.put(d.getId(), d);
        return d.getId();
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

    @Scheduled( fixedRate = 10000 )
    //86400000
    public void printing(){
        Deck[] deckArray = (Deck[]) decks.values().toArray();
        for(Deck d : deckArray){
            if(d.getExpiresOn().isBefore(LocalDateTime.now())){
                decks.remove(d.getId());
            }
        }
        System.out.println("Fixed delay");
    }
}
