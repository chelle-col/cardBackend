package com.cardApp.cardGames.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();
    private LocalDateTime createdAt;
    private LocalDateTime expiresOn;
    private UUID id;

    private String[] suits = {"Spade", "Club", "Heart", "Diamond"};
    private String[] cardNumbers = {"Ace", "Two", "Three", "Four",
         "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    private List<Card> discard = new ArrayList<Card>();

    {
        int idx = 0;
        for(String suit : suits){
            for(String cardNum : cardNumbers){
                cards.add(new Card( idx, cardNum + " of " + suit + "s" ));
                idx++;
            }
        }
    }


    public Deck(long days) {
        createdAt = LocalDateTime.now();
        expiresOn = LocalDateTime.now().plusDays(days);
        this.id = UUID.randomUUID();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card drawTopCard(){
        Card c = cards.remove(0);
        discard.add(c);
        return c;
    }

    public Card drawBottomCard(){
        Card c = cards.remove(cards.size()-1);
        discard.add(c);
        return c;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public List<Card> getDeck(){
        return cards;
    }

    public List<Card> getDiscard(){
        return discard;
    }


    public List<Card> getCards() {
        return this.cards;
    }

    public String[] getCardNumbers() {
        return this.cardNumbers;
    }

    public LocalDateTime getExpiresOn(){
        return expiresOn;
    }

    public UUID getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "{" +
            " cards='" + getCards() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", discard='" + getDiscard() + "'" +
            "}";
    }

}
