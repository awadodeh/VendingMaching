package com.audition.vending_machine.dataAccess;

import com.audition.vending_machine.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by larrywilson on 3/10/17.
 */
public class DataAccessMock implements DataAccess{

    private static Map<Integer,Product> products;

    public DataAccessMock() {

        products = new HashMap<Integer, Product>();
        Product cola = new Product(1,"cola",1.0);
        Product chips = new Product(2,"chips",0.5);
        products.put(cola.getProductId(),cola);
        products.put(chips.getProductId(),chips);
    }

    public Map<Integer,Product> getProducts() {
        return products;
    }
}
