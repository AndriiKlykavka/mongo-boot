package com.company;


import java.util.Random;

public class Share {
    String name;
    int amount;
    int price;

    public Share(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public int changePrice() {
        int max = (int) (this.price*0.03);
        int min = (int) (-this.price*0.03);
        Random random = new Random();
        this.price = this.price + random.nextInt(max - min) + min;

        return this.price;
    }
}
