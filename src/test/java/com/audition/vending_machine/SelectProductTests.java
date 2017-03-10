package com.audition.vending_machine;

import com.audition.vending_machine.application.VendingMachine;
import com.audition.vending_machine.model.Coin;
import com.audition.vending_machine.model.CoinType;
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
    public void SelectProductChips(){

        int productId = 3;

        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));

        vendingMachine.selectProduct(productId);

        String actualMessage = vendingMachine.getDisplay();
        String expectedMessage = "Thank You";



        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void SelectProductCandy(){

        int productId = 3;

        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.DIME));
        vendingMachine.acceptCoins(new Coin(CoinType.NICKEL));

        vendingMachine.selectProduct(productId);

        String actualMessage = vendingMachine.getDisplay();
        String expectedMessage = "Thank You";



        Assert.assertEquals(actualMessage,expectedMessage);

    }





    @Test
    public void SelectProductColasًNotEnoughMoney(){

        int productId = 1;

        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));

        vendingMachine.selectProduct(productId);

        double currentAmount = vendingMachine.getCurrentAmount();

        String actualMessage = vendingMachine.getDisplay();

        String expectedMessage = "Insert Coin, Current Amount: " + currentAmount;



        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
