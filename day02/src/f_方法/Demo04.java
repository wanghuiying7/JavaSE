package f_方法;

import java.util.Arrays;

public class Demo04 {
    public static void main(String[] args) {
       /*
            1.定义方法, 接收两个int类型的整数.
            2.分别获取这两个整数的加减乘除的运算结果, 然后返回.
            3.在main方法中调用该方法, 并打印结果.
         */

        int a = 30;
        int b = 10;

        int[] arr = getResults(a, b);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getResults(int a, int b) {
        int[] arr = {a + b, a - b, a * b, a / b};
        return arr;
    }
}
