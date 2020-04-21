package com.kishore.encode;

import java.nio.charset.StandardCharsets;

public class TestEncoding {

    public static void main(String[] args) throws Exception {
        String str1 = "Service d&#39;abonnement annuel";
        String str2 = "\uFFFF";
        byte[] arr = str1.getBytes(StandardCharsets.UTF_8);
        byte[] brr = str2.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF-8 for \\u0000");
        for (byte a : arr) {
            System.out.print(a);
        }
        System.out.println("\nUTF-8 for \\uffff");
        for (byte b : brr) {
            System.out.print(b);
        }
    }

}