package com.audition.vending_machine.model;

import com.audition.vending_machine.exception.NotSufficientChangeException;
import com.audition.vending_machine.exception.SoldOutException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by larrywilson on 3/13/17.
 */
public class Inventory<T> {

    private Map<T, Integer> inventory = new HashMap<T, Integer>();

    public void add(T product) {
        int count = inventory.get(product);
        inventory.put(product, count + 1);
    }


    public void put(T product, int quantity) {
        inventory.put(product, quantity);
    }

    public boolean hasProduct(T product) {
        return getQuantity(product) > 0;
    }


    public int getQuantity(T product) {
        Integer value = inventory.get(product);
        return value == null ? 0 : value;
    }


    public void deduct(T item) throws SoldOutException, NotSufficientChangeException {
        if (hasItem(item)) {
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }else{
            if(item instanceof Product){
                throw new SoldOutException("Product is out!");
            }else{
                throw new NotSufficientChangeException("No Sufficient Change In The Machine!");
            }

        }
    }

    public boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }


}
