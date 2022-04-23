package b_socket;

/*
    案例: 1. TCP协议之客户端给服务器端发送一句话, 服务器端给出回执信息.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceDemo01 {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器端Socket对象, 指定端口号.
        ServerSocket server = new ServerSocket(12306);
        //2. 监听连接.如果有客户端申请连接，则同意，并产生一个新的socket对象，负责和连接用户交互
        // 如果没有客户端接入，就一直等待
        Socket accept = server.accept();
        //3. 获取输入流, 可以读取客户端写过来的数据.
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

        //4. 对读取到的数据解析数据, 打印.
        // 使用一次读取一个字节数组的形式进行打印
        byte[] bys = new byte[1024];
        int len = bis.read(bys);
        String s = new String(bys, 0, len);
        System.out.println("服务器端接收到" + s);

        //5. 获取输出流, 传递数据给客户端.
        BufferedOutputStream bos = new BufferedOutputStream(accept.getOutputStream());
        bos.write("我很好".getBytes());
        bos.flush();

        //6. 具体写回执信息.

        //7. 释放资源.

        accept.close();
//        server.close();  // 实际开发中, 服务器是不关闭的.


    }
}
