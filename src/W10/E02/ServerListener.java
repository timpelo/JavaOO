package W10.E02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Jani on 5/11/2015.
 */
public class ServerListener implements Runnable{
    BufferedReader in;
    Socket socket;

    public ServerListener(Socket socket) {
        this.socket = socket;

        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        (new Thread(this)).start();
    }

    @Override
    public void run() {

        while(true) {

            try {
                Thread.sleep(1000);
                String message;
                if((message = in.readLine()) != null) {
                    System.out.println(message);
                }

            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }


        }
    }
}
