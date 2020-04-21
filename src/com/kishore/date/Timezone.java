package com.kishore.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timezone {

    public static void main(String[] args) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = new Date();
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(date));

        DateFormat sdf1 = new SimpleDateFormat("HH:mm:ss z");
        sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("time :: " + sdf1.format(date));

        //2017-09-20T15:45:10.736+05:30
    }
}
