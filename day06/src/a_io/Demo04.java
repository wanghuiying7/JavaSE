package a_io;

/*
    字符流拷贝文件的4种方式:
        1. 基本的字符流一次读写一个字符.
        2. 基本的字符流一次读写一个字符数组.
        3. 高效的字符流一次读写一个字符.
        4. 高效的字符流一次读写一个字符数组.
        5. 高效的字符流独有的拷贝方式: 一次读写一行.

        结论：字符流只能拷贝纯文本文件
 */

import java.io.*;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        //拷贝方式1. 基本的字符流一次读写一个字符.
//        method1();

        //拷贝方式2. 基本的字符流一次读写一个字符数组.
//        method2();

        //拷贝方式3. 高效的字符流一次读写一个字符.
//        method3();

        //拷贝方式4. 高效的字符流一次读写一个字符数组.
        method4();

        // 注意：字符流无法拷贝字节型文件（声音、图片、视频、word、ppt、excel等）
        // 字符流如果一次读取一个数组，那么我们要一次读取一个字符数组，不再是字节数组

    }

    private static void method4() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("Day06/data/传智.txt"));
        //2. 创建输出流, 关联: 目的地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day06/data/传智_4.txt"));
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        char[] chs = new char[1024];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len = br.read(chs)) != -1) {
            //5. 将读取到的数据写入到目的地文件中.
            bw.write(chs, 0, len);
        }
        //6. 释放资源.
        br.close();
        bw.close();
    }

    private static void method3() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("Day06/data/传智.txt"));
        //2. 创建输出流, 关联: 目的地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day06/data/传智_3.txt"));
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len = br.read()) != -1) {
            //5. 将读取到的数据写入到目的地文件中.
            bw.write(len);
        }
        //6. 释放资源.
        br.close();
        bw.close();
    }


    private static void method2() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        FileReader fr = new FileReader("Day06/data/传智.txt");
        //2. 创建输出流, 关联: 目的地文件
        FileWriter fw = new FileWriter("Day06/data/传智_2.txt");
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        char[] chs = new char[1024];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len = fr.read(chs)) != -1) {
            System.out.println(new String(chs));
            //5. 将读取到的数据写入到目的地文件中.
            fw.write(chs, 0, len);
        }
        //6. 释放资源.
        fr.close();
        fw.close();
    }

    private static void method1() throws IOException {
        //1. 创建输入流, 关联: 数据源文件.
        FileReader fr = new FileReader("Day06/data/传智.txt");
        //2. 创建输出流, 关联: 目的地文件
        FileWriter fw = new FileWriter("Day06/data/传智_1.txt");
        //3. 定义变量, 记录读取到的内容(字节, 有效字节数, 字符, 有效字符数, 字符串)
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足, 就一直读.
        while ((len = fr.read()) != -1) {
            System.out.println(len);
            //5. 将读取到的数据写入到目的地文件中.
            fw.write(len);
        }
        //6. 释放资源.
        fr.close();
        fw.close();
    }
}
