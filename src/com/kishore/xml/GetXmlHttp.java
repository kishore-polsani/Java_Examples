package com.kishore.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetXmlHttp {

    private static final String CONTENT_PATH = "/en-ca/pdp";  //Should be dynamic from OSGI
    private static final String HOSTNAME = "http://localhost";//Should be dynamic
    private static final String INDEX_FILE_URL = "https://static.legalsolutions.thomsonreuters.com/canada/nonprod/ProductfeedCANADA.xml";//Should be dynamic from OSGI

    public static void main(String[] args) {

        try {
            System.out.println("Index file URL: {} " + INDEX_FILE_URL);
            Document doc = getIndexFileFromStaticServer(INDEX_FILE_URL);

            createSitemap(doc);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Get index from from the URL
     *
     * @param indexFileUrl
     * @return
     * @throws MalformedURLException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private static Document getIndexFileFromStaticServer(String indexFileUrl)
        throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
        URL url = new URL(indexFileUrl);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(url.openStream());
        return doc;
    }

    private static void createSitemap(Document doc) {
        doc.getDocumentElement().normalize();

        System.out.println("root of xml file: " + doc.getDocumentElement().getNodeName());
        NodeList nodes = doc.getElementsByTagName("channel");
        System.out.println(" element subchild count: " + nodes.getLength());
        Node node = nodes.item(0);
        NodeList itemNodes = node.getChildNodes();
        System.out.println(node.getNodeName() + " element subchild count: " + itemNodes.getLength());

        for (int i = 0; i < itemNodes.getLength(); i++) {
            try {
                Node itemNode = itemNodes.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) itemNode;
                    System.out.println("==========================");

                    String productId = getValue("ProductId", element);
                    String title = getValue("title", element);
                    title = title.replace(' ', '-');
                    title = HOSTNAME + CONTENT_PATH + "/" + title.replaceAll("[^a-zA-Z0-9-]", "") + "/" + productId;

                    System.out.println("<loc>" + title + "</loc>");
                    System.out.println("<lastmod>" + getValue("pubDate", element) + "</lastmod>");
                    System.out.println("<changefreq>Weekly</changefreq>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getValue(String tag, Element element) {
        try {
            NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
            Node node = nodes.item(0);
            return node.getNodeValue();
        } catch (DOMException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, StandardCharsets.UTF_8)));
    }

}