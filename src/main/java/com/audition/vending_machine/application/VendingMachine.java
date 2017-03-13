package com.audition.vending_machine.application;
import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.NotSufficientFundException;
import com.audition.vending_machine.exception.SoldOutException;
import com.audition.vending_machine.model.Bucket;
import com.audition.vending_machine.model.Coin;
import com.audition.vending_machine.model.Product;

import java.util.List;


/**
 * Created by larrywilson on 3/9/17.
 */
public interface VendingMachine {

    void acceptCoin(Coin coin);

    double getCurrentBalance();

    List<Coin> getRefund() throws NotSufficientChangeException, SoldOutException;

    String getDisplay();

    Bucket<Product, List<Coin>> selectProductAndCollectChange(Product product) throws NotSufficientChangeException, NotSufficientFundException, SoldOutException;
}
