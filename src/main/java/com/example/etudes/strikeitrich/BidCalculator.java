package com.example.etudes.strikeitrich;

import java.util.List;

class BidCalculator {
    private final int units;
    private final int minimumPrice;
    private final List<Bid> bids;

    BidCalculator(int units, int minimumPrice, List<Bid> bids) {
        this.units = units;
        this.minimumPrice = minimumPrice;
        this.bids = bids;
    }

    void distribute() {
        bids.stream().filter(x -> x.isAtLeast(minimumPrice)).forEach(Bid::accept);
    }
}
