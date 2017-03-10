package com.audition.vending_machine.dataAccess;

import com.audition.vending_machine.model.Product;

import java.util.Map;

/**
 * Created by larrywilson on 3/10/17.
 */
public interface DataAccess {

    Map<Integer,Product> getProducts();

}
