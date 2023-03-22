package cz.radeknolc.java;

import cz.radeknolc.java.models.CardDeck;
import cz.radeknolc.java.models.Player;
import cz.radeknolc.java.models.Session;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("Radek Nolč", false, 1000);
        Player dealer = new Player("Dealer", true, 0);
        CardDeck deck = Generator.generateDeck();
        deck.shuffle();

        Session session = new Session(player, dealer, deck);
        session.start();
    }
}