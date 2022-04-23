package f_方法;

public class Demo02_huigu {
    public static void main(String[] args) {
        // 目标: 遍历数组的内容, 抽取遍历数组的方法
        int[] arr = {11, 22, 33};
        arrForEach(arr);

        int[] arr2 = {44, 55, 66, 77};
        arrForEach(arr2);
    }

    private static void arrForEach(int[] arr) {
        for (int element : arr) {
            System.out.println(element);

        }
    }

}
