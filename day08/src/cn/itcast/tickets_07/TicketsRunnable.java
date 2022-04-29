package cn.itcast.tickets_07;

public class TicketsRunnable implements Runnable {
    // 四个线程共享这100张票
    private static int tickets = 100;
    // 锁对象 --> 保证在多个线程中对象是惟一的
    // 任意一个对象都可以作为锁对象
    private static final Object lock = new Object();


    @Override
    public void run() {

        while (true) {
            sellTickets();
            if (tickets <= 0){
                break;
            }

        }
    }

    // 普通同步方法
    // 有没有锁对象?? 如果有 锁对象是谁??
    // 普通的同步方法 锁对象是 this
    // this -> 当前对象 --> 能否保证多个线程用的是同一个锁对象??
    // 可以! 在当前这个场景中是唯一的
//    public synchronized void sellTickets() {
//        // 票数大于0 才出售
//        if (tickets > 0) {
//            System.out.println(Thread.currentThread().getName() + ":正在出售第" + tickets + "张票!");
//            tickets--;
//        }
//    }

    //静态的同步代码块
    //1. 静态方法中有没有this??? --> 静态的属性/方法 先于对象存在
    // 没有this 锁对象肯定不是this 那么锁对象是谁??  -> 类对象(当前类的字节码对象) TicketRunnable.class
    // 一个类的字节码对象 只会存在一份
    public static synchronized  void sellTickets() {
        if (tickets > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票！");
            tickets--;
        }
    }
}

