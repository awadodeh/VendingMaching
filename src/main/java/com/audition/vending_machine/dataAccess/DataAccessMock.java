package com.audition.vending_machine.dataAccess;

import com.audition.vending_machine.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by larrywilson on 3/10/17.
 */
public class DataAccessMock implements DataAccess{

    private static Map<Integer,Product> products;

    public DataAccessMock() {

        products = new HashMap<Integer, Product>();
        Product cola = new Product(1,"cola",1.0,4);
        Product chips = new Product(2,"chips",0.5,4);
        Product candy = new Product(3,"candy",0.65,4);
        products.put(cola.getProductId(),cola);
        products.put(chips.getProductId(),chips);
        products.put(candy.getProductId(),candy);
    }

    public Map<Integer,Product> getProducts() {
        return products;
    }
}
