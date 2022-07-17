package com.huawei.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        // 发送socket
        DatagramSocket socket = new DatagramSocket();


        while (true) {
            System.out.println("请输入: ");
            String msg = sc.nextLine();
            if (msg.equals("exits")) {
                System.out.println("已经退出");
                socket.close();
                break;
            }
            byte[] buffer = msg.getBytes();

            // 数据包对象
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 8888);

            socket.send(packet);
        }


    }
}
