package b_死循环;

public class Demo01_死循环 {
    public static void main(String[] args) {
        // 方式一：
        for (; true; ) {
            System.out.println("hello world");
        }
    }
}
