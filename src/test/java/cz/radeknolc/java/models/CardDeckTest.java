package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.enums.CardRank;
import cz.radeknolc.java.enums.CardSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class CardDeckTest {

    @Test
    public void testTotalValue() {
        CardDeck cardDeck = new CardDeck(); //Creating deck to test
        //Creating cards to add into deck
        CardSuit suit = CardSuit.SUIT_CLUBS;
        Card card = new Card(CardRank.RANK_A, suit);
        cardDeck.add(card);
        Assertions.assertEquals(11, cardDeck.getTotalValue());


        cardDeck = new CardDeck(); //Creating new deck to test
        //Creating cards to add into deck
        card = new Card(CardRank.RANK_A, suit);
        cardDeck.add(card);
        card = new Card(CardRank.RANK_A, suit);
        cardDeck.add(card);
        Assertions.assertEquals(2, cardDeck.getTotalValue());

        cardDeck = new CardDeck(); //Creating new deck to test
        //Creating cards to add into deck
        card = new Card(CardRank.RANK_10, suit);
        cardDeck.add(card);
        card = new Card(CardRank.RANK_A, suit);
        cardDeck.add(card);
        Assertions.assertEquals(21, cardDeck.getTotalValue());

        cardDeck = Generator.generateDeck(); //Creating new deck to test
        Assertions.assertEquals((95*4)-(4*10), cardDeck.getTotalValue());
    }

    @Test
    public void testGetCard() {
        CardDeck cardDeck = new CardDeck();

        Card card1 = new Card(CardRank.RANK_Q, CardSuit.SUIT_HEARTS);
        Card card2 = new Card(CardRank.RANK_K, CardSuit.SUIT_DIAMONDS);
        Card card3 = new Card(CardRank.RANK_3, CardSuit.SUIT_CLUBS);
        Card card4 = new Card(CardRank.RANK_9, CardSuit.SUIT_DIAMONDS);
        Card card5 = new Card(CardRank.RANK_A, CardSuit.SUIT_CLUBS);
        Card card6 = new Card(CardRank.RANK_K, CardSuit.SUIT_HEARTS);
        Card card7 = new Card(CardRank.RANK_8, CardSuit.SUIT_SPADES);
        Card card8 = new Card(CardRank.RANK_Q, CardSuit.SUIT_SPADES);

        cardDeck.add(card1);
        cardDeck.add(card2);
        cardDeck.add(card3);
        cardDeck.add(card4);
        cardDeck.add(card5);
        cardDeck.add(card6);
        cardDeck.add(card7);
        cardDeck.add(card8);

        Assertions.assertEquals(card1, cardDeck.getCard(0));
        Assertions.assertEquals(card2, cardDeck.getCard(1));
        Assertions.assertEquals(card3, cardDeck.getCard(2));
        Assertions.assertEquals(card4, cardDeck.getCard(3));
        Assertions.assertEquals(card5, cardDeck.getCard(4));
        Assertions.assertEquals(card6, cardDeck.getCard(5));
        Assertions.assertEquals(card7, cardDeck.getCard(6));
        Assertions.assertEquals(card8, cardDeck.getCard(7));
    }
}
