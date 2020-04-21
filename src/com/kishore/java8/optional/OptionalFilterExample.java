package com.kishore.java8.optional;

import java.util.Optional;

public class OptionalFilterExample {

    public static void main(String[] args) {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male")));
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("male")));
    }

}
