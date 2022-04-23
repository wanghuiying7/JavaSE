package c_thread;

/*
方式二: 实现Runnable接口
            1.创建一个类,实现Runnable接口
            2.实现Runnable中的run() 方法
            3.把要执行的代码放入run()方法中
            4.在测试类中创建Thread对象,并将该类的对象作为参数传递到Thread类中,构造线程对象
            5.开启线程
                开启线程使用的是start方法,但是调用run方法不会报错,只是没有多线程效果
                同一个线程不能重复开启,否则会报错
 */

public class Demo03 {
    public static void main(String[] args) {
        //4.在测试类中创建Thread对象,并将该类的对象作为参数传递到Thread类中,构造线程对象
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);

        //合并书写
        Thread thread = new Thread(new MyRunnable());

        //5.开启线程
        thread.start();

        // 在主线程中书写循环
        for (int i = 0; i < 100; i++) {
            System.out.println("main..." + i);

        }
    }
}
