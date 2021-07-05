package com.caseoppgave.blackjackdemo;

import java.util.List;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Write a filename for the program to initialize a deck of cards: ");
        String FILENAME = userInput.nextLine();

        //Oppretter spillebunken, spillere
        Deck playingDeck = new Deck();

        try {
            playingDeck.createFullDeckFromFile(FILENAME);
        } catch (Exception e) { }

        if(playingDeck.deckSize() == 0) {
            System.out.println("\nDid not find file, initializing new deck of cards: ");
            playingDeck.createFullDeck();
            playingDeck.shuffle();
        }


        // Presenterer spillbunken
        System.out.println(playingDeck.toString());

        //Oppretter spillerene: Sam og Dealer
        Deck sam = new Deck();
        Deck dealer = new Deck();


        System.out.println("\nDo want to run a game of Blackjack? (y)es or (n)o");
        String play = userInput.nextLine();

        // Blackjack Start - Spilløkka
        while (play.equals("y")) {

            // Løkke for å dele ut kort annen hver gang til hver spiller så lenge de har mindre enn 2 kort i hånden
            while(sam.deckSize() < 2 && dealer.deckSize() < 2) {
                sam.draw(playingDeck);
                dealer.draw(playingDeck);

                System.out.println("Sam: " + sam.toString() + " Dealer: " + dealer.toString() + "\n");
            }

            // Hvis både Sam og Dealer to starter med Blackjack, da går seier til Sam
            if(sam.cardsValue() == 21 && dealer.cardsValue() == 21) {
                System.out.println("[Sam] Sam: " + sam.toString() + " Dealer: " + dealer.toString());
                break;
            }

            // Hvis både Sam og Dealer to starter med dobbel Ess, da går seier til Dealer
            if(sam.cardsValue() == 22 && dealer.cardsValue() == 22) {
                System.out.println("[Dealer] Sam: " + sam.toString() + " Dealer: " + dealer.toString());
                break;

            }

            //Løkke for å gjennomføre flere runder med korttrekking
            while(true) {
                // Hvis hånda til Sam er mer enn 21, går seier til Dealer og om Dealer har Blackjack
                if(sam.cardsValue() > 21 || dealer.cardsValue() == 21) {
                    System.out.println("[Dealer] Sam: " + sam.toString() + " Dealer: " + dealer.toString());
                    break;
                }

                // Hvis hånda til Dealer er mer enn 21, går seier til Sam og om Sam har Blackjack
                if(dealer.cardsValue() > 21 || sam.cardsValue() == 21) {
                    System.out.println("[Sam] Sam: " + sam.toString() + " Dealer: " + dealer.toString());
                    break;
                }



                // Kontrollerer om totale verdien i hånda til Sam er mindre enn eller er lik 17.
                // Hvis den ikke er det, skal han stoppe å trekke kort fra spillebunken.
                // Når Sam stopper å trekke kort, da begynner dealer å trekke kort fra spillebunken
                if(sam.cardsValue() < 17) {
                    sam.draw(playingDeck);
                    System.out.println("Sam: " + sam.toString() + " Dealer: " + dealer.toString() + "\n");

                    // Kontrollerer om dealer sin hånd er mindre enn Sam sin hånd.
                    // Hvis den er det, så skal Dealer slutte å trekke kort
                } else if(dealer.cardsValue() < sam.cardsValue()) {
                    dealer.draw(playingDeck);
                    System.out.println("Sam: " + sam.toString() + " Dealer: " + dealer.toString() + "\n");

                }

                // Hvis både Sam og Dealer har sluttet å trekke kort. Da blir hånda til begge spillere kontrollert
                // Den hånda som er nærmest 21, får denne rundens seier
                if(dealer.cardsValue() < 21 && sam.cardsValue() < 21) {
                    if(dealer.cardsValue() > sam.cardsValue()) {
                        System.out.println("[Dealer] Sam: " + sam.toString() + " Dealer: " + dealer.toString());
                        break;
                    } else if(dealer.cardsValue() < sam.cardsValue()) {
                        System.out.println("[Sam] Sam: " + sam.toString() + " Dealer: " + dealer.toString());
                        break;
                    }
                }



            }//Korttrekkingsrunder slutt

            //Skriver ut den sammenlagte verdien i hver hånd
            System.out.println("\nSam's hand: " + sam.cardsValue());
            System.out.println("Dealer's hand: " + dealer.cardsValue());


            sam.moveAllTodeck(playingDeck);
            dealer.moveAllTodeck(playingDeck);

            System.out.println("\nDo want to run a new game of Blackjack? (y)es or (n)o");
            play = userInput.nextLine();
        }// Blackjack slutt

    }
}
