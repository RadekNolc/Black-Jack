package cz.radeknolc.java;

import cz.radeknolc.java.models.CardDeck;

public class Main {
    public static void main(String[] args) {
        CardDeck deck = Generator.generateDeck();
        deck.shuffle();
        System.out.println("Test");
    }
}