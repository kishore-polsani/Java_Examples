package com.kishore;

import java.text.DecimalFormat;

public class YoyPrice {

    public static final String numberPattern = "#.##";

    public static void main(String[] args) {
        float checkoutInitialPrice = 107;
        float yearOnYearValue = 3;
		/*System.out.println(calculateYOYPrice(checkoutInitialPrice,3));
		float total = calculateYOYPrice(checkoutInitialPrice,3)*12;
		System.out.println("Year: "+total);
		System.out.println("format: "+Math.round(total * 100.0) / 100.0);*/

        float secondYearPrice = (checkoutInitialPrice * (yearOnYearValue / 100 + 1));
        float thirdYearPrice = (secondYearPrice * (yearOnYearValue / 100 + 1));
        secondYearPrice = secondYearPrice * 12;
        secondYearPrice = (float) (Math.round(secondYearPrice * 100.0) / 100.0);
        thirdYearPrice = thirdYearPrice * 12;
        thirdYearPrice = (float) (Math.round(thirdYearPrice * 100.0) / 100.0);
        checkoutInitialPrice = checkoutInitialPrice * 12;
        checkoutInitialPrice = (float) (Math.round(checkoutInitialPrice * 100.0) / 100.0);

        System.out.println("first year:" + checkoutInitialPrice);
        System.out.println("secondYearPrice: " + secondYearPrice);
        System.out.println("thirdYearPrice: " + thirdYearPrice);

        double d = 1;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print(df.format(d));
    }

    private static float calculateYOYPrice(long price, float yoyValue) {
        System.out.println(price * (yoyValue / 100 + 1));
        return price * (yoyValue / 100 + 1);
    }

    public static String genericNumberFormat(float value) {
        System.out.println("Number pattern: " + numberPattern);
        DecimalFormat myFormatter = new DecimalFormat(numberPattern);
        String resultFormat = myFormatter.format(value);
        System.out.println("genericNumberFormat : " + resultFormat);

        return resultFormat;
    }
}
