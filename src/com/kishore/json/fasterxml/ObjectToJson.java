package com.kishore.json.fasterxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;

public class ObjectToJson {

    public static void main(String[] args) throws JsonProcessingException {

        /**
         * Create customer object
         */

        CustomerObject customer = new CustomerObject();
        customer.setAge(31);
        customer.setFirstName("Kishore");
        customer.setMiddleName("");
        customer.setLastName("Polsani");
        customer.setCountry("UK");
        customer.setCity("London");
        customer.setContacts(Arrays.asList("8095185442", "9998887654", "1234567890"));

        /**
         * Ignore city and country property
         */
        String[] ignorableFieldNames = {"city", "country"};

        /**
         * In the add filter pass com.sample.pojo.Customer
         * Which is mentioned in the Customer class with @JsonFilter
         */
        FilterProvider filters = new SimpleFilterProvider().addFilter("com.kishore.json.fasterxml.CustomerObjectk",
            SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));

        ObjectMapper mapper = new ObjectMapper();

        /**
         * Pass the filter
         */
        ObjectWriter writer = mapper.writer(filters);

        /**
         * Convert Object to JSON
         */
        String jsonString = writer.writeValueAsString(customer);
        System.out.println(jsonString);

    }
}
