package com.kishore;

import java.util.HashMap;

public class HashmapNull {

    public static void main(String[] args) {
        HashMap<String, String> input = new HashMap<String, String>();
        String order = input.get("orderAction") == null ? null : "\"" + input.get("orderAction") + "\"";
        String s = "{" +
            "\"actionParams\":{" +
            "\"orderAction\":" + order + ",";
        System.out.println(s);
    }
}
