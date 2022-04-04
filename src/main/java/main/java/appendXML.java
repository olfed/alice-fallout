package main.java;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class appendXML {
    public static void append(String mood, String text) throws TransformerException, FileNotFoundException {
        String write = "<" + mood + ">" + text + "</" + mood + ">\n\n";
        try {
            Files.write(Paths.get("src/main/resources/xml/SynonymsNew.xml"), write.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        //Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //DOMSource source = new DOMSource(document);
        //FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/xml/SynonymsNew.xml");
        //StreamResult result = new StreamResult(fileOutputStream);
        //transformer.transform(source, result);
    }
}
