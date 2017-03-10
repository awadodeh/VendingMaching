package com.audition.vending_machine.dataAccess;

import com.audition.vending_machine.Product;

import java.util.Map;

/**
 * Created by larrywilson on 3/10/17.
 */
public interface DataAccess {

    Map<Integer,Product> getProducts();

}
