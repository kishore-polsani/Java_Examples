package com.kishore.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMExampleJava {

    public static void main(String[] args) {
        try {

            File stocks = new File("ProductfeedCANADA.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("root of xml file: " + doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getElementsByTagName("channel");
            System.out.println("==========================" + nodes.getLength());

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("childnodes: " + node.getChildNodes());
                if (node.getNodeType() == Node.ELEMENT_NODE) {//node=stock
                    Element element = (Element) node;
                    System.out.println(" title: " + getValue("title", element));
                    System.out.println(" ProductId: " + getValue("ProductId", element));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodes.item(0);
        return node.getNodeValue();
    }
}
