package main.java;

import java.io.File;
import java.io.StringReader;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Mood {

    public static String getMood (String[] split) {
        try {
            File file = new File("src/main/resources/xml/Synonyms.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                for (String s : split) {
                    if (nodeList.item(i).getTextContent().equals(s)) {
                        return nodeList.item(i).getNodeName();
                    }
                }
            }

        } catch (Exception exception){
            exception.printStackTrace();
        }
        return "blank";
    }
}
