package com.kishore.strings;

public class StringFormat {

    public static void main(String[] args) {
        String template = "Hello %s, Please find attached %s which is due on %s";

        String message = String.format(template, "Kishore", "invoiceNumber", "today");
        System.out.println(message);

    }
}



