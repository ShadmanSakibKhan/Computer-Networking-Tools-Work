package assesment03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    private static ServerSocket server = null;
    private static Socket socket = null;
    private static final int port = 8050;

    public static void main(String[] args) {
        // Create IO Objects
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner consolelnput = new Scanner (System.in);

        // Start Server
        try {
            System.out.println("Server is starting...");
            server = new ServerSocket(port);
            System.out.println("Server has started");
        } catch (IOException e) {
            System.out.println("Can not listen to port: " + port);
            System.exit(-1);
        }

        while (true) {
            // Create Socket
            try {
                socket = server.accept();
                System.out.println("Client has been connected\n");
            } catch (IOException e) {
                System.out.println("Communication Error with client");
                System.exit(-1);
            }

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Welcome to Rock Paper Scissors Game!");
                //out.println("Enter Your Name");

                while (socket.isConnected()) {
                    //out.println("Enter a number: 1: Rock, 2: Paper, 3: Scissors");
                    int choice = Integer.parseInt(in.readLine());

                    switch (choice) {
                        case 1:
                            out.println("Rock");
                            break;
                        case 2:
                            out.println("Paper");
                            break;
                        case 3:
                            out.println("Scissors");
                            break;
                        default:
                            out.println("Invalid input!!! (Please enter a number from 1 to 3)\n");
                            break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Client Left");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
