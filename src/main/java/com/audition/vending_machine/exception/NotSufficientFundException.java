package com.audition.vending_machine.exception;

/**
 * Created by larrywilson on 3/13/17.
 */
public class NotSufficientFundException extends Exception {
    public NotSufficientFundException(String s, double remainingBalance) {
        super(s + remainingBalance);
    }
}
