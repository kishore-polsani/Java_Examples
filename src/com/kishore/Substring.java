package com.kishore;

public class Substring {

    public static void main(String[] args) {
        String quoteAccountId = "a4N4D0000000TUX0014D000002fZ6O";
        String accountID = "";
        String quoteId = "";
        try {
            System.out.println(quoteAccountId.length());
            quoteId = quoteAccountId.substring(0, 15);
            accountID = quoteAccountId.substring(15, 30);
            System.out.println(quoteId.trim());
            System.out.println(accountID.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String price = "$46/mo";
        price = price.substring(1, price.indexOf("/"));
        System.out.println("Price value: " + price);
        Double yearlyPrice = Double.parseDouble(price);

        System.out.println(yearlyPrice * 12);
    }
}




