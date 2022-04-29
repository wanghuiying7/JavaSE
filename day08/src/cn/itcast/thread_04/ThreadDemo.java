package cn.itcast.thread_04;

public class ThreadDemo {
    public static void main(String[] args) {
        //1.创建一个类实现Runnable接口
        //2.实现run方法
        //3.创建Runnable的实现类的对象
        //任务类对象
        PrimeRunnable pr = new PrimeRunnable();
        //public Thread(Runnable target):分配一个带有指定目标新的线程对象。
        //public Thread(Runnable target,String name):分配一个带有指定目标新的线程对象并指定名字。
        //4.将Runnable实现类对象作为参数创建Thread的对象
        Thread t1 = new Thread(pr, "张飞");
        //5.启动线程
        t1.start();

        //再创建一条线程
        Thread t2 = new Thread(pr, "刘备");
        //5.启动线程
        t2.start();
    }
}
