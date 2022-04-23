package k_baozhuang;

public class Demo03 {
    public static void main(String[] args) {
        // 需求1: 将整数 转成 包装的整数
        int i = 10;
        Integer i1 = new Integer(i);

        // 整数和包装整数可以直接转化
        int m = i1;

        int m1 = new Integer(20); // 包装直接转成整数，拆箱

        Integer n = 20; // 装箱

        // 需求2: 将字符串转成整数
        String str = "20";

        Integer i2 = new Integer(str);
        int i3 = Integer.parseInt(str);

        // 需求3: 将整数转成字符串
        int i4 = 100;
        String str4 = i4 + "";
        String str5 = new Integer(i4).toString();


    }
}
