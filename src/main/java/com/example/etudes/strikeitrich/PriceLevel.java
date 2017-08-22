package com.example.etudes.strikeitrich;

public class PriceLevel {
    private final int rmus;
    private final int minimumPrice;
    private final int fius;
    private final int maximumPrice;

    public PriceLevel (final int RMUs, final int minimumPrice, final int FIUs, final int maximumPrice) {
        rmus = RMUs;
        this.minimumPrice = minimumPrice;
        fius = FIUs;
        this.maximumPrice = maximumPrice;
    }
}
