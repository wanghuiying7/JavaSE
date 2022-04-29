package cn.itcast.thread_03;

/*
1. 创建一个类 继承Thread
2. 重写run方法

 */

public class PrimeThread extends Thread {
    // 线程的任务代码
    public PrimeThread() {

    }



    //调用父类的Thread(String name) 给线程取名字
    public PrimeThread(String name) {
        super(name);
    }



    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 每次执行输出语句之前 让它睡个1s
            // 父类方法没有抛出异常 子类也不能抛
            // ctrl + alt + t

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 如何获取线程的名称
            System.out.println(getName() + "子线程……" + i);
        }
    }
}
