package com.kishore.json.fasterxml;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperString {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        System.out.println("JSON String: " + getJsonString());
    }

    private static String getJsonString() {
        return OBJECT_MAPPER.createObjectNode().put("firstName", "Kishore").put("lastName", "Polsani").toString();
    }

}
