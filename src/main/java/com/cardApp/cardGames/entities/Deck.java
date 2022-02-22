package com.cardApp.cardGames.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();
    private String[] suits = {"Spade", "Club", "Heart", "Diamond"};
    private String[] cardNumbers = {"Ace", "One", "Two", "Three", "Four",
         "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private List<Card> cardsDelt = new ArrayList<Card>();
    {
        int idx = 0;
        for(String suit : suits){
            for(String cardNum : cardNumbers){
                cards.add(new Card( idx, suit + " " + cardNum ));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card drawTopCard(){
        Card c = cards.remove(0);
        cardsDelt.add(c);
        return c;
    }

    public Card drawBottomCard(){
        Card c = cards.remove(cards.size()-1);
        cardsDelt.add(c);
        return c;
    }
}
