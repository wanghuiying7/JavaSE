package f_方法;

public class Demo03_getMax {
    public static void main(String[] args) {
        //1. 定义数组, 记录元素.
        int[] arr = {5, 15, 2000, 10000, 100, 4000};
        int max = getMax(arr);
        System.out.println("1 最大值是：" + max);

        int[] arr2 = {100, 40, 50, 80, 120, 150};
        int max2 = getMax(arr2);
        System.out.println("2 最大值是：" + max2);

    }

    private static int getMax(int[] arr) {
        int max = 0;
        for (int element : arr) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }
}
