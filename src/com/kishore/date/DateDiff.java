package com.kishore.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateDiff {

    public static void main(String[] args) throws ParseException {
        //System.out.println("date is :"+util.getTimeFormat("2017-09-11"));
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("fdate " + df.format(today));

        String todayDate = df.format(today);
        String lastModifiedDate = "2017-08-23";
        String RenewalDate = "2017-11-01";
        System.out.println("todayDate " + todayDate);
                
                /* Calendar todaysDate = Calendar.getInstance();
                Calendar lastUpdatedDate = Calendar.getInstance();
                Calendar renDate = Calendar.getInstance();
                */

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //For declaring values in new date objects. use same date format when creating dates
        Date currentDate = sdf.parse(todayDate); //date1 is February 23, 1995
        Date lastMDate = sdf.parse(lastModifiedDate); //date2 is October 31, 2001
        Date renewlDate = sdf.parse(RenewalDate); //date3 is February 23, 1995

        System.out.println("lstmd " + lastMDate.getTime() / (1000 * 60 * 60 * 24));
        System.out.println("currentD " + currentDate.getTime() / (1000 * 60 * 60 * 24));
        System.out.println("renewa " + renewlDate.getTime() / (1000 * 60 * 60 * 24));
                
                /*todaysDate.setTime(currentDate);
                lastUpdatedDate.setTime(lastMDate);
                renDate.setTime(renewlDate);
        /*       cal1.add(Calendar.DATE,30);
                System.out.println("sdsads"+cal1.getTime());
                if(lastUpdatedDate.equals(todaysDate)){
                        System.out.println("dates are equal");
                        System.out.println("t"+todaysDate.getTime());
                        System.out.println("t"+renDate.getTime());
                
                        if(renDate.before(todaysDate)){
                                
                        }
                }*/

        if (lastMDate.getTime() == currentDate.getTime()) {
            System.out.println(renewlDate.getTime() - currentDate.getTime());

            if ((renewlDate.getTime() - currentDate.getTime()) / ((1000 * 60 * 60 * 24)) > 30) {
                System.out.println("show 30 days");
            } else {
                System.out.println("\n Plan saved " + (renewlDate.getTime() - currentDate.getTime()) / ((1000 * 60 * 60 * 24)) + " days");

            }
        }
        //System.out.println("renewlDate.getTime()-currentDate.getTime() "+(renewlDate.);
        if (lastMDate.getTime() < currentDate.getTime()) {
            if ((renewlDate.getTime() - currentDate.getTime()) / ((1000 * 60 * 60 * 24)) > 30) {
                System.out.println("\n Plan saved " + (30 - (currentDate.getTime() - lastMDate.getTime()) / ((1000 * 60 * 60 * 24))) + " days");
            } else {
                System.out.println("\n Plan saved " + ((renewlDate.getTime() - currentDate.getTime()) / ((1000 * 60 * 60 * 24))));
            }
        }
                
                /*
                 *  String lastModifiedDate="2017-09-19";
                String RenewalDate="2017-11-01";
                 *If
					Last Modified Date = TODAY()
					THEN
						IF
							Renewal Date() - Today() > 30
									SHOW 30 days
						ELSE
							SHOW Renewal Date() - Today() days
				If
					Last Modified Date() < TODAY()
					THEN
						IF
							Renewal Date() - Today() > 30
								SHOW 30 - (TODAY() - Last Modified Date) days
						ELSE
							SHOW Renewal Date() - Today() days
			*/

    }
}
