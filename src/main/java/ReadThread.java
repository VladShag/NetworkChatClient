import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ReadThread.class.getName());
    private BufferedReader in;
    private Client client;
    private Socket socket;
    public ReadThread(Socket socket, Client client) {
        this.client = client;
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {

        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                String incomeMsg = in.readLine();
                System.out.println("\n" + incomeMsg);
                logger.info("New message accepted: {}", incomeMsg);
            } catch (IOException e) {

            }
        }
    }

}
