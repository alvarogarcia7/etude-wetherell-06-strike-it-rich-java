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

    boolean hasSomeUnits() {
        return units > 0;
    }

    boolean requestedUpTo(int availableUnits) {
        return availableUnits >= units;
    }

    int updateRemainingUnits(int availableUnits) {
        return availableUnits - units;
    }

    static int descendingPrice(Bid bid, Bid bid1) {
        return -Integer.compare(bid.price, bid1.price);
    }
}
