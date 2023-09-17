package exercise01;

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
    private static final int port = 8070;

    public static void main(String[] args) {
        
        //Create IO Objects
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner consolelnput = new Scanner (System.in);
        
        //Start Server
        try{
            
            System.out.println("Server is startsting...");
            server = new ServerSocket(port);
            System.out.println("Server has started");
        
        }catch(IOException e){
        
            System.out.println("Can not listen to port: " + port);
            System.exit(-1);
        
        }
        
        while(true){
            
            //Create Socket
            try{
            
                socket = server.accept();
                System.out.println("Clint has been connected\n");
            
            }catch(IOException e){
                
                System.out.println("Communication Error with Client");
                System.exit(-1);
            
            }
            
            try{
                
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                out.println("NSU CSE338LAB Server");
                System.out.println("Client Name: " + in.readLine());
                
                while(socket.isConneted()){
                    
                    System.out.println("Server: ");
                    out.println(consoleInput.nextLine());
                    System.out.println("Client: ");
                    System.out.println(in.readLine());
                
                }
            
            }catch(IOException e){
                
                System.out.println("Client Left");
                consoleInput.close();
            
            }
            
        }
            
    }
    
}

