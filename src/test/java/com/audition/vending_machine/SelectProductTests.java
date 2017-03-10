package com.audition.vending_machine;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larrywilson on 3/10/17.
 */
public class SelectProductTests {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine(){

        vendingMachine = new VendingMachine();

    }


    @Test
    public void SelectProductCola(){

        int productId = 2;

        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));

        vendingMachine.selectProduct(productId);

        String actualMessage = vendingMachine.getDisplay();
        String expectedMessage = "Thank You";



        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
