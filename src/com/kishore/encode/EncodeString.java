package com.kishore.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodeString {

    public static void main(String[] args) {
        String displayChart = "{\"title\":\"Out-of-plan transactions\",\"timeframe\":\"Last 12 months\",\"value1\":4,\"value2\":1}";
        try {
            displayChart = URLEncoder.encode(displayChart, "UTF-8").replace("\\", "%2B");
            displayChart = displayChart.replace("+", " ");
            System.out.println(displayChart);

            String productName = "SL Jury Verdicts and Case Evaluator (Westlaw PRO�\\u0084�)";
            String price = "345.56";
            System.out.println(Math.round(Double.valueOf(price)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
