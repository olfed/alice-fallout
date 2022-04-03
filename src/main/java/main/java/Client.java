package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Какая погода будет завтра?");
        printWriter.flush();

        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        String str = bufferedReader.readLine();
        System.out.println("server - " + str);
    }
}