package com.caseoppgave.blackjackdemo;

public enum Suit {
    CLUB("C"), SPADE("S"), DIAMOND("D"), HEART("H");

    private final String suitOutput;

    Suit(final String suitOutput) {
        this.suitOutput = suitOutput;

    }

    @Override
    public String toString() {
        return suitOutput;
    }
}
