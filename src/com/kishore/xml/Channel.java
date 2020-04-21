package com.kishore.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "channel")
public class Channel {

    @XmlElement
    private Item[] Item = new Item[1]; // as the tag name in the xml file..

    public Item[] getItem() {
        return Item;
    }

    public void setItem(Item[] item) {
        Item = item;
    }

}