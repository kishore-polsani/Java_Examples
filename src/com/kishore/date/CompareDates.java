package com.kishore.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareDates {

    public static void main(String[] args) {
        String renewalDate = "2018-10-31";
        CompareDates obj = new CompareDates();
        obj.isRenewalCompleted(renewalDate);
    }

    public void isRenewalCompleted(String renewalDate) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(renewalDate);
            Date date2 = new Date();

            System.out.println("Date1: " + sdf.format(date1));
            System.out.println("Date2: " + sdf.format(date2));
            System.out.println();

            // after() will return true if and only if date1 is after date 2
            if (date1.after(date2)) {
                System.out.println("renewalDate is after Today");
            }
            // before() will return true if and only if date1 is before date2
            if (date1.before(date2)) {
                System.out.println("renewalDate {" + date1 + "} is before Today {" + date2 + "}");
            }

            //equals() returns true if both the dates are equal
            if (date1.equals(date2)) {
                System.out.println("renewalDate is equal Today");
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }
}
