package a_io;

/*
flush() 和 close()方法的区别是什么?
    答案:
        flush(): 用来刷新缓冲区的, 把缓冲区的数据刷出来, 刷新之后, 流对象还可以继续使用.
        close(): 用来关闭流释放资源的, 关闭之前会自动刷新一次缓冲区, 关闭之后, 流对象不能继续使用.
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Demo06 {
    public static void main(String[] args) throws IOException {

//        FileOutputStream fos = new FileOutputStream("Day06/data/1.txt");
//        fos.write("abc".getBytes());
//
//        fos.flush();
////        fos.close(); //  Stream Closed
//
//        fos.write("bcd".getBytes());
//
////        fos.flush();
//        fos.close();

        // 高效字节流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Day06/data/1.txt"));

        bos.write("abc".getBytes());

        bos.flush();

        bos.write("bcd".getBytes());

        bos.close();



    }
}
