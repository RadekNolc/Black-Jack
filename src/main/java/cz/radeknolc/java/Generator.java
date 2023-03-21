package cz.radeknolc.java;

import cz.radeknolc.java.enums.CardRank;
import cz.radeknolc.java.enums.CardSuit;
import cz.radeknolc.java.models.Card;
import cz.radeknolc.java.models.CardDeck;

import java.util.Random;

public class Generator {

    public static Random random = new Random();

    public static CardDeck generateDeck() {
        CardDeck cardDeck = new CardDeck();
        for (int i = 1; i <= 4; i++) {
            CardSuit suit = null;
            switch(i) {
                case 1 -> suit = CardSuit.SUIT_SPADES;
                case 2 -> suit = CardSuit.SUIT_HEARTS;
                case 3 -> suit = CardSuit.SUIT_CLUBS;
                case 4 -> suit = CardSuit.SUIT_DIAMONDS;
            }

            Card[] cards = new Card[] {
                    new Card(CardRank.RANK_2, suit),
                    new Card(CardRank.RANK_3, suit),
                    new Card(CardRank.RANK_4, suit),
                    new Card(CardRank.RANK_5, suit),
                    new Card(CardRank.RANK_6, suit),
                    new Card(CardRank.RANK_7, suit),
                    new Card(CardRank.RANK_8, suit),
                    new Card(CardRank.RANK_9, suit),
                    new Card(CardRank.RANK_10, suit),
                    new Card(CardRank.RANK_J, suit),
                    new Card(CardRank.RANK_Q, suit),
                    new Card(CardRank.RANK_K, suit),
                    new Card(CardRank.RANK_A, suit)
            };

            for (Card card : cards) {
                cardDeck.add(card);
            }
        }

        return cardDeck;
    }
}
