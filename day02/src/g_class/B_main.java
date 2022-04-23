package g_class;

public class B_main {
    public static void main(String[] args) {
        // 1 实例化 phone对象
        B_phone obj = new B_phone();
        System.out.println(obj.toString());

        // 2 设置属性值
        //obj.brand = "华为"; //brand 在 g_class.B_phone 中是 private 访问控制
        obj.setBrand("华为");
        //obj.name = "荣耀9";
        obj.setName("荣耀10");
        //obj.price = 199999;

        // 3 调用方法
        obj.setPrice(8888);

        // 4 打印测试
        System.out.println(obj.toString());

    }
}
