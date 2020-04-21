package com.kishore.java8.optional;

import java.util.Optional;

public class TestNullPointer {

    public static void main(String[] args) {

        try {
            // create a Optional
            Optional<Integer> op = Optional.of(null);

            // print value
            System.out.println("Optional: " + op);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
