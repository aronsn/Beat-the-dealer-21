package com.caseoppgave.blackjackdemo;

import java.util.ArrayList;

public class Deck {

    //Instanser av klassen Card
    private ArrayList<Card> cards;

    //Konstruktøren
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        //Genererer kort
        for(Suit cardSuit : Suit.values()) {
            for(Value cardValues : Value.values()) {
                //Legger inn et nytt kort i bunken
                this.cards.add(new Card(cardSuit, cardValues));

            } // Løkke - cardvalues
        } //Løkke - cardsuit
    }

    @Override
    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for(Card aCard : this.cards){
            cardListOutput += "\n" + i + "-" + aCard.toString();
            i++;
        }
        return cardListOutput;

    }
}
