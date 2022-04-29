package cn.itcast.tickets_06;

public class TicketsRunnable implements Runnable {
    // 四个线程共享这100张票
    private static int tickets = 100;
    // 锁对象 --> 保证在多个线程中对象是惟一的
    // 任意一个对象都可以作为锁对象
    private static final Object lock = new Object();


    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                if (tickets > 0) {

                    // 睡个10毫秒 主要是为了暴露更多的问题 没有其他作用
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票！");
                    tickets--;
                } else {
                    break;
                }
            }

        }
    }
}
