package com.audition.vending_machine;

import com.audition.vending_machine.application.VendingMachine;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larrywilson on 3/10/17.
 */
public class SoldOutTests {

    VendingMachine vendingMachine;
    SelectProductTests selectProductTests;

    @Before
    public void setUpVendingMachine(){

        vendingMachine = new VendingMachine();
        selectProductTests = new SelectProductTests();
    }



    @Test
    public void selectSoldOutProduct(){

        int prodctId = 3;

        for (int i = 0; i < 5; i++) {

            selectProductTests.SelectProductCandy();
        }

        Assert.assertTrue(vendingMachine.isSoldOut(prodctId));



    }
}
