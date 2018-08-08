package com.pzhang7.study.network.socket.io.client;

import java.io.*;
import java.net.Socket;

/**
 * Author:zp
 * Date:2017/12/27 0027
 * Description:
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        // 获取输出流
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("afdadfasfsa over");
        pw.flush();
        socket.shutdownOutput();
        // 获取输入流
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("Received : " + info);
        }
        // 关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }
}
