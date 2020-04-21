package com.kishore.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cxd")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlElement
    private Channel[] channel = new Channel[1]; // as the tag name in the xml file..

    public Channel[] getChannel() {
        return channel;
    }

    public void setChannel(Channel[] channel) {
        this.channel = channel;
    }

}