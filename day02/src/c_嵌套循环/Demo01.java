package c_嵌套循环;

public class Demo01 {
    public static void main(String[] args) {
        // 需求: 输出 2020年 ~ 2025年的月份, 输出格式: yyyy年MM月
        // 1 获取年份
        // 2 获取月份
        /*
        for (int i = 2020; i <=2025 ; i++) {
            System.out.println(i);
        }
        for (int j = 1; j <=12 ; j++) {
            System.out.println(j);
        }

         */
        for (int i = 2020; i <= 2025; i++) {
            for (int j = 1; j <= 12; j++) {
                System.out.println(i + "年" + j + "月");
            }

        }

        // 嵌套循环的特点: 外循环执行一次, 内循环执行一轮
    }
}
