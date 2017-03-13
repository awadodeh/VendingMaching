package com.audition.vending_machine;

import com.audition.vending_machine.application.VendingMachine;
import com.audition.vending_machine.application.VendingMachineFactory;
import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.SoldOutException;
import com.audition.vending_machine.model.Coin;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larrywilson on 3/9/17.
 */
public class AcceptCoinsTest {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine() {

        vendingMachine = VendingMachineFactory.getVendingMachineInstance();

    }


    @Test
    public void insertNickelTest() {


        vendingMachine.acceptCoin(Coin.NICKEL);

        double actualAmount = 0.05;

        double expectedAmount = vendingMachine.getCurrentBalance();

        Assert.assertEquals(actualAmount, expectedAmount);

    }

    @Test
    public void insertDimeTest() {


        vendingMachine.acceptCoin(Coin.DIME);

        double actualAmount = 0.1;

        double expectedAmount = vendingMachine.getCurrentBalance();

        Assert.assertEquals(actualAmount, expectedAmount);
    }


    @Test
    public void insertPennieCoinTest() throws NotSufficientChangeException, SoldOutException {


        vendingMachine.acceptCoin(Coin.PENNIE);

        double actualAmount = 0.01;

        double expectedAmount = vendingMachine.getRefund().stream().mapToDouble(coin -> coin.getValue()).sum();


        Assert.assertFalse(actualAmount != expectedAmount);

    }


    @Test
    public void insertQuarterTest() {


        vendingMachine.acceptCoin(Coin.QUARTER);

        double actualAmount = 0.25;

        double expectedAmount = vendingMachine.getCurrentBalance();

        Assert.assertEquals(actualAmount, expectedAmount);
    }

}
