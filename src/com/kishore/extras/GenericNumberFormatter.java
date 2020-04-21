package com.kishore.extras;

import java.text.DecimalFormat;

public class GenericNumberFormatter {

    public static void main(String[] args) {
        double value = 107.0745;
        String numberPattern = "###.00";
        System.out.println(genericNumberFormat(value, numberPattern));

    }

    public static String genericNumberFormat(double value, String numberPattern) {
        System.out.println("Number pattern: " + numberPattern);
        DecimalFormat myFormatter = new DecimalFormat(numberPattern);
        String resultFormat = myFormatter.format(value);
        System.out.println("genericNumberFormat :" + resultFormat);

        return resultFormat;
    }

}
