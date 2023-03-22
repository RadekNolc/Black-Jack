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

    public int getValue() {
        return switch(cardRank) {
            case RANK_2 -> 2;
            case RANK_3 -> 3;
            case RANK_4 -> 4;
            case RANK_5 -> 5;
            case RANK_6 -> 6;
            case RANK_7 -> 7;
            case RANK_8 -> 8;
            case RANK_9 -> 9;
            case RANK_10, RANK_J, RANK_Q, RANK_K -> 10;
            case RANK_A -> 11; //TODO: Fix ACE as value 1
        };
    }

    @Override
    public String toString() {
        //return String.format("Rank: %s | Suit: %s", cardRank.toString(), cardSuit.toString());
        return String.format(cardRank.toString().replace("RANK_", "") + " (" + cardSuit.toString().replace("SUIT_", "") +")");
    }
}

