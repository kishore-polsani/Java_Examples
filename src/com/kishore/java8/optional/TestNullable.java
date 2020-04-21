package com.kishore.java8.optional;

import java.util.Optional;

public class TestNullable {

    public static void main(String[] args) {

        // create a Optional
        Optional<Integer> op1 = Optional.ofNullable(null);

        // print value
        System.out.println("Optional 1: " + op1);
    }
}
