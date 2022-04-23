package cn.itcast.d;

public class Demo07_for_入门 {
    public static void main(String[] args) {
        /*
            目标: 输出 1 ~ 100
            格式:
                for(表达式1; 表达式2; 表达式4) {
                    表达式3 ... ...;
                }
            步骤:
                表达式1
               如果 表达式2 的结果 为 true, 就去执行 表达式3,
               执行表达式4

               如果 表达式2 的结果 为 true, 就去执行 表达式3,
               执行表达式4

               结束的条件: 表达式2的结果为false

         */
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        //1. 通过for循环, 打印1~5之间的数字.
        for (int i2 = 1; i2 <= 5; i2++) {
            System.out.println(i2);
        }
        //2. 通过for循环, 打印5~1之间的数字.
        for (int i3 = 5; i3 >= 1; i3--) {
            System.out.println(i3);
        }

    }
}

