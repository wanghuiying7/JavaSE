package a_io;

/*
    案例: 演示字节高效流的用法.

    字节高效流简介:
        概述:
            字节高效流也叫高效字节流, 字节缓冲流, 缓冲字节流, 指的是: BufferedInputStream, BufferedOutputStream.
        构造方法:
            BufferedInputStream:   字节高效输入流.
                public BufferedInputStream(InputStream is);
            BufferedOutputStream:   字节高效输出流.
                public BufferedOutputStream(OutputStream os);
 */

import java.io.*;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //需求: 把1.txt -> 2.txt文件中.
        // 方式一：使用高效字节流，一次读写一个字节
//        func1();

        // 方式二：字节高效流 一次读写一个字节数组.
        func2();

    }

    private static void func1() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        //分解版
        //创建基本的字节输入流, 关联: 数据源文件, 用于读取文件内容.
        FileInputStream fis = new FileInputStream("Day06/data/1.txt");
        //创建高效的字节输入流, 关联: 基本的字节流, 用来提供 缓冲区的功能.
        BufferedInputStream bis = new BufferedInputStream(fis);

        //2. 创建输出流, 关联: 目的地文件
        //合并版.
        //字节高效输出流=普通的字节输出流  +  文件路径
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Day06/data/2.txt"));

        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;

        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len=bis.read()) != -1){
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(len);
        }
        //6. 释放资源.
        bis.close();
        bos.close();
    }

    private static void func2() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Day06/data/1.txt"));
        //2. 创建输出流, 关联: 目的地文件
        //合并版.
        //字节高效输出流 = 普通的字节输出流  +  文件路径
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Day06/data/3.txt"));
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        byte[] bys = new byte[1024];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len=bis.read(bys))!=-1){
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(bys,0,len);
        }

        //6. 释放资源.
        bis.close();
        bos.close();
    }


}
