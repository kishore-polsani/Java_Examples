package com.kishore.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentDateInformat {

    public static void main(String[] args) {
        getCurrentDate();
    }

    /**
     * get current date
     */
    private static void getCurrentDate() {
        Format formatter = new SimpleDateFormat("dd-MMM-yy");
        String today = formatter.format(new Date());
        System.out.println(today.toUpperCase());

    }
}
