package com.app.server;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerApp {

    public static void main(String[] args) throws Exception {
        System.out.println("-----UDP SERVER START-----");
        int port = 8083;
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("---socket created-");

        byte[] buffer = new byte[512];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("---packet created-");

        socket.receive(packet);
        System.out.println("---after received-");

        byte[] packetData = packet.getData();
        System.out.println("received: "+ new String(packetData));

    }
}
