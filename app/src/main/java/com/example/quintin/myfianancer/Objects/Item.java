package com.example.quintin.myfianancer.Objects;

import java.util.Date;

public class Item {
    private String name;
    private int price;
    private String datePurchase;

    public Item(){}

    public Item(String name, int price, String datePurchase) {
        this.name = name;
        this.price = price;
        this.datePurchase = datePurchase;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDatePurhase() {
        return datePurchase;
    }

}

