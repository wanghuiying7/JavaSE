package cn.itcast.d;

public class Demo10_for_4 {
    public static void main(String[] args) {
        // 细节1: 整数 除以 整数 除不尽的结果 是小数, 还是整数? 在java中是整数
        //int num = 10 / 3;
        //System.out.println(num);

        // 获取十位上的数字: 分解式
        //int num = 345;
        //int result = num / 10;
        //System.out.println(result);
        //
        //int result2 = result % 10;
        //System.out.println(result2);

        /*
        int num = 12345;
        // 获取个位上的数字: 合并式
        int result1 = num / 1 % 10;
        System.out.println(result1);

        // 获取十位上的数字: 合并式
        int result2 = num / 10 % 10;
        System.out.println(result2);

        // 获取百位上的数字: 合并式
        int result3 = num / 100 % 10;
        System.out.println(result3);
        */
        /*
        需求: 获取到所有的水仙花数, 并将结果打印到控制台上.
        todo 需求2: 获取 水仙花的个数
        解释:
            1.水仙花数是一个3位数的整数. [100, 999]
            2.该数字的各个位数立方和相加等于它本身. 获取这个整数的个位 十位 百位
            3.例如: 153就是水仙花数, 153 = 1 * 1 * 1 + 5 * 5 * 5 + 3 * 3 * 3 = 153
         */
        // todo 需求2: 获取 水仙花的个数
        // 声明一个变量 保存个数
        int count = 0;
        // 1 获取三位数
        for (int i = 100; i <= 999; i++) {
            int result1 = i / 1 % 10;
            int result2 = i / 10 % 10;
            int result3 = i / 100 % 10;
            if ((result1 * result1 * result1 + result2 * result2 * result2 + result3 * result3 * result3) == i) {
                count++;
            }
        }

        System.out.println("满足条件的水仙花数：" + count);
    }
}
