package c_lambda;

/*
需求:
     有参无返回值抽象方法的练习
     1.定义一个接口 (Flyable),里边定义一个抽象方法, void fly(String s);
     2.定义一个测试类(Demo02),在测试类中提供两个方法
            useFlyable(Flyable f)
            useFlyable(Flyable f , String s)
     3.在主方法中调用这两个方法

省略模式:
    1.可以省略参数的类型
    2.如果只有一个参数的情况下,小括号也可以省略
    3.如果方法体只有一句话,或者知识一个返回值,则可以省略{} 和 return

 */

public class Demo02 {
    public static void main(String[] args) {
        // 方式1: 匿名内部类
        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
            }
        });

        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
            }
        }, "今天天气好晴朗,处处好风光,就是出不去");

        // 方法2: lambda函数
        useFlyable((String s) -> {
            // lambda表达式
            System.out.println(s);
        });

        useFlyable((String s) -> {
            System.out.println(s);
        }, "今天天气真好,适合封在上海");

        // lambda 比匿名内部类要更加简洁,但是他还可以更简洁
        // 省略模式:
        useFlyable(s -> System.out.println(s), "在上海吃的很好住的很好");


    }


    public static void useFlyable(Flyable f) {
        f.fly("今天学习真开心");
    }

    public static void useFlyable(Flyable f, String s) {
        f.fly(s);
    }
}
