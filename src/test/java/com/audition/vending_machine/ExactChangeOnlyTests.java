package com.audition.vending_machine;

import com.audition.vending_machine.application.VendingMachine;
import com.audition.vending_machine.application.VendingMachineFactory;
import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.NotSufficientFundException;
import com.audition.vending_machine.exception.SoldOutException;
import com.audition.vending_machine.model.Coin;
import com.audition.vending_machine.model.Product;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larrywilson on 3/13/17.
 */
public class ExactChangeOnlyTests {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine() {
        vendingMachine = VendingMachineFactory.getVendingMachineInstance();

    }


    @Test(expected = NotSufficientChangeException.class)
    public void testNotSufficientChangeException() throws NotSufficientFundException, NotSufficientChangeException, SoldOutException {
        for (int i = 0; i < 6; i++) {

            vendingMachine.acceptCoin(Coin.QUARTER);
            vendingMachine.acceptCoin(Coin.QUARTER);
            vendingMachine.acceptCoin(Coin.QUARTER);

            vendingMachine.selectProductAndCollectChange(Product.CANDY);


        }
    }


}
