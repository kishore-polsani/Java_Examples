package com.kishore;

public class DoubleType {

    public static void main(String[] args) {
        Double amount = 0.1;
        Double twoPerIncrease1year = amount * (1 + 0.02);
        Double twoPerIncrease2year = (twoPerIncrease1year * 0.02) * (1 + 0.02);
        Double twoPerIncrease3year = (twoPerIncrease2year * 0.02) * (1 + 0.02);
        //Tax calculations 7% increase
        Double SevenPerIncrease1year = amount * (1 + 0.07);
        Double SevenPerIncrease2year = (twoPerIncrease1year * 0.02) * (1 + 0.07);
        Double SevenPerIncrease3year = (twoPerIncrease2year * 0.02) * (1 + 0.07);
        System.out.println("twoPerIncrease1year: " + Math.floor(twoPerIncrease1year * 10) / 100);
        //System.out.println("twoPerIncrease1year: "+twoPerIncrease1year);

        String s = "6.84";

        try {
            long l = (long) Double.parseDouble("30000.1");
            System.out.println("long l = " + l);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

    }

}
