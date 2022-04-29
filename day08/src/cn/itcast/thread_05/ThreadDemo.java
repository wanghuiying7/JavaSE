package cn.itcast.thread_05;

public class ThreadDemo {
    public static void main(String[] args) {
        // 继承
        // 1.创建类继承Thread
        // 2.重写run方法
        // 3.创建线程子类对象
        // 4.使用线程对象调用start 启动线程
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + "---" + i);
                }
            }
        }.start();

        // 实现
        // 1.创建类实现Runnable
        // 2.重写run方法
        // 3.创建实现类对象
        // 4.将实现类对象作为参数创建线程对象
        // 5.启动线程
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }

            }
        };

        new Thread(target).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
            }

        }).start();


    }
}
