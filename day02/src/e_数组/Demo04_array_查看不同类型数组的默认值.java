package e_数组;

import java.util.Arrays;

public class Demo04_array_查看不同类型数组的默认值 {
    public static void main(String[] args) {
        int[] intArr = new int[3];
        double[] doubleArr = new double[3];
        boolean[] booleanArr = new boolean[3];
        String[] strArrr = new String[3];

        System.out.println(Arrays.toString(intArr)); // [0, 0, 0]
        System.out.println(Arrays.toString(doubleArr)); // [0.0, 0.0, 0.0]
        System.out.println(Arrays.toString(booleanArr)); // [false, false, false]
        System.out.println(Arrays.toString(strArrr)); // [null, null, null]

    }
}
