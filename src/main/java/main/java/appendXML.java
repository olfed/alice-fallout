package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class appendXML {
    public static void append(String mood, String text) {
        String write = "<" + mood + ">" + text + "</" + mood + ">\n";
        try {
            Files.write(Paths.get("src/main/resources/xml/SynonymsNew.xml"), write.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
