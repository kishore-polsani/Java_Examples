package com.kishore;

import java.text.DecimalFormat;

public class Tax {

    public static void main(String[] args) {
        Double amount = 200.0;
        Double monthlyAmount = amount / 12;
        DecimalFormat df = new DecimalFormat("#.##");

        //Tax calculations 2% increase
        Double twoPerIncrease1year = monthlyAmount * (1 + 0.02);
        Double twoPerIncrease2year = (twoPerIncrease1year) * (1 + 0.02);
        Double twoPerIncrease3year = (twoPerIncrease2year) * (1 + 0.02);
        //Tax calculations 7% increase
        Double sevenPerIncrease1year = monthlyAmount * (1 + 0.07);
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
        System.out.println(df.format(taxSaved));

        taxSaved = ((sevenPerIncrease1year - twoPerIncrease1year) * 12) + ((sevenPerIncrease2year - twoPerIncrease2year) * 12) + ((sevenPerIncrease3year - twoPerIncrease3year) * 12);
        System.out.println(taxSaved);
        System.out.println(df.format(taxSaved));
	/*	
		System.out.println(Math.floor(taxSaved * 10) / 100);
		System.out.println(df.format(taxSaved));
		//amount = amount/12;
		System.out.println("amount: "+amount/12);
		System.out.println(df.format(amount/12));*/
    }

}
