package a_io;

/*
 反序列化操作:
        概述:
            指的是从文件中读取对象, 用的是 ObjectInputStream.
        成员方法:
            public Object readObject();   读取对象.
            public void close();   释放资源.
        需求: 序列化学生对象到文件中.

        注意：如果一个类的对象想实现反序列化操作，类必须实现Serializale接口
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1. 创建反序列化流, 关联数据源文件.
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Day06/data/Student.txt"));
        //2. 反序列化动作.
        Object obj = ois.readObject();
        Student s = (Student) obj;
        //3. 打印对象.
        System.out.println(s);
        //4. 释放资源.
        ois.close();



    }
}
