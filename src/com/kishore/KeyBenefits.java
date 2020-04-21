package com.kishore;

import java.util.ArrayList;

public class KeyBenefits {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Case Reports");
        list.add("Case Reports");
        list.add("Court Orders");
        list.add("Court Orders");
        list.add("Court Orders");
        list.add("Court Rules");
        list.add("Court Rules");
        list.add("Court Rules");
        list.add("Headnotes/Digests");
        list.add("Headnotes/Digests");
        list.add("Headnotes/Digests");
        list.add("Journals & Law Reviews");
        list.add("Journals & Law Reviews");
        list.add("Legislative Histories");
        list.add("Legislative Histories");
        list.add("Legislative Histories");
        list.add("Legislative Services");
        list.add("Legislative Services");
        list.add("Legislative Services");
        list.add("Public Laws");
        list.add("Public Laws");
        list.add("Public Laws");
        list.add("Regulations");
        list.add("Regulations");
        list.add("Statutes Annotated");
        list.add("Statutes Annotated");
        list.add("Statutes Annotated");
        list.add("");
        list.add("");
        list.add("");
        list.add("Administrative Decisions & Guidance");
        list.add("Administrative Decisions & Guidance");
        list.add("Administrative Decisions & Guidance");
        list.add("Case Reports");
        list.add("Journals & Law Reviews");
        System.out.println("before list " + list.size());
        list = filterKeyBenefits(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
    }

    private static ArrayList<String> filterKeyBenefits(ArrayList<String> list) {
        // TODO Auto-generated method stub
        System.out.println("list size:" + list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            //log.info(list.get(i).()+"###"+list.get(i).()+"###"+list.get(i).());
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).equals(list.get(j))) {

                    list.remove(j);
                }

            }
        }

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i).isEmpty()) {

                list.remove(i);
            }
            if (list.get(i).equals(list.get(i + 1))) {
                System.out.println("equals " + list.get(i));
                list.remove(i);
            }
        }

        System.out.println("after list " + list.size());
        return list;
    }
}

