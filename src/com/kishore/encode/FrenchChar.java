package com.kishore.encode;

import org.apache.commons.lang3.StringEscapeUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FrenchChar {

    public static void main(String[] args) {
        try {
            String aaa = "Service d&#39;abonnement annuel";
            String bbb = "Service d'abonnement annuel";
            System.out.println("aaa   " + aaa);
            System.out.println(StringEscapeUtils.unescapeHtml4("Service d&#39;abonnement annuel"));

            aaa = new String(aaa.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            System.out.println("=aaa   " + aaa);
            /*aaa = URLDecoder.decode(aaa,"UTF-8");*/
            aaa = URLEncoder.encode(aaa, "UTF-8");
            System.out.println("aaa   " + aaa);

            bbb = URLDecoder.decode(new String(aaa.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8), "ISO-8859-1");

            System.out.println("aaa   " + aaa);
            System.out.println("bbb   " + bbb);

            aaa = URLEncoder.encode(bbb, "UTF-8");
            System.out.println("aaa   " + aaa);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}