package com.caseoppgave.blackjackdemo;

import java.util.*;

public class Deck {
    //Instance variables
    private ArrayList<Card> cards;

    //Konstruktøren
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        //Generer bunke
        for(Suit suit : Suit.values()) {
            for(Value value : Value.values()) {
                //Legger til nye kort
                this.cards.add(new Card(suit, value));
            }// løkke - value
        }// løkke - suit

        //Shuffler bunken
        Collections.shuffle(this.cards);
    }

    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for(Card card : this.cards) {
            cardListOutput += "\n" + i + " " + card.toString();
            i++;
        }
        return cardListOutput;
    }
}
