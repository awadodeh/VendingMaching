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
public class MakeChangeTests {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine(){

        vendingMachine = new VendingMachine();

    }

    @Test
    public void SelectProductChipsAndMakeChange(){

        int productId = 2;

        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));
        vendingMachine.acceptCoins(new Coin(CoinType.QUARTER));

        vendingMachine.selectProduct(productId);

        double currentAmount = vendingMachine.getCurrentAmount();
        double expectedAmount = 0.0;

        Assert.assertEquals(currentAmount,expectedAmount);


        double currentCoinReturn = vendingMachine.getCoinReturn();
        double expectedCoinReturn = 0.25;

        Assert.assertEquals(currentCoinReturn,expectedCoinReturn);


    }
}
