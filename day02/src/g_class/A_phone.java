package g_class;

public class A_phone {
    // 1 定义属性
    String brand;
    String name;
    int price;

    // 2 定义构造
    public A_phone(){
        System.out.println("调用无参数的构造方法 ... ...");
    }

    // 3 属性的get/set方法
    public void setPrice(int price333) {
        if(price333<=10000){
            price = price333;
        }
    }

    // 4 自定义的方法 功能

    // 5 toString()
    public String toString(){return "品牌: " + brand + ", 型号: " + name + ", 价格: " + price;}

}
