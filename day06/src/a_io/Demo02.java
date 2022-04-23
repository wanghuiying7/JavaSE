package a_io;

import java.io.*;

/*
    案例: 测试拷贝文件的几种方式的效率对比.
 */

public class Demo02 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        // 拷贝方式1. 基本字节流一次读写一个字节.
//        method1(); //此任务执行时间为179698毫秒

        // 拷贝方式2. 基本字节流一次读写一个字节数组.
        method2(); //此任务执行时间为238毫秒
        // 改成8192后，此任务执行时间为52毫秒

        // 拷贝方式3. 高效的字节流一次读写一个字节.
//        method3(); //此任务执行时间为1025毫秒

        // 拷贝方式4. 高效的字节流一次读写一个字符数组.
//        method4(); //此任务执行时间为53毫秒
//         改成8192后，此任务执行时间为58毫秒

        long end = System.currentTimeMillis();
        System.out.println("此任务执行时间为"+(end-start)+"毫秒");


    }

    private static void method4() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Day06/data/copy.mp4"));
        //2. 创建输出流, 关联: 目的地文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Day06/data/copy1.mp4"));

        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        byte[] bys = new byte[8192];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len=bis.read(bys))!=-1){
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(bys,0,len);
        }
        //6. 释放资源.
        bis.close();
        bos.close();
    }

    public static void method3() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Day06/data/copy.mp4"));
        //2. 创建输出流, 关联: 目的地文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Day06/data/copy1.mp4"));

        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len=bis.read())!=-1){
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(len);
        }
        //6. 释放资源.
        bis.close();
        bos.close();
    }

    public static void method2() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        FileInputStream fis = new FileInputStream("Day06/data/copy.mp4");
        //2. 创建输出流, 关联: 目的地文件
        FileOutputStream fos = new FileOutputStream("Day06/data/copy1.mp4");
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        byte[] bys = new byte[1024];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len=fis.read(bys))!=-1){
            //5. 将读取到的数据写入到目的地文件中.
            fos.write(bys,0,len);
        }
        //6. 释放资源.
        fis.close();
        fos.close();
    }

    public static void method1() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        FileInputStream fis = new FileInputStream("Day06/data/copy.mp4");
        //2. 创建输出流, 关联: 目的地文件
        FileOutputStream fos = new FileOutputStream("Day06/data/copy1.mp4");
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len=fis.read())!=-1){
            //5. 将读取到的数据写入到目的地文件中.
            fos.write(len);
        }
        //6. 释放资源.
        fis.close();
        fos.close();
    }


}
