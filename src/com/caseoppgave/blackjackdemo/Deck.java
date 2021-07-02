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
    }

    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();

        //Bruker Random
        Random random = new Random();

        int randomCardCardIndex = 0;
        int originalSize = this.cards.size();

        for(int i = 0; i < originalSize; i++) {
            //Genererer tilfeldig indeks
            randomCardCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            tempDeck.add(this.cards.get(randomCardCardIndex));
            //Remove from original deck
            this.cards.remove(randomCardCardIndex);
        }
        this.cards = tempDeck;
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    //Trekker et kort fra bunken
    public void draw(Deck deck) {
        this.cards.add(deck.getCard(0));
        deck.removeCard(0);
    }

    public String toString() {
        String cardListOutput = "";

        for(Card card : this.cards) {
            cardListOutput += "\n" + " " + card.toString();
        }
        return cardListOutput;
    }
}
