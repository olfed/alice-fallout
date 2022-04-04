package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);
        Scanner in  = new Scanner(System.in);
        System.out.println("Введите сообщение для Алисы...");
        String input = in.nextLine();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(input);
        printWriter.flush();

        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        String str = bufferedReader.readLine();
        System.out.println("server - " + str);
        if (str.equals("Я не поняла о чём вы. Скажите пожалуйста, к какой категории относится ваше предложение? (sad, happy или другое)")){
            input = in.nextLine();
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(input);
            printWriter.flush();
        }
    }
}