package com.kishore.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CompareTimes {

    public static void main(String[] args) {
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:SS z");
        df.setTimeZone(TimeZone.getTimeZone("IST"));
        String argCurrentTime = df.format(today);

        Date startTime = null;
        Date endTime = null;
        Date currentDate = null;

        try {
            SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");

            String[] currentTime = argCurrentTime.split(":");
            argCurrentTime = currentTime[0] + ":" + currentTime[1];
            System.out.println("time is " + argCurrentTime);
            String argStartTime = "12:27 PM";
            String argEndTime = "10:51 AM";
            startTime = parseFormat.parse(argStartTime);
            endTime = parseFormat.parse(argEndTime);
            currentDate = displayFormat.parse(argCurrentTime);

            System.out.println("show chat: " + isTimeBetweenTwoTime(argStartTime, argEndTime, argCurrentTime));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static boolean isTimeBetweenTwoTime(String argStartTime, String argEndTime, String argCurrentTime)
        throws ParseException {
        boolean valid = false;
        // Start Time
        Date startTime = new SimpleDateFormat("hh:mm a").parse(argStartTime);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);

        // End Time
        Date endTime = new SimpleDateFormat("hh:mm a").parse(argEndTime);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endTime);

        // Current Time
        Date currentTime = new SimpleDateFormat("HH:mm").parse(argCurrentTime);
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(currentTime);

        if (currentTime.compareTo(endTime) < 0) {
            currentCalendar.add(Calendar.DATE, 1);
            currentTime = currentCalendar.getTime();
        }
        if (startTime.compareTo(endTime) < 0) {
            startCalendar.add(Calendar.DATE, 1);
            startTime = startCalendar.getTime();
        }
        if (currentTime.before(startTime)) {
            System.out.println(" Time is Lesser ");
            valid = false;
        } else {
            if (currentTime.after(endTime)) {
                endCalendar.add(Calendar.DATE, 1);
                endTime = endCalendar.getTime();
            }

            System.out.println("Comparing , Start Time :: " + startTime);
            System.out.println("Comparing , End Time :: " + endTime);
            System.out.println("Comparing , Current Time :: " + currentTime);

            if (currentTime.before(endTime)) {
                System.out.println("RESULT, Time lies b/w");
                valid = true;
            } else {
                valid = false;
                System.out.println("RESULT, Time does not lies b/w");
            }

        }
        return valid;
    }
}
