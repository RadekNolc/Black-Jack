package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.enums.CardRank;
import cz.radeknolc.java.helpers.Link;
import cz.radeknolc.java.helpers.Queue;

public class CardDeck extends Queue<Card> {

    public void shuffle() {
        Card[] cardArray = new Card[getCount()];
        for (int i = 0; i < cardArray.length; i++) {
            cardArray[i] = poll();
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

    public Card getCard(int index) {
        Link<Card> it = first;
        int idx = 0;

        while (idx < index && it != null) {
            it = it.next;
            idx++;
        }

        return it.data;
    }

    public int getTotalValue() {
        int sum = 0;
        int aces = 0;

        Link<Card> it = first;
        while (it != null) {
            sum += it.data.getValue();
            if (it.data.getCardRank().equals(CardRank.RANK_A)) {
                aces++;
            }
            it = it.next;
        }

        if (sum > 21) { //Check for ACEs -> replace them for 1
            sum -= (aces * 10);
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
