package com.app.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientApp {

    public static void main(String[] args) throws Exception {
        int port = 8083;
        String host = "127.0.0.1";

        //DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(host));

        //DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, port);


        DatagramSocket socket = new DatagramSocket();



        //byte[] buffer = new byte[512];
        String message = "Hello123";
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), port);


        socket.send(packet);
        System.out.println("Data was sent to server");


    }

}
