package com.itheima.javasort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortStuDemo {
    public static void main(String[] args) {

        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("aaa",45));
        stus.add(new Student("ccc",18));
        stus.add(new Student("bbb",45));
        stus.add(new Student("eee",89));
        stus.add(new Student("zzz",188));
        stus.add(new Student("zzz",98));
        stus.add(new Student("zzz",56));
        stus.add(new Student("zzz",89));
        stus.add(new Student("hhh",9887));
        stus.add(new Student("aaa",789));
        stus.add(new Student("aaa",54));
        stus.add(new Student("aaa",9));
        System.out.println(stus);

        // Comparable 比较器
        // Collections.sort(stus); 要求集合内存储的元素必须实现  Comparable 比较器
        // sort 中会自己调用 compareTo 方法 来确定两个对象大小的问题
//        int num = stus.get(0).compareTo(stus.get(1));
//        System.out.println(num);
        Collections.sort(stus);
        System.out.println(stus);

        



    }
}
