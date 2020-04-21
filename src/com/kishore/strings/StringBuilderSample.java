package com.kishore.strings;

import java.util.stream.IntStream;

public class StringBuilderSample {

    static String a;

    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        IntStream.range(0, 1000).forEach(i -> {
            StringBuilder sb = new StringBuilder();
            sb.append("someString").append("someString2" + i).append("someStrin4g" + i).append("someStr5ing" + i).append("someSt7ring" + i);
            a = sb.toString();
        });
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 1000).forEach(i -> {
            sb.delete(0, sb.length());
            sb.append("someString");
            sb.append("someString2" + i);
            sb.append("someStrin4g" + i);
            sb.append("someStr5ing" + i);
            sb.append("someSt7ring" + i);
            a = sb.toString();
        });
        System.out.println(System.currentTimeMillis() - time);
    }
}
