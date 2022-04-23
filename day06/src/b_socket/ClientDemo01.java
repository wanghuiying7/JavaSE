package b_socket;

/*
    案例: 1. TCP协议之客户端给服务器端发送一句话, 服务器端给出回执信息.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo01 {
    public static void main(String[] args) throws IOException {
        //1. 创建客户端的Socket对象, 指定: 服务器端的IP, 端口号.
        Socket socket = new Socket("127.0.0.1", 12306);
        //2. 获取输出流, 可以给服务器端写数据.
        OutputStream os = socket.getOutputStream();
        //将上述的流封装成: 高效流.
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write("你好呀".getBytes());
        // 此处一定要将数据刷过去，否则无法进行数据传输
        bos.flush();

        //3. 创建输入流, 读取服务器传递过来的数据.
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //4. 解析并打印数据.
        byte[] bys = new byte[1024];
        int len = bis.read(bys);
        String s = new String(bys, 0, len);
        System.out.println("客户端接收到："+s);
        //5. 释放资源.

        socket.close();

    }
}
