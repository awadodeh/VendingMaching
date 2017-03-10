package com.audition.vending_machine;

/**
 * Created by larrywilson on 3/9/17.
 */
public class VendingMachine {
    private double currentAmount;
    private double coinRetrun;

    public void acceptCoins(Coin coin) {

        if(CoinValidator.isCoinValid(coin)){
            double insertedValue =  coin.getCoinType().getValue();
            currentAmount += insertedValue;
        }else{
            coinRetrun +=coin.getCoinType().getValue();
        }
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public double getCoinRetrun() {
        return coinRetrun;
    }
}
