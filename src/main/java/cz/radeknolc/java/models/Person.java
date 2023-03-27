package cz.radeknolc.java.models;

import cz.radeknolc.java.interfaces.IPerson;

public class Person implements IPerson {

    private String name;
    protected CardDeck cards;

    public Person(String name) {
        this.name = name;
        this.cards = new CardDeck();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void returnCards(CardDeck targetDeck) {
        while (cards.getCount() != 0) {
            targetDeck.add(cards.poll());
        }
    }

    @Override
    public void takeCard(CardDeck sourceDeck) {
        cards.add(sourceDeck.poll());
    }

    public void takeCard(Card card) {
        cards.add(card);
    }

    @Override
    public CardDeck getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return getName();
    }
}
