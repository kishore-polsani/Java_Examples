package com.kishore.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDate {

    public static void main(String[] args) throws ParseException {

        String dateStr = "2017-03-28";
        int duration = 3;
        System.out.println("" + getDurationDate(dateStr, duration));

    }

    public static String getDurationDate(String dateStr, int duration) {

        SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj = null;
        String durationStr = "";
        try {
            dateObj = curFormater.parse(dateStr);
            System.out.println(dateObj);

            Calendar now = Calendar.getInstance();
            now.setTime(dateObj);
            System.out.println(dateStr + "Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
                + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

            now.add(Calendar.YEAR, duration);
            System.out.println("date after one year : " + (now.get(Calendar.MONTH) + 1) + "-"
                + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
            durationStr = now.get(Calendar.YEAR) + "-"
                + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return durationStr;
    }
}
	/*
	Current date : 2-20-2009
	date after one day : 2-21-2009
	*/