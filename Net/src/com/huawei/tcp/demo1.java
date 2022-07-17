package com.huawei.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class demo1 {
    public static void main(String[] args) {

        try {
            System.out.println("客户端启动了");
            /*
            创建Socket管道通信请求服务端链接
            参数1：服务端IP，参数2：服务端端口
             */
            Socket socket = new Socket("127.0.0.1",7777);
            // Socket得到一个输出流发送数据
            OutputStream os = socket.getOutputStream();
            // 包装为高级流
            PrintStream ps = new PrintStream(os);
            ps.println("我是客户端，你的爹");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
