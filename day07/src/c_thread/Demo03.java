package c_thread;

public class Demo03 {
    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);

        Thread thread = new Thread(new MyRunnable());

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main..." + i);

        }
    }
}
