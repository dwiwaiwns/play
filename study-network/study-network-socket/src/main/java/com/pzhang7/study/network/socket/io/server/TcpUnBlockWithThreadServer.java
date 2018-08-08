package com.pzhang7.study.network.socket.io.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Author:zp
 * Date:2017/12/28 0028
 * Description: 4.非阻塞tcp server
 */
public class TcpUnBlockWithThreadServer {

    private static Object xWait = new Object();

    public static void main(String[] args) throws InterruptedException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            serverSocket.setSoTimeout(100);
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (SocketTimeoutException e) {
                    synchronized (xWait) {
                        System.out.println("这次没有从底层接收到任务数据报文，等待10毫秒，模拟事件X的处理时间");
                        xWait.wait(10);
                    }
                    continue;
                }
                //当然业务处理过程可以交给一个线程（这里可以使用线程池）,并且线程的创建是很耗资源的。
                //最终改变不了.accept()只能一个一个接受socket连接的情况
                SocketServerThread socketServerThread = new SocketServerThread(socket);
                new Thread(socketServerThread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

class SocketServerThread implements Runnable {
    private Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            int sourcePort = socket.getPort();
            int maxLength = 2048;
            byte[] contextBytes = new byte[maxLength];
            int realLength;
            StringBuffer message = new StringBuffer();
            // 下面我们收取信息（设置成非阻塞方式，这样read信息的时候，又可以做一些其他事情）
            socket.setSoTimeout(10);
            BIORead:
            while (true) {
                try {
                    while ((realLength = is.read(contextBytes, 0, maxLength)) != -1) {
                        message.append(new String(contextBytes, 0, realLength));
                        if (message.indexOf("over") != -1) {
                            break BIORead;
                        }
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("这次没有从底层接收到任务数据报文，等待10毫秒，模拟事件Y的处理时间");
                    Thread.sleep(10);
                    continue;
                }
            }
            System.out.println("服务器收到来自于端口：" + sourcePort + "的信息：" + message);
            //下面开始发送信息
            os.write("回发响应信息！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭
            try {
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
