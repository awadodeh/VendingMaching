package com.audition.vending_machine;

/**
 * Created by larrywilson on 3/9/17.
 */
public class VendingMachine {
    private double currentAmount;
    private double coinReturn;
    private String display = "Insert Coin";

    public void acceptCoins(Coin coin) {

        if(CoinValidator.isCoinValid(coin)){
            double insertedValue =  coin.getCoinType().getValue();
            currentAmount += insertedValue;
        }else{
            coinReturn +=coin.getCoinType().getValue();
        }
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public double getCoinReturn() {
        return coinReturn;
    }

    public String getDisplay() {
        return display;
    }
}
