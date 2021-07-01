package com.caseoppgave.blackjackdemo;

public class Blackjack {
    public static void main(String[] args) {

        // Velkomst melding
        System.out.println("Welcome to Blackjack");

        //Oppretter spillebunken
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        System.out.println((playingDeck));
    }
}
