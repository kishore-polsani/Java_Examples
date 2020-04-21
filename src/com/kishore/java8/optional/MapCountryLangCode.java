package com.kishore.java8.optional;

import java.util.Locale;
import java.util.Optional;

public class MapCountryLangCode {

    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DEFAULT_COUNTRY = "US";

    public static void main(String[] args) {
        MapCountryLangCode obj = new MapCountryLangCode();
        System.out.println(obj.getCountryCode());
    }

    private String getCountryCode() {
        Locale usLocale = new Locale("en", "US");
        return Optional.ofNullable(usLocale).map(Locale::getCountry).orElse(DEFAULT_COUNTRY);
    }

    private String getLanguageCode() {
        Locale usLocale = new Locale("en", "US");
        return Optional.ofNullable(usLocale).map(Locale::getLanguage).orElse(DEFAULT_LANGUAGE);
    }
}
