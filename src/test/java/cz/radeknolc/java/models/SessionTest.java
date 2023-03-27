package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.enums.CardRank;
import cz.radeknolc.java.enums.CardSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class SessionTest {

    @Test
    public void testCompare() {
        CardDeck cardDeck = new CardDeck();

        Player player = new Player("Player", false, 10000);
        Player dealer = new Player("Dealer", true, 0);

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

        player.takeCard(cardDeck); // Taking 2
        player.takeCard(cardDeck); // Taking 3
        player.takeCard(cardDeck); // Taking 4
        player.takeCard(cardDeck); // Taking 5
        player.takeCard(cardDeck); // Taking 6

        dealer.takeCard(cardDeck); // Taking 7
        dealer.takeCard(cardDeck); // Taking 8
        dealer.takeCard(cardDeck); // Taking 9

        Assertions.assertEquals(player, new Session(player, dealer, cardDeck).compare());

        player.returnCards(cardDeck);
        dealer.returnCards(cardDeck);

        player.takeCard(cardDeck); // Taking 10
        player.takeCard(cardDeck); // Taking J

        dealer.takeCard(cardDeck); // Taking Q
        dealer.takeCard(cardDeck); // Taking K

        Assertions.assertEquals(null, new Session(player, dealer, cardDeck).compare());
    }
}
