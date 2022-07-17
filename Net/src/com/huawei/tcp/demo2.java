package com.huawei.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class demo2 {
    public static void main(String[] args) {
            // 1. 注册端口
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            // 2. 调用accpet方法，完成链接
            Socket socket = serverSocket.accept();
            // 3. 得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            // 4. 字节输入流封装为字符缓冲输入流
            // 字符输入缓冲流只能接收Reader，因此需要转换流把字节流转换为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            if ((msg = br.readLine()) != null) {
                System.out.println(socket.getInetAddress().getAddress() + " " + socket.getPort() + " " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
