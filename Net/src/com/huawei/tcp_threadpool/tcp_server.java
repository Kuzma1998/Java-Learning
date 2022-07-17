package com.huawei.tcp_threadpool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class tcp_server {
    public static ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {
            System.out.println("服务器启动了");
            ServerSocket serverSocket = new ServerSocket(6666);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "它来了！");

                Runnable task = new ServerReaderRunnable(socket);
                threadPool.execute(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ServerReaderRunnable implements Runnable {
    private Socket socket;

    ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            // 3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();
            // 4、把字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // 5、按照行读取消息
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(socket.getRemoteSocketAddress() + "说了：: " + msg);
            }
        } catch (Exception e) {
            System.out.println(socket.getRemoteSocketAddress() + "下线了！！！");
        }
    }
}



