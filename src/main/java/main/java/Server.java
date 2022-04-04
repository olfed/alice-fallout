package main.java;

import org.w3c.dom.Document;
import org.w3c.dom.ls.LSOutput;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4999);

        while(true){
            Socket socket = serverSocket.accept();
            System.out.print("_________________________\n");
            System.out.println("Пользователь подключился");

            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String str;
            try {
                str = bufferedReader.readLine();
            } catch (SocketException exception){
                System.out.println("Пользователь ничего не ввёл");
                continue;
            }
            System.out.println("Клиент: " + str);
            str = str.replaceAll("\\p{Punct}", "").toLowerCase(Locale.ROOT);
            String[] split = str.split(" ");
            String mood = Mood.getMood(split);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(answer(mood));

            printWriter.flush();

            InputStreamReader inputStreamTag = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReaderTag = new BufferedReader(inputStreamTag);
            if (!answer(mood).equals("Я не поняла о чём вы. Скажите пожалуйста, к какой категории относится ваше предложение? " +
                    "(sad, happy или другое)") || answer(mood).equals("wrong")) {
                socket.close();
            } else {
                try {
                    String newTag = bufferedReaderTag.readLine();
                    appendXML.append(newTag, str);
                }catch (SocketException exception){
                    System.out.println("Пользователь ничего не ввёл");
                }
                socket.close();
            }
        }
    }
    public static String answer(String mood){
        Random random = new Random();
        Date date = new Date();
        String[] welcomeAnswers = {"И тебе привет", "Здравствуйте, надеюсь, у вас всё хорошо", "Рада читать вас"};
        String[] sadAnswers = {"Не грусти, всё пройдёт", "Всё будет хорошо", "Всем иногда бывает грустно"};
        String[] happyAnswers = {"Я так рада, что у тебя всё здорово!", "У меня тоже всё замечательно", "Да и вообще мы все молодцы"};
        String timeAnswer = date.toString();
        String neutralAnswer = "Я не поняла о чём вы. Скажите пожалуйста, к какой категории относится ваше предложение? (sad, happy или другое)";
        return switch (mood) {
            case "sad" -> sadAnswers[(int) (Math.random() * sadAnswers.length)];
            case "happy" -> happyAnswers[(int) (Math.random() * happyAnswers.length)];
            case "hello" -> welcomeAnswers[(int) (Math.random() * welcomeAnswers.length)];
            case "time" -> timeAnswer;
            default -> neutralAnswer;
        };
    }
}
