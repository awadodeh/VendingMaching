package com.audition.vending_machine;

import com.audition.vending_machine.application.VendingMachine;
import com.audition.vending_machine.application.VendingMachineFactory;
import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.SoldOutException;
import com.audition.vending_machine.model.Coin;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by larrywilson on 3/10/17.
 */
public class ReturnCoinsTests {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine() {

        vendingMachine = VendingMachineFactory.getVendingMachineInstance();

    }

    @Test
    public void testRefund() throws NotSufficientChangeException, SoldOutException {

        vendingMachine.acceptCoin(Coin.PENNIE);
        vendingMachine.acceptCoin(Coin.DIME);
        vendingMachine.acceptCoin(Coin.NICKEL);
        vendingMachine.acceptCoin(Coin.QUARTER);
        Assert.assertEquals(0.41, getTotal(vendingMachine.getRefund()));
    }




    private double getTotal(List<Coin> refundList) {
        double total = 0;
        for(Coin coin: refundList){
            total+=coin.getValue();
        }

        return total;
    }


}
