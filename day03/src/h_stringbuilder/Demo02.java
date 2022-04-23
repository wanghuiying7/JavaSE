package h_stringbuilder;

public class Demo02 {
    public static void main(String[] args) {
        // 为什么学习 StringBuilder?
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(sb.toString());
        System.out.println("耗时 " + (end - start) + " 毫秒"); // 耗时 9 毫秒

    }
}
