package com.itheima.javasort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortDemo {
    public static void main(String[] args) {
        // 集合只能存储引用数据类型 无法存储基本数据类型
        // 如果想要存储基本数据类型 需要使用 对应的包装类
        // ArrayList 存取有序 --> 存进去的顺序与取出来的数据是一致的(有序, 可重复)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(33);
        list.add(22);
        list.add(89);
        // 进行排序
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
