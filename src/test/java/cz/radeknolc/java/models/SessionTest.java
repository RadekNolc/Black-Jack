package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.enums.CardRank;
import cz.radeknolc.java.enums.CardSuit;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class SessionTest {

    Person player;
    Person dealer;
    CardDeck cardDeck;
    Session session;
    CardDeck rubbishBin; // Used for giving away

    @BeforeEach
    void beforeEach() {
        player = new Player("Player", 10000);
        dealer = new Dealer("Dealer");
        cardDeck = Generator.generateDeck();
        session = new Session(player, dealer, cardDeck);
        rubbishBin = new CardDeck();
    }

    @Test
    void testCompare() {
        Card[] cards = new Card[10];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Generator.generateCard(i+1);
        }

        // Testing 21 for player
        player.takeCard(cards[0]); // A
        player.takeCard(cards[9]); // 10

        dealer.takeCard(cards[5]); // 6
        dealer.takeCard(cards[4]); // 5

        Assertions.assertEquals(player, session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing 22 for player
        player.takeCard(cards[6]); // 7
        player.takeCard(cards[6]); // 7
        player.takeCard(cards[6]); // 7
        player.takeCard(cards[0]); // A

        dealer.takeCard(cards[0]); // A

        Assertions.assertEquals(dealer, session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing 19 player vs 18 dealer
        player.takeCard(cards[9]); // 10
        player.takeCard(cards[8]); // 9

        dealer.takeCard(cards[9]); // 10
        dealer.takeCard(cards[7]); // 8
        Assertions.assertEquals(player, session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing 20 player vs 20 dealer
        player.takeCard(cards[9]); // 10
        player.takeCard(cards[9]); // 10

        dealer.takeCard(cards[9]); // 10
        dealer.takeCard(cards[9]); // 10
        Assertions.assertNull(session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing 21 for dealer
        dealer.takeCard(cards[0]); // A
        dealer.takeCard(cards[9]); // 10

        player.takeCard(cards[5]); // 6
        player.takeCard(cards[4]); // 5

        Assertions.assertEquals(dealer, session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing 22 for dealer
        dealer.takeCard(cards[6]); // 7
        dealer.takeCard(cards[6]); // 7
        dealer.takeCard(cards[6]); // 7
        dealer.takeCard(cards[0]); // A

        player.takeCard(cards[0]); // A

        Assertions.assertEquals(player, session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing 18 player vs 19 dealer
        dealer.takeCard(cards[9]); // 10
        dealer.takeCard(cards[8]); // 9

        player.takeCard(cards[9]); // 10
        player.takeCard(cards[7]); // 8
        Assertions.assertEquals(dealer, session.compare(true));
        player.returnCards(rubbishBin); dealer.returnCards(rubbishBin);

        // Testing not evaluating winner
        player.takeCard(cards[6]); // 7
        player.takeCard(cards[0]); // A

        dealer.takeCard(cards[6]); // 7
        dealer.takeCard(cards[1]); // 2
        dealer.takeCard(cards[7]); // 8
        Assertions.assertNull(session.compare(false));

    }
}
