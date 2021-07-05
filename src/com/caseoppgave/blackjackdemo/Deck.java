package com.caseoppgave.blackjackdemo;

import java.io.BufferedReader;
import java.util.*;
import com.caseoppgave.hjelpeklasse.Filehandling;

public class Deck {
    //Instanse variabler
    private ArrayList<Card> cards;

    //Konstruktøren
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    //
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    // Gir bunkens størrelse
    public int deckSize() {
        return this.cards.size();
    }

    // Trekker et kort fra toppen av bunken
    public void draw(Deck deck) {
        this.cards.add(deck.getCard(0));
        deck.removeCard(0);
    }



    public void createFullDeck() {
        //Genererer bunke
        for(Suit suit : Suit.values()) {
            for(Value value : Value.values()) {
                //Legger til nye kort
                this.cards.add(new Card(suit, value));
            }// løkke - value
        }// løkke - suit
    }

    // Metode for å lese fra fil og gjenopprette objekter
    public void createFullDeckFromFile(String filename) {
        // Passer på at ArrayList'en er tom
        cards.clear();

        try {
            BufferedReader infile = Filehandling.createReadConnection(filename);
            String searchCard = infile.readLine();
            StringTokenizer tokenizer = new StringTokenizer(searchCard, ", ");
            String card = tokenizer.nextToken();

            while(card != "") {

                String suitStr = card.substring(0, card.length()-1);
                String valueStr = card.substring(1, card.length());

                for( Suit suit : Suit.values()) {
                        for(Value value : Value.values()) {
                            if(suitStr.equals(suit.toString()) && valueStr.equals(value.toString())) {
                                    this.cards.add(new Card(suit, value));
                            }
                        }// løkke for verdi
                }// løkke for type

                card = tokenizer.nextToken();

            }// løkke for EOF

        } catch(Exception e) { }
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
            //Fjerner fra orginal bunken
            this.cards.remove(randomCardCardIndex);
        }
        this.cards = tempDeck;
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
        String strOfCards = "";

        for(Card card : this.cards) {
            strOfCards += card.toString() + ", ";
        }
        //Fjerner siste komma'en
        String cardListOutput = strOfCards.substring(0, strOfCards.length()-2);

        return cardListOutput;
    }
}
