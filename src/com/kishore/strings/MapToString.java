package com.kishore.strings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MapToString {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("user1", "Kishore");
        map.put("user2", "Polsani");
        try {
            String json = new ObjectMapper().writeValueAsString(map);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            System.err.println("Unable to form JSON object: {}" + e.getMessage());
        }
    }
}
