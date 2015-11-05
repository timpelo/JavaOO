package W10.E02;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {
        // Server address
        final String SERVERADDRESS = "localhost";
        // Server port
        final int SERVERPORT = 5091;

        // Socket between client and server
        Socket socket = null;
        // For sending message
        PrintWriter out   = null;

        try {
            // Establish the connection to the server
            socket = new Socket(SERVERADDRESS, SERVERPORT);

            // Get the socket's output stream and set autoflush
            // to true
            out = new PrintWriter(socket.getOutputStream(), true);


        } catch (UnknownHostException e) {
            System.err.println("Can't find host: " + SERVERADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Failed to connect!");
            System.exit(1);
        }

        ServerListener serverListener = new ServerListener(socket);

        // Getting the user input
        Scanner scan = new Scanner(System.in);
        String userInput;

        // Repeat until user gives no longer input
        while ((userInput = scan.nextLine()) != null) {
            // Push the user input to the server
            out.println(userInput);

        }

        // Close all streams
        out.close();
        scan.close();
        socket.close();
    }
}