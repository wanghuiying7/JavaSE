package cn.itcast.thread_09;

import java.util.Hashtable;
import java.util.Vector;

public class Demo {
    public static void main(String[] args) {
        // 线程安全的类
        StringBuffer sb = new StringBuffer();
        sb.append(15);
        Vector<String> vector = new Vector();
        vector.add("hah");
        Hashtable<String, String> ht = new Hashtable();
        ht.put("aa","bb");
    }
}
