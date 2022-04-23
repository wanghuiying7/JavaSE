package c_upload;

/*
    上传文件, 服务器端.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器端的Socket对象, 指定端口号.
        ServerSocket server = new ServerSocket(10010);
        //2. 监听连接.
        Socket accept = server.accept();
        //3. 创建输入流, 读取客户端写过来的数据.
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        //4. 创建输出流, 关联目的地文件.
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day06/upload/传智.txt"));
        //5. 正常的IO流代码.
        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //6.释放资源.
        accept.close();


    }
}
