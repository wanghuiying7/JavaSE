package h_stringbuilder;

public class Demo01 {
    public static void main(String[] args) {
        // 为什么学习 StringBuilder?
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += i;
        }
        System.out.println(str);

        long end = System.currentTimeMillis();

        System.out.println("耗时 " + (end - start) + " 毫秒"); // 耗时 18584 毫秒
    }
}
