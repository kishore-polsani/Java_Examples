package com.kishore.strings;

public class SplitString {

    public static void main(String[] args) {
        String str = "3";
        String[] splited = str.split("\\s+");
        System.out.println(splited[0]);

        String page = "/content/smalllaw/en/renew";
        page = page.substring(page.lastIndexOf('/') + 1);
        System.out.println("Page: " + page);
        int i = 1;
        if (i == 1 && !"quote".equalsIgnoreCase(page)) {
            System.out.println("Total number of quotes are 1, redirection user to quote.html?quoteId=");
            //getResponse().sendRedirect("/content/smalllaw/en/quote.html?quoteId="+accountId+opportunityId);
        }
    }
}
