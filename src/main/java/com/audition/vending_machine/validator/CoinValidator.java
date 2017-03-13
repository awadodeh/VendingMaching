package com.audition.vending_machine.validator;

import com.audition.vending_machine.model.Coin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larrywilson on 3/9/17.
 */
public class CoinValidator {
    private static List<Coin> validCoinTypes;

    static{
        validCoinTypes = new ArrayList();

        validCoinTypes.add(Coin.NICKEL);
        validCoinTypes.add(Coin.DIME);
        validCoinTypes.add(Coin.QUARTER);
    }


    public CoinValidator(List<Coin> validCoinTypes) {
        this.validCoinTypes = validCoinTypes;
    }

    public static boolean isCoinValid(Coin coin) {
        if(validCoinTypes.contains(coin)){
            return true;
        }
            return false;
    }

    public static void setValidCoinTypes(List validCoinTypes) {
        CoinValidator.validCoinTypes = validCoinTypes;
    }
}
