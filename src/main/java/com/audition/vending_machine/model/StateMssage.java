package com.audition.vending_machine.model;

/**
 * Created by larrywilson on 3/9/17.
 */
public enum StateMssage {
    Insert_COIN("INSERT COIN"),
    THANK_YOU_MESSAGE("THANK YOU!"),
    NO_SUFFCIENT_CHANGE("NO SUFFICIENT CHANGE!"),
    CUSTOM_STATE_MESSAGE("");

    private String value;

    StateMssage(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
         this.value =value;
    }

}