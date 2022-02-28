package com.cardApp.cardGames.entities;

public class Card {
    private int number;
    private String card;
    private String imgUrl;


    public Card(int number, String card, String imgUrl) {
        this.number = number;
        this.card = card;
        this.imgUrl = imgUrl;
    }

    public int getNumber() {
        return this.number;
    }

    public String getCard() {
        return this.card;
    }

    public String getImgUrl(){
        return this.imgUrl;
    }

    @Override
    public String toString() {
        return "{" +
            " number=" + getNumber() + "" +
            ", card=" + getCard() + "" +
            "}";
    }


}
