package com.audition.vending_machine.application;

import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.NotSufficientFundException;
import com.audition.vending_machine.exception.SoldOutException;
import com.audition.vending_machine.model.*;
import com.audition.vending_machine.validator.CoinValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by larrywilson on 3/9/17.
 */
public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Product> productInventory = new Inventory();

    private double currentBalance;
    private double coinReturn;
    private Product currentProduct;

    private double totalSales;

    private String displayMessage = StateMssage.Insert_COIN.getValue();

    public VendingMachineImpl() {

        setDisplayMessage(StateMssage.Insert_COIN.getValue());
        initialize();
    }

    public void acceptCoin(Coin coin) {

        if (CoinValidator.isCoinValid(coin)) {
            currentBalance += coin.getValue();
            cashInventory.add(coin);
        } else {
            coinReturn += coin.getValue();
        }

    }

    public double getCurrentBalance() {
        return currentBalance;
    }


    public List<Coin> getRefund() throws NotSufficientChangeException, SoldOutException {

        List<Coin> refund = getChange(currentBalance + coinReturn);
        updateCashInventory(refund);
        currentBalance = 0;
        currentProduct = null;

        showDisplayMessage(StateMssage.Insert_COIN);

        return refund;

    }


    public String getDisplay() {
        return displayMessage;
    }


    public Bucket<Product, List<Coin>> selectProductAndCollectChange(Product product) throws NotSufficientFundException, NotSufficientChangeException, SoldOutException {

        this.currentProduct = product;

        Product collectProduct = collectProduct();


        totalSales = totalSales + currentProduct.getProductPrice();

        List<Coin> change = null;

        try {
            change = collectChange();
        } catch (NotSufficientChangeException ex) {
            showDisplayMessage(StateMssage.NO_SUFFCIENT_CHANGE);
        }


        showDisplayMessage(StateMssage.THANK_YOU_MESSAGE);

        return new Bucket<Product, List<Coin>>(collectProduct, change);

    }


    private Product collectProduct() throws NotSufficientChangeException, NotSufficientFundException, SoldOutException {
        if (isFullPaid()) {
            if (hasSufficientChange()) {

                try{
                    productInventory.deduct(currentProduct);
                }catch (SoldOutException ex){
                    showDisplayMessage(StateMssage.SOLD_OUT_MESSAGE);
                    throw new SoldOutException(StateMssage.SOLD_OUT_MESSAGE.getValue());
                }
                return currentProduct;
            }
            throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        double remainingBalance = currentProduct.getProductPrice() - currentBalance;
        throw new NotSufficientFundException("Price not full paid, remaining : ", remainingBalance);
    }


    private void showDisplayMessage(StateMssage stateMssage) {

        System.out.println(stateMssage.getValue());

    }


    private List<Coin> collectChange() throws NotSufficientChangeException, SoldOutException {
        double changeAmount = currentBalance - currentProduct.getProductPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentProduct = null;
        return change;
    }


    private void updateCashInventory(List<Coin> change) throws SoldOutException, NotSufficientChangeException {
        for (Coin c : change) {
            cashInventory.deduct(c);
        }
    }


    private void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    private void initialize() {
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 3);
        }

        for(Product i : Product.values()){
            productInventory.put(i, 5);
        }
    }


    private List<Coin> getChange(double amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;

        amount = Math.round(amount * 100.0) / 100.0;

        if (amount > 0) {
            changes = new ArrayList<Coin>();
            double balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getValue()
                        && cashInventory.hasProduct(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getValue();
                    balance = Math.round(balance * 100.0) / 100.0;
                    continue;

                } else if (balance >= Coin.DIME.getValue()
                        && cashInventory.hasProduct(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getValue();
                    balance = Math.round(balance * 100.0) / 100.0;
                    continue;

                } else if (balance >= Coin.NICKEL.getValue()
                        && cashInventory.hasProduct(Coin.NICKEL)) {
                    changes.add(Coin.NICKEL);
                    balance = balance - Coin.NICKEL.getValue();
                    balance = Math.round(balance * 100.0) / 100.0;
                    continue;

                } else if (balance >= Coin.PENNIE.getValue() && cashInventory.hasProduct(Coin.DIME)) {
                    changes.add(Coin.PENNIE);
                    balance = balance - Coin.PENNIE.getValue();
                    balance = Math.round(balance * 100.0) / 100.0;
                    continue;
                } else {
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }

        return changes;
    }


    private boolean isFullPaid() {
        if (currentBalance >= currentProduct.getProductPrice()) {
            return true;
        }
        return false;
    }


    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentProduct.getProductPrice());
    }


    private boolean hasSufficientChangeForAmount(double amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }
        return hasChange;
    }

}
