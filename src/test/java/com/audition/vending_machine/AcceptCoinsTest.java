package com.audition.vending_machine;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larrywilson on 3/9/17.
 */
public class AcceptCoinsTest {

    VendingMachine vendingMachine;
    List validCoinTypes;

    @Before
    public void setUpVendingMachine(){

        vendingMachine = new VendingMachine();


        validCoinTypes = new ArrayList<CoinType>();

        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        CoinValidator.setValidCoinTypes(validCoinTypes);



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


    @Test
    public void insertPennieCoinTest(){

        Coin coin = new Coin(CoinType.PENNIE);

        vendingMachine.acceptCoins(coin);

        double actualAmount = 0.01;

        double expectedAmount = vendingMachine.getCoinReturn();


        Assert.assertFalse(actualAmount != expectedAmount);

    }



    @Test
    public void insertQuarterTest(){

        Coin coin = new Coin(CoinType.QUARTER);

        vendingMachine.acceptCoins(coin);

        double actualAmount = 0.25;

        double expectedAmount = vendingMachine.getCurrentAmount();

        Assert.assertEquals(actualAmount,expectedAmount);
    }



    @Test
    public void showDisplay(){

        String actualMessage = vendingMachine.getDisplay();

        String expectMessage = "INSERT COIN";

        Assert.assertEquals(expectMessage.toLowerCase(),actualMessage.toLowerCase());
    }


}
