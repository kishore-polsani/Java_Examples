package com.kishore.generic;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class Encrypter {

    public static void main(String[] args) {
        String encryptString = "aemuser:aemuser1";
        Encrypter e = new Encrypter();

        try {
            System.out.println("" + e.encode(encryptString));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public String encode(String value) throws Exception {
        return DatatypeConverter.printBase64Binary
            (value.getBytes(StandardCharsets.UTF_8)); // use "utf-8" if java 6
    }
}
