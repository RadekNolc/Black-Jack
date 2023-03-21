package cz.radeknolc.java;

import cz.radeknolc.java.models.CardDeck;

public class Data {

    private static CardDeck activeDeck;

    public static CardDeck getActiveDeck() {
        return activeDeck;
    }

    public static void setActiveDeck(CardDeck deck) {
        activeDeck = deck;
    }
}
