package cz.radeknolc.java.models;

import cz.radeknolc.java.Generator;
import cz.radeknolc.java.Main;

import java.util.Scanner;

public class Session {

    private Player player;
    private Dealer dealer;
    private CardDeck sessionDeck;
    private double moneyBet;

    public Session(Person player) {
        this.player = (Player) player;
        this.dealer = new Dealer("Dealer");
        sessionDeck = Generator.generateDeck();
        sessionDeck.shuffle();
    }

    public Session(Person player, Person dealer, CardDeck cardDeck) {
        this.player = (Player) player;
        this.dealer = (Dealer) dealer;
        sessionDeck = cardDeck;
    }

    public Person compare(boolean evaluateWinner) {
        // Checking for busted
        if (player.getCards().getTotalValue() > 21 || dealer.getCards().getTotalValue() > 21) {
            return player.getCards().getTotalValue() > 21 ? dealer : player;
        }

        // Checking for Black Jack
        if (player.getCards().getTotalValue() == 21 || dealer.getCards().getTotalValue() == 21) {
            return player.getCards().getTotalValue() == 21 ? player : dealer;
        }

        if (evaluateWinner) {
            // Checking for matching value
            if (player.getCards().getTotalValue() == dealer.getCards().getTotalValue()) {
                return null;
            }

            return player.getCards().getTotalValue() > dealer.getCards().getTotalValue() ? player : dealer;
        } else {
            return null;
        }
    }

    public void start() {
        Main.scanner = new Scanner(System.in);
        Person winner = null;
        boolean isGameOver = false;
        int nextStep = 0;

        if (player.getMoney() == 0) {
            System.out.println("You do not have any money to bet.");
            return;
        }

        double bet = 0;
        do {
            System.out.printf("You currently have %.2f money. How much money do you want to bet? ", player.getMoney());
            bet = Main.scanner.nextDouble();
        } while (bet > player.getMoney());
        moneyBet = bet;
        player.setMoney(player.getMoney() - bet);

        System.out.println("Starting game...");
        dealer.takeCard(sessionDeck);
        dealer.takeCard(sessionDeck);
        player.takeCard(sessionDeck);
        player.takeCard(sessionDeck);
        if (compare(false) != null) {
            winner = compare(false);
            isGameOver = true;
        }
        printState(isGameOver);

        if (!isGameOver) {
            gameLoop: do {
                System.out.println("Possible inputs:");
                System.out.println("1: Get next card");
                System.out.println("2: Stand");
                System.out.println("Select what to do next:");
                nextStep = Main.scanner.nextInt();

                switch (nextStep) {
                    case 1 -> {
                        player.takeCard(sessionDeck);

                        if (compare(false) != null) {
                            winner = compare(false);
                            isGameOver = true;
                        }

                        printState(isGameOver);
                        if (isGameOver) {
                            break gameLoop;
                        }

                    }
                    case 2 -> {
                        while (dealer.getCards().getTotalValue() < 17) {
                            dealer.takeCard(sessionDeck);
                        }

                        isGameOver = true;
                        printState(isGameOver);
                        winner = compare(true);
                        break gameLoop;
                    }
                }
            } while ((nextStep < 1 || nextStep > 2) || nextStep != 2);
        }

        player.returnCards(sessionDeck);
        dealer.returnCards(sessionDeck);

        printWinner(winner);
        if (winner != null && winner == player) {
            player.setMoney(player.getMoney() + moneyBet * 2);
            System.out.println("You won: " + moneyBet * 2 + " money!");
        }

        endLoop: do {
            System.out.println();
            System.out.println("Possible inputs:");
            System.out.println("1: Start new game");
            System.out.println("2: Quit");
            System.out.println("Select what to do next:");
            nextStep = Main.scanner.nextInt();

            switch (nextStep) {
                case 1 -> start();
                case 2 -> {
                    break endLoop;
                }
            }
        } while (nextStep < 1 || nextStep > 2);
    }

    public void printState(boolean showAllCards) {
        System.out.println();
        System.out.println("############ STATE ############");
        System.out.printf(dealer + ":\n");
        if (showAllCards) {
            System.out.printf("\t" + dealer.getCards() + "\n");
            System.out.printf("\tValue: " + dealer.getCards().getTotalValue() + "\n");
        } else {
            System.out.printf("\tCard: " + dealer.getCards().getCard(0) + "\n");
            System.out.printf("\tValue: " + dealer.getCards().getCard(0).getValue() + "\n");
        }

        System.out.printf(player + ":\n");
        System.out.printf("\t" + player.getCards() + "\n");
        System.out.printf("\tValue: " + player.getCards().getTotalValue() + "\n");
        System.out.println("###############################");
        System.out.println();
    }

    public void printWinner(Person winner) {
        if (winner == null) {
            System.out.println("It's a draw!");
            return;
        }

        System.out.println(winner.getName() + " is winner!");
    }
}
