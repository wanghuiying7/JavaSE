package g_class;

public class A_main {
    public static void main(String[] args) {
        // 1 实例化 phone对象
        A_phone obj = new A_phone();
        System.out.println(obj.toString());

        // 2 设置属性值
        obj.brand = "华为";
        obj.name = "荣耀9";
        //obj.price = 199999;

        // 3 调用方法
        obj.setPrice(6666);

        // 4 打印测试
        System.out.println(obj.toString());

    }

}
