package a_io;

/*
    序列化操作:
        概述:
            指的是把对象写入到文件中, 用的是 ObjectOutputStream.
        成员方法:
            public void writeObject(Object obj);   把对象序列化到文件中.
            public void close();   释放资源.
        需求: 序列化学生对象到文件中.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo07 {
    public static void main(String[] args) throws IOException {
        //1. 创建对象序列化流, 关联: 目的地文件.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Day06/data/Student.txt"));
        //2. 创建学生对象, 并将其序列化到文件中.
        Student s = new Student("xiaoming");
        //3.讲对象序列化到文件中
        oos.writeObject(s);
        //4. 释放资源.
        oos.close();


    }
}
