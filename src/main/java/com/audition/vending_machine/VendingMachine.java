package com.audition.vending_machine;

/**
 * Created by larrywilson on 3/9/17.
 */
public class VendingMachine {
    private double currentAmount;

    public void acceptCoins(Coin coin) {

        double insertedValue =  coin.getCoinType().getValue();
        currentAmount += insertedValue;

    }

    public double getCurrentAmount() {
        return currentAmount;
    }
}
