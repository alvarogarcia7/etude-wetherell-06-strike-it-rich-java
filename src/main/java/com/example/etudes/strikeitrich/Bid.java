package com.example.etudes.strikeitrich;

class Bid {
    private final int units;
    private final int price;
    private final Player bidder;

    Bid(int units, int price, Player bidder) {
        this.units = units;
        this.price = price;
        this.bidder = bidder;
    }

    void accept() {
        bidder.acceptBid();
    }

    boolean isAtLeast(int minimumPrice) {
        return price >= minimumPrice;
    }
}
