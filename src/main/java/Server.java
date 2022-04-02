package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4999);
        Socket socket = serverSocket.accept();

        System.out.println("client connected");

        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        String str = bufferedReader.readLine();
        System.out.println("client - " + str);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("yes");
        printWriter.flush();
    }
}