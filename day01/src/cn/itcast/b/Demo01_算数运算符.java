package cn.itcast.b;

public class Demo01_算数运算符 {
    public static void main(String[] args) {
        //int num = 10;
        //int num2 = 10;

        //num++;
        //System.out.println(num);

        //++num;
        //System.out.println(num);

        int num = 10;
        int a = num++;
        System.out.println("a=" + a); //a=10，num=11

        int num2 = 10;
        int b = ++num2;
        System.out.println("b=" +b); //b=11,mun=11
    }
}
