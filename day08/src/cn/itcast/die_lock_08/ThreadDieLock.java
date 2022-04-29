package cn.itcast.die_lock_08;

public class ThreadDieLock {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();

    public static void main(String[] args) {
        new Thread () {
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println("持有A锁，等待B锁...");
                    synchronized (lockB){
                        System.out.println("持有A锁，持有B锁...释放A锁，B锁");
                    }
                }
            }
        }.start();

        new Thread () {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println("持有B锁，等待A锁...");
                    synchronized (lockA){
                        System.out.println("持有B锁，持有A锁...释放B锁，A锁");
                    }
                }
            }
        }.start();

        //持有B锁，等待A锁...
        //持有A锁，等待B锁...
    }
}
