package c_upload;

/*
    上传文件, 客户端.
 */

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建客户端Socket对象, 指定: 服务器端IP, 端口号.
        Socket socket = new Socket("127.0.0.1", 10010);
        //2. 获取输出流, 可以往服务器端写数据.
        //高效字符流对象 =  高效字符流对象（转换流（普通字节流对象））
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //3. 创建输入流, 读取数据源信息.
        // 高效字符流 = 高效字符流对象（普通字符流）
        BufferedReader br = new BufferedReader(new FileReader("Day06/data/传智.txt"));
        //4. 具体的文件上传的动作.
        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //5.释放资源.
        socket.close();
    }
}
