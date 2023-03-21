package cz.radeknolc.java.models;

import cz.radeknolc.java.enums.CardRank;
import cz.radeknolc.java.enums.CardSuit;

public class Card {

    CardRank cardRank;
    CardSuit cardSuit;

    public Card(CardRank rank, CardSuit suit) {
        cardRank = rank;
        cardSuit = suit;
    }

    @Override
    public String toString() {
        return String.format("Rank: %s | Suit: %s", cardRank.toString(), cardSuit.toString());
    }
}

