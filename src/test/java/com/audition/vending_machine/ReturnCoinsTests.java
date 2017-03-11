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
public class ReturnCoinsTests {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine(){

        vendingMachine = new VendingMachine();

    }

    @Test
    public void returnInsertedCoins(){

        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));

        double currentAmount = vendingMachine.returnCoins();
        double expectedAmount = 0.5;

        Assert.assertEquals(expectedAmount,currentAmount);


        String actualMessage = vendingMachine.getDisplay();
        String expectedMessage = "Insert Coin";

        Assert.assertEquals(expectedMessage,actualMessage);

    }

}
