package com.candyshop;

public interface SweetBox {
    void addSweet(Sweet sweet);
    void deleteLastSweet();
    void deleteSweet(int index);
    void showWeight();
    void showPrice();
    void showAllInfo();
}
