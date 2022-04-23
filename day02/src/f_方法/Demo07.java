package f_方法;


public class Demo07 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println("调用change方法前：" + arr[1]); // 20
        change(arr);
        System.out.println("调用change方法后：" + arr[1]); // 20?  200?
    }

    public static void change(int[] arr) {
        arr[1] = 200;
    }
}