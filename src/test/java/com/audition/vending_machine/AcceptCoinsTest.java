package com.audition.vending_machine;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

/**
 * Created by larrywilson on 3/9/17.
 */
public class AcceptCoinsTest {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine(){
        vendingMachine = new VendingMachine();
    }


    @Test
    public void insertNickelTest(){

        Coin coin = new Coin(CoinType.NICKEL);

        vendingMachine.acceptCoins(coin);

        double actualAmount = 0.05;

        double expectedAmount = vendingMachine.getCurrentAmount();

        Assert.assertEquals(actualAmount,expectedAmount);
    }

    @Test
    public void insertDimeTest(){

        Coin coin = new Coin(CoinType.DIME);

        vendingMachine.acceptCoins(coin);

        double actualAmount = 0.1;

        double expectedAmount = vendingMachine.getCurrentAmount();

        Assert.assertEquals(actualAmount,expectedAmount);
    }


}
