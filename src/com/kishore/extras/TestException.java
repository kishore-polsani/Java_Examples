package com.kishore.extras;

import org.json.JSONObject;

import java.util.HashMap;

public class TestException {

    private static final String PIPE = "\\|";

    public static void main(String[] args) {
        String decryptedToken = "-E803-1111-5000000000000N|brand=visa|datemon=03|dateyrs=2025|code=123|CustomerName=TEST";
        System.out.println("JSON: " + parseDecryptedToken(decryptedToken));

    }

    private static JSONObject parseDecryptedToken(String decryptedToken) {
        String[] cardDetails = null;
        JSONObject ccObj = null;
        HashMap<String, String> ccMap = null;
        try {
            cardDetails = decryptedToken.split(PIPE);
            ccObj = new JSONObject();
            System.out.println("length: " + cardDetails.length);
            if (cardDetails.length > 0) {
                ccMap = new HashMap<>();
                for (String element : cardDetails) {
                    System.out.println(element);
                    getCreditCartProperties(element, ccMap);
                }
                ccObj = getResponseJson(ccMap);
                return ccObj;
            }

        } catch (Exception e) {
            System.err.println("[parseDecryptedToken] Exception: " + e);
        }
        return null;
    }

    private static JSONObject getResponseJson(HashMap<String, String> ccMap) {
        JSONObject ccObj = null;
        String ccToken = "";
        try {
            ccObj = new JSONObject();
            System.out.println(ccMap);
            if (null != ccMap) {
                ccToken = ccMap.get("ccToken");
                ccToken = ccToken.split("-")[2];
                System.out.println(ccToken);
                ccObj.put("ccNumber", ccToken);
                ccObj.put("status", true);
                ccObj.put("ccType", ccMap.get("brand"));
            } else {
                ccObj.put("status", false);
            }

            return ccObj;
        } catch (Exception e) {
            System.err.println("[getResponseJson] Exception: " + e);
        }
        return null;
    }

    private static void getCreditCartProperties(String element, HashMap<String, String> ccMap) {

        try {
            if (element.indexOf("=") < 1) {
                ccMap.put("ccToken", element);
            }
            String[] cardProp = element.split("=");
            ccMap.put(cardProp[0], cardProp[1]);

        } catch (Exception e) {
            System.err.println("[getCreditCartProperties] Exception: " + e);
        }
    }
}