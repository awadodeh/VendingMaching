package com.audition.vending_machine;

/**
 * Created by larrywilson on 3/9/17.
 */
public enum CoinType {
    NICKEL(0.05);

    private double value;

    CoinType(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}