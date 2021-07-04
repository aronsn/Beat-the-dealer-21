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

    public int deckSize() {
        return this.cards.size();
    }

    public void moveAllTodeck(Deck deck) {
        int thisDeckSize = this.cards.size();

        //Put cards into moveTo deck
        for(int i = 0; i < thisDeckSize; i++) {
            deck.addCard(this.getCard(i));
        }

        for(int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }
    }

    //Returnerer den totale verdien av kort i en bunke
    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;

        for(Card card : this.cards) {
            switch(card.getValue()) {
                case TWO : totalValue += 2;
                    break;
                case THREE: totalValue += 3;
                    break;
                case FOUR: totalValue += 4;
                    break;
                case FIVE: totalValue += 5;
                    break;
                case SIX: totalValue += 6;
                    break;
                case SEVEN: totalValue += 7;
                    break;
                case EIGHT: totalValue += 8;
                    break;
                case NINE: totalValue += 9;
                    break;
                case TEN: totalValue += 10;
                    break;
                case JACK: totalValue += 10;
                    break;
                case QUEEN: totalValue += 10;
                    break;
                case KING: totalValue += 10;
                    break;
                case ACE: totalValue += 11;
                    break;

            }
        }

        return totalValue;
    }

    public String toString() {
        String cardListOutput = "";

        for(Card card : this.cards) {
            cardListOutput += "\n" + " " + card.toString();
        }
        return cardListOutput;
    }
}
