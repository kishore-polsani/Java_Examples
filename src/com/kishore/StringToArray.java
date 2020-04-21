package com.kishore;

import java.util.regex.PatternSyntaxException;

public class StringToArray {

    public static void main(String[] args) {
        String input = "hello world lorel ## ipsum test kishore";
        try {
            String[] splitArray = input.split("##");
            for (String string : splitArray) {
                System.out.println(string);
            }
        } catch (PatternSyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
