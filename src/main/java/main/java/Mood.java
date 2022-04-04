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

    public static String getMood (String[] split) throws Exception {

        try {
            File file = new File("src/main/resources/xml/Synonyms.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            NodeList nodeList = doc.getElementsByTagName("*");
            System.out.println("___________________");
            for (int i = 0; i < nodeList.getLength(); i++) {
                for (int j = 0; j < split.length; j++) {
                    if (Objects.equals(nodeList.item(i).getTextContent(), split[j])){
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
