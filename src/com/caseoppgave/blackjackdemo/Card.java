package com.caseoppgave.blackjackdemo;


import java.util.*;

public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }


    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {


        return this.suit.toString() + "" + this.value.toString();
    }

}
