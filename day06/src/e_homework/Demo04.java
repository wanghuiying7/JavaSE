package e_homework;
/*4. 已知项目下有个a.txt文本文件，里边有两行数据，如下：
        a,c,d,e,g,h
        a,g,b,o,q,r

        需求：
        创建输入流，读取这两行数据，对这些元素进行去重操作，然后将去重后的结果写入到项目下的b.txt文本文件中, 格式如下:
        //可以不是如下的顺序, 但是要一个字符占一行.
        a
        b
        c
        d
        e
        ...*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        //1.定义一个Hashset集合,用来储存数据,并去重
        Set<String> set = new HashSet<>();
        //2.创建一个高效输入流, 一次读取一行数据.
        BufferedReader br = new BufferedReader(new FileReader("Day06/data/a.txt"));

        //3.循环读取数据
        String line;
        while ((line = br.readLine()) != null) {
            //4.读取一行数据后,将数据使用split进行拆分,分隔符为,
            String[] arr = line.split(",");

            //5.把数据添加到集合中
            for (String s : arr) {
                set.add(s);
            }
        }
        //7.创建高效输出流, 写入文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day06/data/b.txt"));
        for (String element : set) {
            bw.write(element);
            //8.每次写入数据后执行newline
            bw.newLine();

        }
        //9. 释放资源.
        br.close();
        bw.close();

    }


}

