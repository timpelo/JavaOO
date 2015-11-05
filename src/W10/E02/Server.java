package W10.E02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jani on 4/11/2015.
 */

public class Server {

    public static void main(String[] args) {

        final int SERVERPORT = 5091;
        List<ServerClient> clientList = new ArrayList<>();

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(SERVERPORT);
            searchClients(clientList, serverSocket);

            closeConnections(serverSocket, clientSocket, out, in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnections(ServerSocket server, Socket client, PrintWriter out, BufferedReader in) {

        try {

            if(server != null) {
                server.close();
            }

            if(out != null) {
                out.close();
            }

            if(in != null) {
                in.close();
            }

            if(client != null) {
                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchClients (List<ServerClient> clientList, ServerSocket serverSocket) {
        Thread t1 = new Thread();
        t1.start();

        while (true) {

            try{
                Thread.sleep(1000);
                ServerClient client = new ServerClient(serverSocket.accept(), clientList);
                clientList.add(client);
                System.out.println("Client found!");
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}


