package com.kishore.generic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {

    public static void main(String[] args) {
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:SS z");
        df.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        String time = df.format(today);
        System.out.println(time);
        df.setTimeZone(TimeZone.getTimeZone("US/Central")); //
        System.out.println(time);
        df.setTimeZone(TimeZone.getTimeZone("EST"));
        time = df.format(today);
        System.out.println(time);
        df.setTimeZone(TimeZone.getTimeZone("CST"));
        time = df.format(today);
        System.out.println(time);
        df.setTimeZone(TimeZone.getTimeZone("IST"));
        time = df.format(today);
        System.out.println(time);

        System.out.println(time.split(":")[0]);
    }

}
/*
 * EST time is not the correct time because it is actually 04:55 there right now, so US/Eastern will give you the correct (EDT) time.
 * As a rule of thumb, I would recommend always using the US/Eastern and  US/Central formats for safety.
 * */
 