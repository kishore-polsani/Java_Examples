package com.kishore.generic;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberRounding {

    public static void main(String[] args) {
        NumberRounding obj = new NumberRounding();
        double value = 50.65;
        obj.roundOff(value);
    }

    public String genericNumberFormat(double value) {
        String numberPattern = "###";
        DecimalFormat myFormatter = new DecimalFormat(numberPattern);
        String resultFormat = myFormatter.format(value);
        System.out.println("genericNumberFormat : " + value + numberPattern + resultFormat);

        return resultFormat;
    }

    public String roundOff(Double number) {
        int decimalsToConsider = 0;
        BigDecimal bigDecimal = new BigDecimal(number);
        BigDecimal roundedValueWithDivideLogic = bigDecimal.divide(BigDecimal.ONE, decimalsToConsider, BigDecimal.ROUND_HALF_UP);
        //log.info("Rounded value "+roundedValueWithDivideLogic);
        System.out.println("roundedValueWithDivideLogic : " + roundedValueWithDivideLogic.toString());
        return roundedValueWithDivideLogic.toString();
    }
}
