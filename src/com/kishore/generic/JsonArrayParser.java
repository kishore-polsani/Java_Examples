package com.kishore.generic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonArrayParser {

    public static void main(String[] args) {
        try {
            JSONArray addOnDetails = new JSONArray(
                "[{\"productId\":\"01t13000005wyvXAAQ\",\"productTitle\":\"Drafting Assistant (Westlaw� PRO)\",\"isRecommendedProduct\":\"true\",\"quantity\":\"1\",\"price\":\"$146/mo\",\"contractTerm\":\"3 Years\"},{\"productId\":\"01t1B000005hqdpQAA\",\"productTitle\":\"West LegalEdcenter\",\"isRecommendedProduct\":\"true\",\"quantity\":\"1\",\"price\":\"$67/mo\",\"contractTerm\":\"3 Years\"}]");
            JSONArray selectedAddOnDetails = new JSONArray();
            ArrayList<String> selectedPid = new ArrayList<>();
            selectedPid.add("01t13000005wyvXAAQ");
            selectedPid.add("01t1B000005hqdpQAA");

            int i = 0;
            while (i < addOnDetails.length()) {

                JSONObject addonObj = (JSONObject) addOnDetails.get(i);
                String addonId = addonObj.getString("productId");
                if (selectedPid.contains(addonId)) {
                    selectedAddOnDetails.put(addonObj);
                    System.out.println(selectedAddOnDetails);
                } else {
                    System.out.println(false);
                }
                i++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
