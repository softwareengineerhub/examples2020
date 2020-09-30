package com.app.server;

import com.app.data.ChatData;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private static volatile SessionManager instance;
    private List<MySession> sessions = new ArrayList();

    private SessionManager() {
    }


    public void addSession(MySession session) {
        sessions.add(session);
    }

    public void remove(MySession session) {
        sessions.remove(session);
    }

    public void sendNotification(MySession mySession, ChatData chatData) {
        try {
            Socket socket = mySession.getSocket();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(chatData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendNotificationToAll(ChatData chatData) {
        for (MySession mySession : sessions) {
            sendNotification(mySession, chatData);
        }
    }


    public static SessionManager getInstance() {
        if (instance == null) {
            synchronized (SessionManager.class) {
                instance = new SessionManager();
            }
        }
        return instance;
    }
}
