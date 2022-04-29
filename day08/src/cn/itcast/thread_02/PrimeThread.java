package cn.itcast.thread_02;

/*
1. 创建一个类 继承Thread
2. 重写run方法

 */

public class PrimeThread extends Thread {
    // 线程的任务代码
    public PrimeThread() {

    }



    public PrimeThread(String name) {
        super(name);
    }



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 如何获取线程的名称
            System.out.println(getName() + "子线程……" + i);
        }
    }
}
