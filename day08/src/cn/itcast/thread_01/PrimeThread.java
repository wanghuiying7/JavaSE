package cn.itcast.thread_01;

public class PrimeThread extends Thread{
    //1.创建一个类继承Thread
    //2.重写Thread的run方法(执行线程任务的方法)


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程:" + i);

        }
    }
}
