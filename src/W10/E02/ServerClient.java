package W10.E02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/**
 * Created by Jani on 5/11/2015.
 */
public class ServerClient implements Runnable {
    private Socket socket;
    private List<ServerClient> clientList;
    private PrintWriter out;
    private BufferedReader in;

    public ServerClient(Socket socket, List<ServerClient> clientList) {
        this.socket = socket;
        this.clientList = clientList;

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        (new Thread(this)).start();
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void run() {

        while(true) {
            String inputString;

            try {

                while ((inputString = in.readLine()) != null) {

                    if(inputString.equals("exit")) {
                        System.out.println("User has left!");
                        timeOut(null);
                    }
                    synchronized (this) {
                        for (ServerClient client : clientList) {
                            client.sendMessage(inputString);
                        }
                    }
                }
            } catch (IOException e) {
                timeOut(e);
            }
        }
    }

    public void removeClient(ServerClient client) {
        clientList.remove(client);
    }

    public synchronized void timeOut(IOException e) {

        if (e instanceof SocketException || e == null) {
            System.out.println("Client Disconnected!");

            for (int i = 0; i < clientList.size(); i++) {
                ServerClient client = clientList.get(i);

                if (client != this) {
                    client.removeClient(this);
                }

                finalize();
                clientList.remove(this);
            }
        }
    }

    @Override
    public void finalize() {

        try {

            if(in != null) {
                in.close();
            }

            if(out != null) {
                out.close();
            }

            if(socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
