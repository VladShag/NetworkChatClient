import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class WriteThread extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(WriteThread.class.getName());
    private Socket socket;
    private Client client;
    private static PrintWriter out;
    private static BufferedReader input;
    public WriteThread(Socket socket, Client client) {
        this.client = client;
        this.socket = socket;
        try {
            OutputStream output = socket.getOutputStream();
            out = new PrintWriter(output, true);
            input = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {}
    }
    @Override
    public void run() {
        String userName = "";
        System.out.println("Welcome, new user! Please enter your name: ");
        try {
            userName = input.readLine();
            client.name = userName;
            out.println(client.name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String text = "";
            while (true){
                text = input.readLine();
                if(text.equals("exit")) {
                    logger.info("{} is disconnected! ", client.name);
                    break;
                } else {
                    logger.info("{} wrote: {}", client.name, text);
                    out.println(client.name + ": " + text);
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                socket.close();
            } catch (IOException e) {}
        }


    }
}
