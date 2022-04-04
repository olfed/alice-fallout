package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4999);
        while(true){
            Socket socket = serverSocket.accept();

            System.out.println("client connected");

            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStream);

            String str = bufferedReader.readLine();
            System.out.println("client - " + str);
            str = str.replaceAll("\\p{Punct}", "");
            String[] split = str.split(" ");
            String mood = Mood.getMood(split);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(answer(mood));

            printWriter.flush();

            InputStreamReader inputStreamTag = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReaderTag = new BufferedReader(inputStreamTag);

            String newTag= bufferedReaderTag.readLine();
            appendXML.append(newTag,str);

            socket.close();
        }
    }
    public static String answer(String mood){
        Random random = new Random();
        Date date = new Date();
        String[] sadAnswers = {"Не грусти, всё пройдёт", "Всё будет хорошо", "Всем иногда бывает грустно"};
        String[] happyAnswers = {"Я так рада, что у тебя всё здорово!", "У меня тоже всё замечательно", "Да и вообще мы все молодцы"};
        String timeAnswer = date.toString();
        String neutralAnswer = "Я не поняла о чём вы. Скажите пожалуйста, к какой категории относится ваше предложение? (sad, happy или другое)";
        if (mood.equals("sad")){
            return sadAnswers[(int) (Math.random() * sadAnswers.length)];
        }   else if (mood.equals("happy")){
            return happyAnswers [(int) (Math.random() * sadAnswers.length)];
        }   else if(mood.equals("time")){
            return timeAnswer;
        }else return neutralAnswer;
    }
}
