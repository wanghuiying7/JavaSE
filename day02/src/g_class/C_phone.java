package g_class;

public class C_phone {
    // 1 定义属性
    private String brand;
    private String name;
    private int price;

    // 2 定义构造方法
    // 问题: 类的构造方法 可以省略吗? 可以省略
    // 为什么? 注意 如果定义类一个构造也不写, 系统将会给你提供一个无参数的构造方法
    public C_phone(){
        System.out.println("调用无参数的构造方法 ... ...");
    }

    // 问题: C_phone obj = new C_phone(); 一旦写了有参数的构造, 这行代码报错了
    // 为什么? 如果用户自定义了构造方法, 这个时候系统就不会提供构造方法了
    public C_phone(String brand2,String name2, int price2){
        brand = brand2;
        name = name2;
        price = price2;
    }

    // 3 属性的get/set方法

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        // this关键字 指当前对象的引用
        this.brand = brand;
        // brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 4 自定义的方法 功能

    // 5 toString()
    // @Override 覆写, 覆写父类的
    // 如果一个类不指定父类, 默认继承Object类

    @Override
    public String toString() {
        return "C_phone{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
