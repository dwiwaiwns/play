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
 * Description: 2.非阻塞tcp server
 */
public class TcpUnBlockAcceptServer {

    private static Object xWait = new Object();

    public static void main(String[] args) throws InterruptedException {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
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

                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                int sourcePort = socket.getPort();
                int maxLength = 2048;
                byte[] contextBytes = new byte[maxLength];
                int realLength;
                StringBuffer message = new StringBuffer();
                while ((realLength = is.read(contextBytes, 0, maxLength)) != -1) {
                    message.append(new String(contextBytes, 0, realLength));
                    if (message.indexOf("over") != -1) {
                        break;
                    }
                }
                System.out.println("服务器收到来自于端口：" + sourcePort + "的信息：" + message);
                //下面开始发送信息
                os.write("回发响应信息！".getBytes());
                //关闭
                os.close();
                is.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
