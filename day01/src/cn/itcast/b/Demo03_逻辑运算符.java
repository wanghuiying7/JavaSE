package cn.itcast.b;

public class Demo03_逻辑运算符 {
    public static void main(String[] args) {
        // 逻辑运算符
        // 注意: 逻辑运算符两边必须是boolean类型的值
        System.out.println(true && true);
        System.out.println(true && (3 > 2));
        System.out.println(false || (3 < 2));

        int a = 2, b = 5;
        //System.out.println((a++ > 2) & (b++ < 7)); //false
        //逻辑与(&):两个表达式都会执行
        //a++ 在这里是先判断在赋值，2不大于2，左边表达式为false，再赋值，a的值变成3
        //b++ 先判断5小于7，右边表达式为true，再赋值，b=6
        //System.out.println(a);
        //System.out.println(b);

        System.out.println((a++ > 2) && (b++ < 7)); //FALSE
        //短路与(&&):左边表达式结果为false, 右边不执行
        //a++ 在这里是先判断在赋值，2不大于2，左边表达式为false，再赋值，a的值变成3
        //左边表达式结果为false, 右边不执行,b还是5
        System.out.println(a); //a=3
        System.out.println(b); //b=5

        // 判断 如果(!(xxx)), 执行1; 否则 执行2;
        System.out.println(!true);
        System.out.println(!(5>6));


    }
}
