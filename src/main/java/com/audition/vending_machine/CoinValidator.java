package com.audition.vending_machine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larrywilson on 3/9/17.
 */
public class CoinValidator {
    private static List<CoinType> validCoinTypes;

    public CoinValidator() {
        this.validCoinTypes = new ArrayList<CoinType>();

        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);


    }

    public CoinValidator(List<CoinType> validCoinTypes) {
        this.validCoinTypes = validCoinTypes;
    }

    public static boolean isCoinValid(Coin coin) {
        if(validCoinTypes.contains(coin.getCoinType())){
            return true;
        }
            return false;
    }

    public static void setValidCoinTypes(List validCoinTypes) {
        CoinValidator.validCoinTypes = validCoinTypes;
    }
}
