package d_内部类;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {
    public static void main(String[] args) {
        // 目标: 对数组内容排序
        // 注意: 以后咱们的基本类型统统使用 包装类型
        Integer[] arr = {100, 20, 50, 45, 30};

        Arrays.sort(arr, new MyComparator());

        System.out.println(Arrays.toString(arr));


    }

    // 内部类 o1 - o2 是正序，o2 - o1 是倒序；
    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
