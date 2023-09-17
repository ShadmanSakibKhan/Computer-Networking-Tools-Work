package mid;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ShadmanSakibKhan_1911368042 {
    
public static Socket socket = null;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 8050);
            System.out.println("Connected to Server\n" + "Socket: " + socket.getInetAddress() + "." + socket.getPort() + "\n");
        } catch (IOException e) {
            System.out.println("Connection to network cannot be established \n");
            System.exit(-1);
        }

        BufferedReader in = null;
        PrintWriter out = null;
        Scanner consoleInput = new Scanner(System.in);

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Server: " + in.readLine());
            System.out.print("Client: ");
            out.println(consoleInput.nextLine());

            while (true) {
                System.out.print("Server: ");
                System.out.print(in.readLine());
                System.out.print("Client: your Name_ ");
                int choice = consoleInput.nextInt();
                out.println(choice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                consoleInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


