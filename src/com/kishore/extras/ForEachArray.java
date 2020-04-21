package com.kishore.extras;

import java.util.ArrayList;

public class ForEachArray {

    public static void main(String[] args) {
        ArrayList<Records> list1 = new ArrayList<>();
        ArrayList<Contact> list2 = new ArrayList<>();
        ArrayList<Contact> list3 = new ArrayList<>();

        Records obj1 = new Records();
        obj1.setName("Kishore");
        Records obj2 = new Records();
        obj2.setName("Chandan");
        list1.add(obj1);
        list1.add(obj2);

        Contact c = new Contact();
        c.setName("Kishore");
        list2.add(c);

        for (Records r : list1) {

            for (Contact c1 : list2) {
                if (r.name.equals(c1.name) && c1.title != "xyz") {
                    list3.add(c1);
                    System.out.println(r.name);
                }

            }
        }

    }
}
