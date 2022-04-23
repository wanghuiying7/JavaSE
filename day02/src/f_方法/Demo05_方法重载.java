package f_方法;

public class Demo05_方法重载 {
    public static void main(String[] args) {
        // 求和
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int e = 50;
        int f = 60;

        int result2 = getAdd(a, b);
        int result3 = getAdd(a, b, c);
        int result4 = getAdd(a, b, c, d);
        int result5 = getAdd(a, b, c, d, e);
        int result6 = getAdd(a, b, c, d, e, f);

        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);


    }

    public static int getAdd(int a, int b, int c, int d, int e, int f) {
        return a + b + c + d + e + f;
    }

    public static int getAdd(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    public static int getAdd(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public static int getAdd(int a, int b, int c) {
        return a + b + c;
    }

    public static int getAdd
            (int a, int b) {
        return a + b;
    }
}
