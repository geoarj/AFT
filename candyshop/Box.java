package com.candyshop;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Box implements SweetBox {

    private int allPrice;
    private int allWeight;
    private final List<Sweet> sweets = new ArrayList<>();

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public int getAllWeight() {
        return allWeight;
    }

    public void setAllWeight(int allWeight) {
        this.allWeight = allWeight;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    @Override
    public void addSweet(Sweet sweet) {
        if (sweet == null) {
            throw new IllegalArgumentException("null value not allowed to add");
        }
        sweets.add(sweet);
    }

    @Override
    public void deleteLastSweet() {
        sweets.remove(sweets.size() - 1);
    }

    @Override
    public void deleteSweet(int index) {
        if (index > sweets.size() - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        sweets.remove(index);
    }

    @Override
    public void showWeight() {

        for (Sweet sweet : sweets) {
            allWeight = allWeight + sweet.getWeight();
        }
        System.out.println("Total weight is " + allWeight);
    }

    @Override
    public void showPrice() {

        for (Sweet sweet : sweets) {
            allPrice = allPrice + sweet.getPrice();
        }
        System.out.println("Total price is " + allPrice);
    }

    @Override
    public void showAllInfo() {
        for (Sweet sweet : sweets) {
            System.out.println("\nName " + sweet.getName() + "\nweight " + sweet.getWeight() + "\nprice " + sweet.getPrice() + "\ndescription: " + sweet.getDescription());
        }
    }

    public void optimizeWeight(int desiredWeight) {
        while (getAllWeight() > desiredWeight) {
            this.getSweets().remove(Collections.min(
                    this.getSweets(), Comparator.comparing(Sweet::getWeight)));
        }
    }

    public void optimizePrice(int desiredPrice) {
        while (getAllWeight() > desiredPrice) {
            this.getSweets().remove(Collections.min(
                    this.getSweets(), Comparator.comparing(Sweet::getPrice)));
        }
    }

    public Sweet getMinWeightSweet() {
        //return min weight sweet
        return Collections.min(this.getSweets(), Comparator.comparing(Sweet::getWeight));
    }

    public Sweet getMinPriceSweet() {
        //return min price sweet
        return Collections.min(this.getSweets(), Comparator.comparing(Sweet::getPrice));
    }


}
