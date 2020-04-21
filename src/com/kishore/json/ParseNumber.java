package com.kishore.json;

import org.json.JSONException;

import java.text.DecimalFormat;

public class ParseNumber {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        String data = "{\"name\": \"alice\", \"amount\": 2.30}";
        org.json.JSONObject object;
        try {
            object = new org.json.JSONObject(data);
            System.out.println(object.get("amount"));
            System.out.println("Long: " + object.getLong("amount"));
            System.out.println("double: " + (float) object.getDouble("amount"));

            System.out.println("Int: " + object.getInt("amount"));
            System.out.println("double : " + df.format(object.getDouble("amount")));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
