package cz.radeknolc.java;

import cz.radeknolc.java.models.Player;
import cz.radeknolc.java.models.Session;

import java.util.Scanner;

public class Main {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to Black Jack!");
        System.out.print("Enter yours name: ");
        String name = scanner.nextLine();

        Player player = new Player(name, 1000);
        Session session = new Session(player);
        session.start();

        scanner.close();
    }
}