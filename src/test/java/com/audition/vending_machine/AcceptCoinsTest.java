package com.audition.vending_machine;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by larrywilson on 3/9/17.
 */
public class AcceptCoinsTest {

    @Test
    public void insertNickelTest(){

        Coin coin = new Coin(CoinType.NICKEL);

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.acceptCoins(coin);
        double actualAmount = 0.05;

        double expectedAmount = vendingMachine.getCurrentAmount();

        Assert.assertEquals(actualAmount,expectedAmount);
    }


}
