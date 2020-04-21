package com.kishore.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RegionList")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegionList {

    Item[] Item = new Item[1];

    public Item[] getItem() {
        return Item;
    }

    public void setItem(Item[] item) {
        Item = item;
    }

}