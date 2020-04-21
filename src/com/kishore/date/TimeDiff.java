package com.kishore.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeDiff {

    public static void main(String[] args) {
        String digitallySignedDateTimeZone = "IST";
        //2018-01-05T07:50:14.000+0000
        String lastModifiedDate = "2018-01-05T10:09:02.000+0000";
        lastModifiedDate = lastModifiedDate.substring(0, lastModifiedDate.indexOf("+"));//2018-01-05T07:50:14.000-00:00
        lastModifiedDate = lastModifiedDate + "-00:00";
        System.out.println("lastModifiedDate: " + lastModifiedDate);

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date oldDate = null;
        String currentDateStr = null;
        Date currentDate = null;
        try {
            oldDate = sdf.parse(lastModifiedDate);
            currentDateStr = sdf.format(new Date());
            currentDate = sdf.parse(currentDateStr);
            sdf.setTimeZone(TimeZone.getTimeZone(digitallySignedDateTimeZone));
            System.out.println("oldDate :: " + sdf.format(oldDate));
            System.out.println("currentDate :: " + sdf.format(currentDate));

            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentDate);

            Calendar oldCalendar = Calendar.getInstance();
            oldCalendar.setTime(oldDate);

            long timeDiff = currentCalendar.getTimeInMillis() - oldCalendar.getTimeInMillis();
            System.out.println("timeDiff: " + (timeDiff / 1000) / 60);
            if ((timeDiff / 1000) / 60 <= 5) {
                System.out.println("Modified in 5 mins");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
