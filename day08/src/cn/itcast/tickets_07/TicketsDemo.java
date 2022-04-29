package cn.itcast.tickets_07;

import cn.itcast.tickets_06.TicketsRunnable;

public class TicketsDemo {
    public static void main(String[] args) {
        TicketsRunnable tr = new TicketsRunnable();

        // 四个窗口售票，四个线程对象
        Thread t1 = new Thread(tr);
        t1.setName("海王");
        t1.start();

        Thread t2 = new Thread(tr);
        t2.setName("凯皇");
        t2.start();

        Thread t3 = new Thread(tr);
        t3.setName("茂哥");
        t3.start();

        Thread t4 = new Thread(tr);
        t4.setName("耀神");
        t4.start();





    }
}
