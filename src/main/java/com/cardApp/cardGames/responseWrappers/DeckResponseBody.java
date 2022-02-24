package com.cardApp.cardGames.responseWrappers;

import java.time.LocalDateTime;
import java.util.UUID;

import com.cardApp.cardGames.entities.Deck;

public class DeckResponseBody {
    private LocalDateTime createdAt;
    private LocalDateTime expiresOn;
    private Deck deck;
    private UUID id;

    public DeckResponseBody(LocalDateTime createdAt, LocalDateTime expiresAt, Deck deck, UUID id) {
        this.createdAt = createdAt;
        this.expiresOn = expiresAt;
        this.deck = deck;
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getExpiresOn() {
        return this.expiresOn;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public UUID getId() {
        return this.id;
    }
}
