package com.caseoppgave.blackjackdemo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Blackjack {
    public static void main(String[] args) {

        // Velkomst melding
        System.out.println("Welcome to Blackjack");

        //Oppretter spillebunken
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        //Oppretter hånda for spilleren
        Deck sam = new Deck();
        Deck dealer = new Deck();

        sam.draw(playingDeck);
        dealer.draw(playingDeck);
        sam.draw(playingDeck);
        dealer.draw(playingDeck);

        System.out.println("Sams:");
        System.out.println(sam.toString());

        System.out.println("Dealer:" + dealer.getCard(0).toString() + dealer.getCard(1).toString());

        System.out.println("Dealer:");
        System.out.println(dealer.toString());


        //Card aCard = new Card(Suit.DIAMOND, Value.EIGHT);

        //System.out.println(aCard.getValue());
        //System.out.println(Value.JACK.toString());

        //Sytem.out.println(playingDeck);







    }
}
