package Client;

import ClientThreads.ReadThread;
import ClientThreads.WriteThread;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client{
    public Socket socket;
    public String name;
    public Client() {
        ArrayList<String> settings = getSettings("src/main/resources/settings.txt");
        int port = Integer.parseInt(settings.get(1));
        String host = settings.get(0);
        try {
            this.socket = new Socket(host, port);
        } catch (IOException ignored) {}
            new ReadThread(this.socket, this).start();
            new WriteThread(this.socket, this).start();

    }
    public static ArrayList<String> getSettings(String filename) {
        File file = new File(filename);
        ArrayList<String> settings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            String host = scanner.nextLine();
            String[] hostSplited = host.split(":");
            settings.add(hostSplited[1]);
            String port = scanner.nextLine();
            String[] portSplited = port.split(":");
            settings.add(portSplited[1]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return settings;

    }


}
