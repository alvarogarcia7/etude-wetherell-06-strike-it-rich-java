package com.example.etudes.strikeitrich;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Bid> matchingBids = bids.stream()
                .filter(x -> x.isAtLeast(minimumPrice))
                .filter(Bid::hasSomeUnits).collect(Collectors.toList());

        int units = this.units;

        for (Bid current : matchingBids) {
            if (current.requestedUpTo(units)) {
                units = current.updateRemainingUnits(units);
                current.accept();
            }
        }
    }


}
