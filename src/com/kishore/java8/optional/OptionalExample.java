package com.kishore.java8.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> nonEmptyGender = Optional.of("male");

        // Creating an empty optional
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

        //ispresent
        Optional<String> optional1 = Optional.of("isPresent");
        optional1.ifPresent(s -> System.out.println("Optional.isPresent :: " + s));
        //ifPresent
        Optional<String> optional2 = Optional.of("isPresent");
        optional2.ifPresent(s -> {
            System.out.println("Value is present");
            System.out.println("Optional.ifPresent :: " + s);
        });

        //orElse
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("default_name");
        System.out.println("orElse :: " + name);

        //orElseGet
        System.out.println("orElseGet :: " + Optional.ofNullable(nullName).orElseGet(() -> "john"));
        //System.out.println("orElseGet :: "+Optional.ofNullable(nullName).orElseGet(this::getDefaultValue));
    }

    public String getDefaultValue() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

}