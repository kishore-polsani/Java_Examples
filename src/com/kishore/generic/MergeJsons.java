package com.kishore.generic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public class MergeJsons {

    public static void main(String[] args) throws JSONException {

        JSONObject object1 = new JSONObject("{\n" +
            "    \"name\": [\n" +
            "        \"Karbonn Smart A12 Star (Black & Silver)\",\n" +
            "        \"Nokia 220 (Black)\",\n" +
            "        \"Karbonn Smart A52 Plus (Black & Gold)\",\n" +
            "        \"Karbonn Smart A12 Star (White & Gold)\",\n" +
            "        \"Karbonn Smart A50s (Black)\",\n" +
            "        \"Karbonn Smart A52 Plus (White & Silver)\",\n" +
            "        \"Karbonn Titanium S2 Plus (White)\",\n" +
            "        \"Karbonn Smart A11 Star (Black)\",\n" +
            "        \"Karbonn Smart A11 Star (White)\"\n" +
            "    ]\n" +
            "}");

        JSONObject object2 = new JSONObject("{\n" +
            "    \"price\": [\n" +
            "        \"Rs. 3,699\",\n" +
            "        \"Rs. 2,599\",\n" +
            "        \"Rs. 2,499\",\n" +
            "        \"Rs. 3,699\",\n" +
            "        \"Rs. 2,699\",\n" +
            "        \"Rs. 2,499\",\n" +
            "        \"Rs. 4,999\",\n" +
            "        \"Rs. 4,399\",\n" +
            "        \"Rs. 4,499\"\n" +
            "    ]\n" +
            "}");

        JSONArray nameArray = object1.getJSONArray("name");
        JSONArray priceArray = object2.getJSONArray("price");

        JSONObject mergedObject = new JSONObject("{}");
        Collection<JSONObject> collection = new ArrayList<>();

        for (int i = 0; i < nameArray.length(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", nameArray.getString(i));
            obj.put("price", priceArray.getString(i));
            collection.add(obj);
        }

        mergedObject.put("mobile", collection);
        System.out.println(mergedObject);
    }
}
