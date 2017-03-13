package com.audition.vending_machine.model;

/**
 * Created by larrywilson on 3/10/17.
 */
public enum Product {

    COLA("Cola", 1.0),
    CHIPS("Chips", 0.5),
    CANDY("Candy", 0.65);


    private String productName;
    private double productPrice;

    private Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

}
