package com.kishore.extras;

import java.util.*;
import java.util.Map.Entry;

public class SortHashmap {

    public static void main(String[] args) {
        Map<String, ArrayList<SortedHashmapPojo>> map = new HashMap<String, ArrayList<SortedHashmapPojo>>();
        SortedHashmapPojo obj1 = new SortedHashmapPojo();
        obj1.setDbCategory("9111");
        obj1.setDbGroup("9111");
        obj1.setDbGroupOrder(1);

        SortedHashmapPojo obj2 = new SortedHashmapPojo();
        obj2.setDbCategory("222");
        obj2.setDbGroup("222");
        obj2.setDbGroupOrder(2);

        SortedHashmapPojo obj3 = new SortedHashmapPojo();
        obj3.setDbCategory("333");
        obj3.setDbGroup("333");
        obj3.setDbGroupOrder(55);

        SortedHashmapPojo obj4 = new SortedHashmapPojo();
        obj4.setDbCategory("444");
        obj4.setDbGroup("444");
        obj4.setDbGroupOrder(4);

        ArrayList<SortedHashmapPojo> list1 = new ArrayList<SortedHashmapPojo>();
        ArrayList<SortedHashmapPojo> list2 = new ArrayList<SortedHashmapPojo>();
        ArrayList<SortedHashmapPojo> list3 = new ArrayList<SortedHashmapPojo>();
        ArrayList<SortedHashmapPojo> list4 = new ArrayList<SortedHashmapPojo>();
        list1.add(obj1);
        list2.add(obj2);
        list3.add(obj3);
        list4.add(obj4);

        map.put("aaa", list1);
        map.put("bbb", list2);
        map.put("ccc", list3);
        map.put("ddd", list4);
        List<Entry<String, ArrayList<SortedHashmapPojo>>> entries = new ArrayList<Entry<String, ArrayList<SortedHashmapPojo>>>(
            map.entrySet());

        Collections.sort(entries, new Comparator<Entry<String, ArrayList<SortedHashmapPojo>>>() {
            public int compare(Entry<String, ArrayList<SortedHashmapPojo>> o1,
                               Entry<String, ArrayList<SortedHashmapPojo>> o2) {
                if (o1.getValue().get(0).getDbGroupOrder() > o2.getValue().get(0).getDbGroupOrder()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (Entry<String, ArrayList<SortedHashmapPojo>> e : entries) {
            System.out.println(e.getKey() + " : [" + e.getValue().get(0) + "]");
        }
    }

}
