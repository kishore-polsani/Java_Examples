package com.kishore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

    public static void main(String[] args) {
        String renewalDate = "2017-08-31";
        System.out.println("renewal date: " + getDateFormat(renewalDate));
        System.out.println("duration date: " + getDurationDate(renewalDate, 3));

    }

    private final static Logger log = LoggerFactory.getLogger(DateFormat.class);

    public static String getDurationDate(String dateStr, int duration) {

        SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj = null;
        String durationStr = "";
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            dateObj = curFormater.parse(dateStr);

            Calendar now = Calendar.getInstance();
            now.setTime(dateObj);
            log.info(dateStr + "Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
                + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

            now.add(Calendar.YEAR, duration);
            year = now.get(Calendar.YEAR);
            month = (now.get(Calendar.MONTH) + 1);
            day = now.get(Calendar.DATE);

            durationStr = year + "-" + month + "-" + day;
            durationStr = getDateFormat(durationStr);

        } catch (ParseException e) {
            log.error(e.toString());
        }
        return durationStr;
    }

    public static String getDateFormat(String dateStr) {
        String formattedDate = "";
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

        SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateStr);

            Calendar now = Calendar.getInstance();
            now.setTime(dateObj);

            formattedDate = (months[now.get(Calendar.MONTH)]) + " " + now.get(Calendar.DATE) + ", " + now.get(Calendar.YEAR);
        } catch (ParseException e) {
            log.error(e.toString());
        }

        return formattedDate;
    }

}
