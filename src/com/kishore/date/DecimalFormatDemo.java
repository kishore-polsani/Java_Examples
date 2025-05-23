package com.kishore.date;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class DecimalFormatDemo {

    static public void customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + " ===> " + pattern + " ===> " + output);
    }

    static public void localizedFormat(String pattern, double value,
                                       Locale loc) {
        NumberFormat nf = NumberFormat.getNumberInstance(loc);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern(pattern);
        String output = df.format(value);
        System.out.println(pattern + " ===> " + output + " ===> " + loc.toString());
    }

    static public void main(String[] args) {
        System.out.println("Number formats without Locale");
        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("###", 3.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);
        customFormat("\u00a5###,###.###", 12345.67);

        Locale currentLocale = new Locale("en", "US");

        DecimalFormatSymbols unusualSymbols =
            new DecimalFormatSymbols(currentLocale);
        unusualSymbols.setDecimalSeparator('|');
        unusualSymbols.setGroupingSeparator('^');
        String strange = "#,##0.###";
        DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);
        weirdFormatter.setGroupingSize(4);
        String bizarre = weirdFormatter.format(12345.678);
        System.out.println(bizarre);

        Locale[] locales = {
            new Locale("en", "US"),
            new Locale("de", "DE"),
            new Locale("fr", "FR")
        };
        System.out.println("Number formats with Locale");
        Arrays.stream(locales).forEach(locale -> localizedFormat("###,###.###", 123456.789, locale));

    }
}
