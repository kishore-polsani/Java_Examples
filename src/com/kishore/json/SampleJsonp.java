package com.kishore.json;

import javax.json.Json;
import javax.json.JsonObject;

public class SampleJsonp {

    public static void main(String[] args) {
        JsonObject jsonObject =
            Json.createObjectBuilder()
                .add("name", "Ersin")
                .add("surname", "�etinkaya")
                .add("age", 25)
                .add("address",
                    Json.createObjectBuilder()
                        .add("city", "Bursa")
                        .add("country", "T�rkiye")
                        .add("zipCode", "33444"))
                .add("phones",
                    Json.createArrayBuilder()
                        .add("234234242")
                        .add("345345354"))
                .build();
        System.out.println(jsonObject);
    }
}

/*
 * {
  "name": "Ersin",
  "surname": "�etinkaya",
  "age": 25,
  "address": {
    "city": "Bursa",
    "country": "T�rkiye",
    "zipCode": "33444"
  },
  "phones": [
    "234234242",
    "345345354"
  ]
}
 */
