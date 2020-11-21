package com.candyshop;

abstract class Sweet {
    private String name;
    private int weight;
    private int price;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Sweet(String name, int weight, int price, String description) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }
}