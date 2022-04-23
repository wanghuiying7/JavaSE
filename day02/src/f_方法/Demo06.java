package f_方法;

public class Demo06 {
    public static void main(String[] args) {
        int number = 100;
        System.out.println("调用change方法前：" + number);

        change(number);     //实参.

        System.out.println("调用change方法后：" + number);  // 100


    }

    public static void change(int number) {
        number = 200;

    }
}
