package cn.itcast.thread_03;

public class ThreadDemo {
    public static void main(String[] args) {
        //public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
        //public static Thread currentThread():返回对当前正在执行的线程对象的引用。
        //                                      在哪个线程中执行 获取到的就是哪一个线程的对象
        PrimeThread t1 = new PrimeThread("海王");
        t1.start();
        // 主线程的名字叫做main，如何证明？
        //线程对象.getName() -> 线程的名字
        //ThreadDemo类与Thread类没有继承关系 不能直接使用getName()方法

        Thread mainThread = Thread.currentThread(); //执行的位置为主线程中
        // 修改主线程默认的名字
        mainThread.setName("小花");
        String name = mainThread.getName();
        // 主线程默认的名字叫做main
        System.out.println("name=" + name);

    }
}
