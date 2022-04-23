package c_thread;

/*方式一：继承Thread类
        1，创建一个类继承Thread类
        2.重写Thread中的run方法
        3.把要执行的代码写入run方法
        4.在测试类中创建线程对象
        5.开启线程
        开启线程使用的是start方法，但是调用run方法不会报错，只是没有多线程效果
        同一个线程不能重复开启，否则会报错*/

public class Demo02 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        // 在主线程中书写一个循环
        for (int i = 0; i < 100; i++) {
            System.out.println("main..." + i);

        }
    }

}
