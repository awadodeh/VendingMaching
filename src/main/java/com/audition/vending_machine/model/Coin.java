package com.audition.vending_machine.model;

/**
 * Created by larrywilson on 3/9/17.
 */
public enum Coin {
    PENNIE(0.01),
    NICKEL(0.05),
    DIME(0.1),
    QUARTER(0.25);

    private double value;

    Coin(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}