package a_内部类;

public class Demo01 {
    public static void main(String[] args) {
        // 此时无法创建一个实例，因此Person是一个接口。
        // 如果我们想要解决这个问题,  我们可以让子类实现接口 或者使用匿名内部类
        // 无论使用子类实现该接口  还是创建匿名内部类,最终得到的都是一个子类对象
        // 匿名内部类实现
        Person p1 = new Person() {
            @Override
            public void eat() {
                System.out.println("猫吃鱼,狗吃肉,奥特曼吃小怪兽");

            }
        };
        // p1 可以直接调用eat方法，eat是成员方法并非静态方法,所以p1 一定是对象,  而Person是接口,不能实例化,所以p1是Person的子类对象

    }
}
