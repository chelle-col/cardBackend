package com.cardApp.cardGames.responseWrappers;

import java.time.LocalDateTime;
import java.util.UUID;

import com.cardApp.cardGames.entities.Card;
import com.cardApp.cardGames.entities.Deck;

public class DeckDrawResponse extends DeckResponseBody {
    private Card drawnCard;

    public DeckDrawResponse(LocalDateTime createdAt, LocalDateTime expiresAt, Deck deck, UUID id, Card card) {
        super(createdAt, expiresAt, deck, id);
        this.drawnCard = card;
    }
    
    public Card getCard(){
        return this.drawnCard;
    }
}
