package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.helpers.Queue;

public class CardDeck extends Queue<Card> {

    public CardDeck() {

    }

    public void shuffle() {
        Card[] cardArray = new Card[getCount()];
        for (int i = 0; i < cardArray.length; i++) {
            try {
                cardArray[i] = poll();
            } catch (Exception exception) {}
        }

        for (int i = 0; i < cardArray.length; i++) {
            int randIdx = i + Generator.random.nextInt(cardArray.length - i);

            Card temp = cardArray[i];
            cardArray[i] = cardArray[randIdx];
            cardArray[randIdx] = temp;
        }

        for (Card card : cardArray) {
            add(card);
        }
    }
}
