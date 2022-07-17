package com.huawei.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {

        // 发送socket
        DatagramSocket socket  = new DatagramSocket();

        byte[] buffer = new String("我是一只小跳蛙").getBytes();

        // 数据包对象
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);

        socket.send(packet);

        socket.close();


    }
}
