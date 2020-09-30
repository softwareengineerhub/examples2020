package com.app.server;

public class ServerStarter {

    public static void main(String[] args) {
        System.out.println("--------STARTING SERVER-----------------------");
        ServerThread serverThread = new ServerThread();
        serverThread.start();
        System.out.println("--------STARTING SERVER COMPLETED-----------------------");
    }

}
