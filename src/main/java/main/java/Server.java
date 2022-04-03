package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {
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

            Random random = new Random();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(split[(int) (Math.random() * split.length)]);
            printWriter.flush();

            socket.close();
        }
    }
}
