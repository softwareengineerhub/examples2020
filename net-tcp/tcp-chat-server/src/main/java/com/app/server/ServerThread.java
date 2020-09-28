package com.app.server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
    private ServerSocket serverSocket;

    public ServerThread() {
        try {
            serverSocket = new ServerSocket(8082);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                MySession mySession = new MySession(socket);
                SessionManager.getInstance().addSession(mySession);
                mySession.start();
                System.out.println("new session was created");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
