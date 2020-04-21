package com.kishore.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Get all the name values from a list of the staff objects.
 */
public class StreamObjectToString {

    public static void main(String[] args) {
        List<Staff> staff = Arrays.asList(
            new Staff("Kishore", 30, new BigDecimal(1000000)),
            new Staff("Polsani", 31, new BigDecimal(2000000)),
            new Staff("Test", 31, new BigDecimal(2000000))
        );

        List<String> names = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(names);
    }
}
