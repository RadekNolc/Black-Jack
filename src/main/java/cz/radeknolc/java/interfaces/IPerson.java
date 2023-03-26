package cz.radeknolc.java.interfaces;

import cz.radeknolc.java.models.CardDeck;

public interface IPerson {

    String getName();
    CardDeck getCards();
    void takeCard(CardDeck sourceDeck);
    void returnCards(CardDeck targetDeck);

}
