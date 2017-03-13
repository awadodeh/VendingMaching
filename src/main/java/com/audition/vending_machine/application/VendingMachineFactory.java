package com.audition.vending_machine.application;

/**
 * Created by larrywilson on 3/9/17.
 */
public class VendingMachineFactory {


    public static VendingMachine getVendingMachineInstance(){
        return new VendingMachineImpl();
    }
}