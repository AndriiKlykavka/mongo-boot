package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        Share aapl = new Share("AAPL", 100, 141);
        Share coke = new Share("COKE", 1000, 387);
        Share ibm = new Share("IBM", 200, 137);

        Trader alice = new Trader("Alice",
                new Share[]{new Share("AAPL", 10, 100),
                new Share("COKE", 20, 390)});

        Trader bob = new Trader("Bob",
                new Share[]{new Share("AAPL", 10, 140),
                new Share("IBM", 20, 135)});

        Trader charlie = new Trader("Charlie",
                new Share[]{new Share("COKE", 300, 370)});

        Exchange myExchange = new Exchange();

        myExchange.setWorkingTime(10);

        myExchange.addSharesForCompanies(new Share[]{aapl, coke, ibm});
        myExchange.addTraders(new Trader[]{alice, bob, charlie});

        myExchange.startTrading();

    }
}
