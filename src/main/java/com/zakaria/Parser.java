package com.zakaria;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

    public Map<String, String> parseConfig(String fileName) {
        Map<String, String> map = new HashMap<>();

        try {
            // 1. Get the XML file
            InputStream is = this.getClass().getResourceAsStream(fileName);

            // 2. Setup the XML parser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();

            // 3. Find all <mapping> tags in the XML
            NodeList nodeList = doc.getElementsByTagName("mapping");

            // 4. Loop through them
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Read the text inside <province> and <action>
                    String province = element.getElementsByTagName("province").item(0).getTextContent();
                    String action = element.getElementsByTagName("action").item(0).getTextContent();

                    // 5. Save them in the HashMap
                    map.put(province, action);
                }
            }

        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }

        return map; // Return the filled map
    }
}
