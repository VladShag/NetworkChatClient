import java.io.*;
import java.net.Socket;

public class Client{
    public Socket socket;
    private final int PORT = 8080;
    private final String HOST = "localhost";
    public String name;
    public Client() {
        try {
            this.socket = new Socket(HOST, PORT);
        } catch (IOException e) {}
            new ReadThread(this.socket, this).start();
            new WriteThread(this.socket, this).start();

    }


}
