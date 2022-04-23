package e_interface_重点;

public class Demo01 {

}

// 定义了一个接口
interface A_animal {
    void eat();

    void shout();

    void run();
}

// 类和接口之间是实现关系: 使用关键字 implements
class Dog implements A_animal {
    @Override
    public void shout() {

    }

    @Override
    public void run() {

    }

    @Override
    public void eat() {

    }
}

// 如果是普通类, 则必须重写父接口中所有的抽象方法.
// 如果是抽象类, 则可以不用重写父接口中的抽象方法.
