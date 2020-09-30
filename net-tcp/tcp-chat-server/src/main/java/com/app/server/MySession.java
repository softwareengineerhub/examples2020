package com.app.server;

import com.app.data.ChatData;

import java.io.ObjectInputStream;
import java.net.Socket;

public class MySession extends Thread {
    private Socket socket;

    public MySession(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {

            while (true) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ChatData chatData = (ChatData) in.readObject();
                System.out.println("recieved: "+chatData);
                SessionManager.getInstance().sendNotificationToAll(chatData);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
