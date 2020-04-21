package com.kishore.extras;

public class RemoveHTMLTagsTest {

    public static void main(String[] args) {
        String str = "<p><b>Welcome to Tutorials <a href=\"#\">link here</a> Point</b></p>";
        System.out.println("Before removing HTML Tags: " + str);
        str = str.replaceAll("\\<.*?\\>", "");
        System.out.println("After removing HTML Tags: " + str);
    }
}