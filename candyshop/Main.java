package com.candyshop;

public class Main {
    public static void main(String[] args) {
        Sweet Alenka = new Alenka("Alenka", 50, 150, "no sugar");
        Sweet Mars = new Mars("Mars", 60, 130, "with caramel");

        Box box = new Box();
        box.addSweet(Alenka);
        box.addSweet(Mars);
        box.showAllInfo();
    }
}
