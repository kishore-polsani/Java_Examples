package com.kishore.java8.optional;
/*
Optional is a container object which may or may not contain a non-null value.
You must import java.util package to use this class.

Optional.ofNullable() method returns a Non-empty Optional if a value present in the given object. Otherwise returns empty Optional.
 */

import java.util.Optional;

public class OptionalOfNullable {

    public static void main(String[] args) {
        String[] words = new String[10];
        Optional<String> checkNull =
            Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        } else {
            System.out.println("word is null - " + checkNull);
        }
    }
}

