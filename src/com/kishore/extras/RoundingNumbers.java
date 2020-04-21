package com.kishore.extras;

import java.math.BigDecimal;

public class RoundingNumbers {

    public static void main(String[] args) {
        double amount = 2109.12;
        double number = amount / 12;
        int decimalsToConsider = 0;
        BigDecimal bigDecimal = new BigDecimal(number);
       /* BigDecimal roundedWithScale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Rounded value with setting scale = "+roundedWithScale);

        bigDecimal = new BigDecimal(number);*/
        BigDecimal roundedValueWithDivideLogic = bigDecimal.divide(BigDecimal.ONE, decimalsToConsider, BigDecimal.ROUND_HALF_UP);
        System.out.println("Rounded value with Dividing by one = " + roundedValueWithDivideLogic);

        Double twoPerIncrease1year = number * (1 + 0.02);
        Double twoPerIncrease2year = (twoPerIncrease1year) * (1 + 0.02);
        Double twoPerIncrease3year = (twoPerIncrease2year) * (1 + 0.02);
        //Tax calculations 7% increase
        Double sevenPerIncrease1year = number * (1 + 0.07);
        Double sevenPerIncrease2year = (sevenPerIncrease1year) * (1 + 0.07);
        Double sevenPerIncrease3year = (sevenPerIncrease2year) * (1 + 0.07);

        Double taxSaved = ((sevenPerIncrease1year + sevenPerIncrease2year + sevenPerIncrease3year) - (twoPerIncrease1year + twoPerIncrease2year + twoPerIncrease3year)) * 12;

        System.out.println("twoPerIncrease1year: " + twoPerIncrease1year);
        System.out.println("twoPerIncrease2year: " + twoPerIncrease2year);
        System.out.println("twoPerIncrease3year: " + twoPerIncrease3year);

        System.out.println("sevenPerIncrease1year: " + sevenPerIncrease1year);
        System.out.println("sevenPerIncrease2year: " + sevenPerIncrease2year);
        System.out.println("sevenPerIncrease3year: " + sevenPerIncrease3year);
        System.out.println(taxSaved);
    }

    public static String roundOff() {
        return null;
    }
}