package g_class;

public class G_extends_3_继承中的构造方法 {
    public static void main(String[] args) {
        // 目标: 创建子类对象时, 同时创建父类的对象
        // 事实: 只要创建对象, 就一定会调用构造方法
        // 事实2: 只要new子类对象, 就一定会new父类对象, 类似于 要雇佣我必须带上我爹
        // 好处: 代码复用, 功能强大 ... ...
        // 缺点: java的IO继承体系太重了,
        // hadoop创始人发现使用java原生的io传输的数据量太大了(数据本身不大), 但是继承体系太重了
        // Hadoop创始人重新设计了 hadoop中的io
        Son son = new Son();

    }
}

// 爷爷类
class grandpa {
    public grandpa() {
        super();
        System.out.println("调用 爷爷类的构造方法 .... ...");
    }
}

// 父类
class Parent extends grandpa {
    public Parent() {
        super();
        System.out.println("调用 Parent 父类的构造方法 .... ...");
    }
}

// 子类
class Son extends Parent {
    public Son() {
        super(); // 调用父类的构造方法 ... ...
        System.out.println("调用 Son 孙子类的构造方法 .... ...");
    }
}
