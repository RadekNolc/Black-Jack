package cz.radeknolc.java.models;

public class Player {

    private String name;
    private boolean isNpc;
    private double money;
    private CardDeck cards;

    public Player(String name, boolean isNpc, double money) {
        this.name = name;
        this.isNpc = isNpc;
        this.money = money;
        cards = new CardDeck();
    }

    public boolean hasTwentyOne() {
        return cards.getTotalValue() == 21;
    }

    public void takeCard(CardDeck targetDeck) {
        try {
            cards.add(targetDeck.poll());
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public CardDeck getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
}
