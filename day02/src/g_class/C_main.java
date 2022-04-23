package g_class;

public class C_main {
    public static void main(String[] args) {
        // 1 实例化 phone对象
        //C_phone obj = new C_phone("小米", "小米16", 5999);
        C_phone obj = new C_phone();
        System.out.println(obj.toString());

        // 2 设置属性值
        //obj.brand = "华为";
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
