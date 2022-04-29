package cn.itcast.thread_10;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();

        tp1.setName("高铁");
        tp2.setName("飞机");
        tp3.setName("汽车");
        // 默认的线程级别
        //public final int getPriority()：返回此线程的优先级
        System.out.println(tp1.getPriority());//5
        System.out.println(tp2.getPriority());//5
        System.out.println(tp3.getPriority());//5
        // 小科普:线程的优先级从1 - 10依次变高
        // 常用的优先级为1 最低优先级 5 普通优先级 10 最高优先级
        // 为了提高代码的阅读性, Thread提供了三个常量分别表示这个三个数字
        System.out.println(Thread.MAX_PRIORITY); //10
        System.out.println(Thread.MIN_PRIORITY); //1
        System.out.println(Thread.NORM_PRIORITY); //5

        //我们设置优先级的时候 可以通过这个三个数字进行设置
        tp1.setPriority(Thread.NORM_PRIORITY);
        tp2.setPriority(Thread.MAX_PRIORITY);
        tp3.setPriority(Thread.MIN_PRIORITY);

        tp1.start();//5 高铁
        tp2.start();//10 飞机
        tp3.start();//1 汽车
    }
}
