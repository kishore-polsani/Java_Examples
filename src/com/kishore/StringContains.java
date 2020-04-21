package com.kishore;

public class StringContains {

    public static void main(String[] args) {
        String currentPagePath = "https://localhost:5433/content/smalllaw/en/confirm-current.html?quoteId=00130000017Kk410061B00001SLVdL&wcmmode=disabled";
        if (currentPagePath.contains("confirm-current.html") || currentPagePath.contains("quote.html")) {
            System.out.println("TRUE");
        } else {
            System.out.println("false");
        }
    }
}
