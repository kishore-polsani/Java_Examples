package com.kishore;

import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class StringSubstitutor {

    public static void main(String[] args) {
        String source = "firstname";
        String destination = "Kishore";
        String message = "Hi ${firstname}, jumped over the ${target}.";

        parseDialogMessage(message, source, destination);
    }

    private static void parseDialogMessage(String message, String source, String actualValue) {
        Map valuesMap = new HashMap();
        valuesMap.put(source, actualValue);

        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(message);
        System.out.println(resolvedString);
    }

}
