package com.cardApp.cardGames.entities;

public class Card {
    private int number;
    private String card;


    public Card(int number, String card) {
        this.number = number;
        this.card = card;
    }

    public int getNumber() {
        return this.number;
    }

    public String getCard() {
        return this.card;
    }

    @Override
    public String toString() {
        return "{" +
            " number=" + getNumber() + "" +
            ", card=" + getCard() + "" +
            "}";
    }


}
