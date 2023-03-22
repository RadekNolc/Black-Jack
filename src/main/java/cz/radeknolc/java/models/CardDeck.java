package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.helpers.Link;
import cz.radeknolc.java.helpers.Queue;

public class CardDeck extends Queue<Card> {

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

    public Card getFirstCard() {
        return first.data;
    }

    public int getTotalValue() {
        int sum = 0;

        Link<Card> it = first;
        while (it != null) {
            sum += it.data.getValue();
            it = it.next;
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Link<Card> it = first;
        while (it != null) {
            builder.append(it.data + " ");
            it = it.next;
        }

        return builder.toString();
    }
}
