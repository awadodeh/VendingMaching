package com.audition.vending_machine.exception;

/**
 * Created by larrywilson on 3/13/17.
 */
public class SoldOutException extends Throwable {
    public SoldOutException(String s) {
        super(s);
    }
}
