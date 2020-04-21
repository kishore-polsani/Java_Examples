package com.kishore.encode;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class Base64EncodeDecode {

    private Base64EncodeDecode() {
    }

    public static String encode(String value) throws Exception {
        return DatatypeConverter.printBase64Binary
            (value.getBytes(StandardCharsets.UTF_8)); // use "utf-8" if java 6
    }

    public static String decode(String value) throws Exception {
        byte[] decodedValue = DatatypeConverter.parseBase64Binary(value);
        return new String(decodedValue, StandardCharsets.UTF_8); // use "utf-8" if java 6
    }

    public static void main(String[] args) throws Exception {
        //String test = "esidevuser:esidevuser123";
        //String test = "SL Jury Verdicts and Case Evaluator (Westlaw PRO�\\u0084�)";
        String test = "Kishore";

        //String test = "aemuser:aemuser1";
        //String test = "apache:Mbi@m151991";

        String res1 = Base64EncodeDecode.encode(test);
        System.out.println
            (test + " base64 -> " + res1);

        String res2 = Base64EncodeDecode.decode(res1);
        System.out.println(res1 + " string --> " + res2);

        /*
         * output
         *  try this howto base64 -> dHJ5IHRoaXMgaG93dG8=
         *  dHJ5IHRoaXMgaG93dG8= string --> try t
         */
    }
}