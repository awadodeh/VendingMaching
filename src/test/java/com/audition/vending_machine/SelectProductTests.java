package com.audition.vending_machine;

import com.audition.vending_machine.application.VendingMachine;
import com.audition.vending_machine.application.VendingMachineFactory;
import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.NotSufficientFundException;
import com.audition.vending_machine.exception.SoldOutException;
import com.audition.vending_machine.model.Bucket;
import com.audition.vending_machine.model.Coin;
import com.audition.vending_machine.model.Product;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by larrywilson on 3/10/17.
 */
public class SelectProductTests {

    VendingMachine vendingMachine;

    @Before
    public void setUpVendingMachine() {
        vendingMachine = VendingMachineFactory.getVendingMachineInstance();

    }



    @Test
    public void testBuyItemWithExactPrice() throws SoldOutException {

        vendingMachine.acceptCoin(Coin.QUARTER);
        vendingMachine.acceptCoin(Coin.QUARTER);
        vendingMachine.acceptCoin(Coin.QUARTER);
        vendingMachine.acceptCoin(Coin.QUARTER);

        Bucket<Product, List<Coin>> bucket = null;

        try {
            bucket = vendingMachine.selectProductAndCollectChange(Product.COLA);
        }catch(NotSufficientChangeException ex){
            ex.printStackTrace();
        } catch (NotSufficientFundException e) {
            e.printStackTrace();
        }

        Product product = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        Assert.assertEquals(Product.COLA, product);

        Assert.assertTrue(change.isEmpty());
    }

}
