package com.kishore.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDate {

    private final static Logger log = LoggerFactory.getLogger(CalculateDate.class);

    public static void main(String[] args) {
        CalculateDate obj = new CalculateDate();
        System.out.println("================================");
        log.info("===========Current DATE ::" + obj.getCurrentDate());
        log.info("End DATE :: " + obj.getEndDate(4));
        //log.info(obj.getAutoRenewalDateFormat("2017-07-1"));
        System.out.println("================================");
    }

    /*
     * To get end date calculated from current date
     */
    public String getEndDate(int duration) {
        String endDateFormat = "";
        DateFormat myDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // prints current date:
            log.info("Current Date: " + year + "-" + month + "-" + day);

            // add <duration> years
            calendar.add(Calendar.DATE, 365 * duration);

            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            day = calendar.get(Calendar.DAY_OF_MONTH);

            System.out.println("Date: " + year + "-" + month + "-" + day);
            String endDate = myDate.format(calendar.getTime());
            log.info("endDate: " + endDate);

            String lastDayofMonth = getLastDayOfTheMonth(year + "-" + month + "-" + day);
            log.info("lastDayofMonth: " + lastDayofMonth);

            CalculateDate dateObj = new CalculateDate();
            endDateFormat = dateObj.getDateFormat(lastDayofMonth);
            log.info("endDateFormat: " + endDateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endDateFormat;
    }

    public String getCurrentDate() {
        String curDateFormat = "";
        try {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            log.info("day: " + day);

            // prints current date:
            log.info("Current Date: " + year + "-" + month + "-" + day);
            CalculateDate dateObj = new CalculateDate();
            curDateFormat = dateObj.getDateFormat(year + "-" + month + "-" + day);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curDateFormat;
    }

    public static String getLastDayOfTheMonth(String date) {
        String lastDayOfTheMonth = "";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = formatter.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dt);

            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);

            Date lastDay = calendar.getTime();

            lastDayOfTheMonth = formatter.format(lastDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lastDayOfTheMonth;
    }

    public String getDurationDate(String dateStr, int duration) {

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
            log.info(dateStr + "Current date : " + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE) + "-"
                + now.get(Calendar.YEAR));

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

    public String getDateFormat(String dateStr) {
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
                log.info(day + " single digit: " + (int) Math.log10(day) + 1);
                newDay = "0" + day;
            } else {
                log.info(day + " double digit: " + (int) Math.log10(day) + 1);
            }

            //formattedDate = (months[now.get(Calendar.MONTH)]) + " " + now.get(Calendar.DATE) + ", "+ now.get(Calendar.YEAR);
            formattedDate = (months[now.get(Calendar.MONTH)]) + " " + newDay + ", " + now.get(Calendar.YEAR);
        } catch (ParseException e) {
            log.error(e.toString());
        }

        return formattedDate;
    }

    public String roundOff(Double number) {
        int decimalsToConsider = 0;
        BigDecimal bigDecimal = new BigDecimal(number);
        BigDecimal roundedValueWithDivideLogic = bigDecimal.divide(BigDecimal.ONE, decimalsToConsider,
            BigDecimal.ROUND_HALF_UP);
        log.info("Rounded value " + roundedValueWithDivideLogic);
        return roundedValueWithDivideLogic.toString();
    }

    public String getAutoRenewalDateFormat(String dateStr) {
        String formattedDate = "";
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

        SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateStr);

            Calendar now = Calendar.getInstance();
            now.setTime(dateObj);

            formattedDate = (months[now.get(Calendar.MONTH)]) + "/" + now.get(Calendar.DATE) + "/"
                + String.valueOf(now.get(Calendar.YEAR)).substring(2);
            log.info(new StringBuilder().append("formattedDate :").append(formattedDate).toString());
        } catch (ParseException e) {
            log.error(e.toString());
        }

        return formattedDate;
    }

}
