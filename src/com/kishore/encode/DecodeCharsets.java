package com.kishore.encode;

import java.nio.charset.StandardCharsets;

public class DecodeCharsets {

    public static void main(String... args) {

        //String example = "Tĥïŝ ĩš â fůňķŷ Šťŕĭńġ";
        String example = "{\"updateDetails\":[{\"quantity\":1,\"contractTerm\":\"3 Years\",\"price\":287.65,\"productDetails\":[{\"productId\":\"01t13000005wyvXAAQ\",\"isSelected\":true,\"onlineContacts\":null,\"productName\":\"Drafting Assistant (Westlaw™ PRO)\",\"noOfUsers\":1}]}]}";
        System.out.println("Text : " + example);

        System.out.println("- - - - - - - - - - - - - - - - - - -");

        byte[] utf8ByteArray = example.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF8 String [Byte Array] : " + utf8ByteArray.toString());
        String utf8Converted = new String(utf8ByteArray, StandardCharsets.UTF_8);
        System.out.println("UTF8 String Converted : " + utf8Converted);

        System.out.println("- - - - - - - - - - - - - - - - - - -");

        byte[] isoByteArray = example.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println("ISO_8859_1 String [Byte Array] : " + isoByteArray.toString());
        String i = new String(isoByteArray, StandardCharsets.ISO_8859_1);
        System.out.println("ISO_8859_1 String Converted : " + i);

        String ajaxRequestData = "{\"updateDetails\":[{\"quantity\":1,\"contractTerm\":\"3 Years\",\"price\":287.65,\"productDetails\":[{\"productId\":\"01t13000005wyvXAAQ\",\"isSelected\":true,\"onlineContacts\":null,\"productName\":\"Drafting Assistant (Westlaw™ PRO)\",\"noOfUsers\":1}]}]}";
        byte[] bytes = ajaxRequestData.getBytes(StandardCharsets.ISO_8859_1);
        ajaxRequestData = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("ajaxRequestData ::{}" + ajaxRequestData);

    }
}