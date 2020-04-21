package com.kishore.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        String emailBlurb = "This contract was approved by the acceptance of the Terms & Conditions on ${date}";
        emailBlurb = emailBlurb.replace("${date}", "" + new Date());
        System.out.println(emailBlurb);
        getDateFormat("" + new Date());
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

            int day = now.get(Calendar.DATE);
            String newDay = "" + day;
            if (day < 10 && (int) (Math.log10(day) + 1) == 1) {
                newDay = "0" + day;
            }

            //formattedDate = (months[now.get(Calendar.MONTH)]) + " " + now.get(Calendar.DATE) + ", "+ now.get(Calendar.YEAR);
            formattedDate = (months[now.get(Calendar.MONTH)]) + " " + newDay + ", " + now.get(Calendar.YEAR);
        } catch (ParseException e) {
            System.err.println("Exception getDateFormat " + e);
        }

        return formattedDate;
    }
}
