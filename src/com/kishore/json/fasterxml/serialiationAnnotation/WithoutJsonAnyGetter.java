package com.kishore.json.fasterxml.serialiationAnnotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WithoutJsonAnyGetter {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Student student = new Student();
        student.add("name", "Kishore");
        student.add("id", "1");

        String jsonString = null;
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);
    }
}
