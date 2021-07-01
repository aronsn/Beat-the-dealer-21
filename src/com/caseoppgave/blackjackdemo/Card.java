package com.caseoppgave.blackjackdemo;


public class Card {
    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }
    public String toString() {
        String[] values = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String cardOutput = suits[this.suit] + values[this.value];

        return cardOutput;
    }
}
