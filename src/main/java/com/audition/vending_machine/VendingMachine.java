package com.audition.vending_machine;

import com.audition.vending_machine.dataAccess.DataAccess;
import com.audition.vending_machine.dataAccess.DataAccessMock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larrywilson on 3/9/17.
 */
public class VendingMachine {
    private double currentAmount;
    private double coinReturn;
    private String display = "Insert Coin";

    private DataAccess dataAccess;

    public VendingMachine() {

        this.dataAccess = new DataAccessMock();

        List<CoinType> validCoinTypes;

        validCoinTypes = new ArrayList<CoinType>();

        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        CoinValidator.setValidCoinTypes(validCoinTypes);

    }



    public VendingMachine(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public void acceptCoins(Coin coin) {

        if(CoinValidator.isCoinValid(coin)){
            double insertedValue =  coin.getCoinType().getValue();
            currentAmount += insertedValue;
        }else{
            coinReturn +=coin.getCoinType().getValue();
        }
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public double getCoinReturn() {
        return coinReturn;
    }

    public String getDisplay() {
        return display;
    }

    public void selectProduct(int productId) {

        Product selectedProduct = dataAccess.getProducts().get(productId);
        if(dataAccess.getProducts().containsKey(productId)){

            if(currentAmount >= selectedProduct.getProductPrice()){
                dispenseProduct(selectedProduct);
            }
        }

    }

    private void dispenseProduct(Product selectedProduct) {
        display = "Thank You";

        currentAmount -= selectedProduct.getProductPrice();

    }
}
