package e_数组;

public class Demo06_array_数组的遍历 {
    public static void main(String[] args) {
        int[] arr = {11, 33, 55, 77, 99};

        // 方式一
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=============================");
        // 方式一: 快捷键 itar
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
        System.out.println("=============================");

        // 方式二: 快捷键 iter
        for (int element : arr) {
            System.out.println(element);
        }

    }
}
