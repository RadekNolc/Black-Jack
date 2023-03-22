package cz.radeknolc.java.models;

import java.util.Scanner;

public class Session {

    private Scanner scanner;
    private Player player;
    private Player dealer;
    private CardDeck sessionDeck;

    public Session(Player player, Player dealer, CardDeck cardDeck) {
        this.player = player;
        this.dealer = dealer;
        sessionDeck = cardDeck;
    }

    public void start() {
        scanner = new Scanner(System.in);
        boolean isGameEnd = false;

        System.out.printf("Welcome to the Black-Jack by Radek Nolč\n");

        // Dealer is taking cards from deck
        dealer.takeCard(sessionDeck);
        dealer.takeCard(sessionDeck);
        // Player is taking cards from deck
        player.takeCard(sessionDeck);
        player.takeCard(sessionDeck);

        do {
            if (dealer.getCards().getTotalValue() > 21 || player.getCards().getTotalValue() > 21) {
                Player winner = player.getCards().getTotalValue() > 21 ? dealer : player;
                printWinner(winner);
                isGameEnd = true;
            }

            // Checking Black-Jack / 21
            if (player.hasTwentyOne() && dealer.hasTwentyOne()) {
                printDraw();
                isGameEnd = true;
            } else if (player.hasTwentyOne() || dealer.hasTwentyOne()) {
                Player winner = player.hasTwentyOne() ? player : dealer;
                printWinner(winner);
                isGameEnd = true;
            }
            // Printing state of the game
            printState(isGameEnd);

            if (!isGameEnd) {
                String input = "";
                do {
                    System.out.println("Type:");
                    System.out.printf("\tN: New card\n");
                    System.out.printf("\tS: Stand\n");
                    System.out.printf("\tQ: Quit game\n");
                    System.out.print("Your input: ");
                    input = scanner.next();
                } while (!(input.equals("N") || input.equals("S") || input.equals("Q")));

                switch (input.toUpperCase()) {
                    case "N" -> player.takeCard(sessionDeck);
                    case "S" -> {
                        while (dealer.getCards().getTotalValue() < 17) {
                            dealer.takeCard(sessionDeck);
                        }
                    }
                    case "Q" -> isGameEnd = true;
                }
            }

        } while (!isGameEnd);

    }

    public void printState(boolean showDealer) {
        System.out.println("############ STATE ############");
        System.out.printf("Dealer:\n");
        if (showDealer) {
            System.out.printf("\t" + dealer.getCards() + "\n");
            System.out.printf("\tValue: " + dealer.getCards().getTotalValue() + "\n");
        } else {
            System.out.printf("\tCard: " + dealer.getCards().getFirstCard() + "\n");
            System.out.printf("\tValue: " + dealer.getCards().getFirstCard().getValue() + "\n");
        }

        System.out.printf("You:\n");
        System.out.printf("\t" + player.getCards() + "\n");
        System.out.printf("\tValue: " + player.getCards().getTotalValue() + "\n");
        System.out.println("###############################");
        System.out.println();
    }

    public void printDraw() {
        System.out.println("It's a draw!");
    }

    public void printWinner(Player winner) {
        System.out.println(winner.getName() + " is winner!");
    }
}
