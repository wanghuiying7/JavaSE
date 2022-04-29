package cn.itcast.thread_01;

public class ThreadDemo {
    public static void main(String[] args) {
        //main方法也是一条线程 叫主线程
        //new一个Thread子类对象 就相当于创建了一个线程
        //1.创建一个类继承Thread
        //2.重写Thread的run方法(执行线程任务的方法)
        //3.创建Thread的子类对象
        PrimeThread t1 = new PrimeThread();
        //4.启动线程
        t1.start();

        PrimeThread t2 = new PrimeThread();
        //4.启动线程
        t2.start();

        //如果你看不到交替执行 说明你设置的数字不够大
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程:" + i);
        }


    }
}
