package com.kishore.extras;

public class TermsPrice {

    public static void main(String[] args) {
        double price1 = 0;
        double price2 = 0;
        double price3 = 0;
        int yoy1 = 7;
        int yoy2 = 7;
        int yoy3 = 7;

        price3 = price3 * 12 + (price3 * (yoy3 / 100 + 1)) * 12 + ((price3 * (yoy3 / 100 + 1)) * (yoy3 / 100 + 1)) * 12;
        System.out.println(price3);
    }
}
