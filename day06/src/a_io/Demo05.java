package a_io;

/*
    案例: 演示高效的字符流独有的拷贝方式: 一次读写一行.

    涉及到的成员方法如下:
        BufferedReader:
            public String readLine();    一次读取一行, 结束标记是\r\n, 只要整行内容, 不获取结束标记.
        BufferedWriter:
            public void newLine();       根据当前操作系统, 给出对应的换行符.
            推荐使用newLine进行换行，因为不同操作系统上的换行符不同
            windows上换行是：/r/n
            linux上换行：/n
            mac换行：/r
 */

import java.io.*;

public class Demo05 {
    public static void main(String[] args) throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("Day06/data/传智.txt"));
        //2. 创建输出流, 关联: 目的地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day06/data/传智_5.txt"));
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        String line;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((line= br.readLine())!=null){
            bw.write(line);

            //细节, 必须给出 换行符
            //bw.write("\r\n");
            bw.newLine();
        }
        //6. 释放资源.
        br.close();
        bw.close();




    }
}
