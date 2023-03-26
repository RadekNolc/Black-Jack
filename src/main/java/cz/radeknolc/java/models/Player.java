package cz.radeknolc.java.models;

public class Player extends Person {
    private double money;

    public Player(String name, double money) {
        super(name);
        this.money = money;
    }

    public void setMoney(double newValue) {
        money = newValue;
    }

    public double getMoney() {
        return money;
    }
}
