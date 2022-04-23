package g_class;

public class B_phone {
    // 1 定义属性
    private String brand;
    private String name;
    private int price;

    // 2 定义构造构造
    public B_phone(){
        System.out.println("\"调用无参数的构造方法 ... ...\"");
    }

    // 3 属性的get/set方法


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    @Override
    public String toString() {
        return "B_phone{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
