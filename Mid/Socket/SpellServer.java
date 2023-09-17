package mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SpellServer {

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
        
        // Create Socket
        while (true) {
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

                out.println("Welcome to Hogwarts School of Witchcraft!");
                //out.println("NSU CSE438 LAB Server");
                //System.out.println("Client name: " + in.readLine());

                while (socket.isConnected()) {
                    
                    //System.out.print("Server: ");
                    //out.print(consoleInput.nextLine());
                    //System.out.print("Client: ");
                    //System.out.print(in.readLine());
                    
                    int choice = Integer.parseInt(in.readLine());

                    switch (choice) {
                        case 1:
                            out.println("Create light");
                            break;
                        case 2:
                            out.println("Levitate objects");
                            break;
                        case 3:
                            out.println("Open Locks");
                            break;
                        default:
                            out.println("Invalid input!!!\n");
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
