package cn.itcast.thread_02;

public class ThreadDemo {
    public static void main(String[] args) {
        //常用的API
        //Thread(String name) 创建线程对象的时候 我们可以传递一个线程的名称
        //String getName()  返回该线程的名称。
        //void setName(String name) 改变线程名称，使之与参数 name 相同。
        PrimeThread t1 = new PrimeThread();
        //线程默认的名字 Thread-0 - Thread-n
        t1.setName("刘备");

        String name = t1.getName();
        System.out.println(name);
        t1.start();

        // 如何命名?? 使用构造方法给线程命名
        PrimeThread t2 = new PrimeThread("张飞");
        System.out.println(t2.getName());
        t2.start();


    }

}
