package com.huawei.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建接收数据的socket
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[1024 * 64];
        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            // 接收数据
            socket.receive(packet);
            String res = new String(buffer, 0, packet.getLength());// 构造结果
            System.out.println("Ip地址为：" + packet.getSocketAddress().toString() + "端口为：" + packet.getPort() + "输出了：" + res);
        }
    }
}
