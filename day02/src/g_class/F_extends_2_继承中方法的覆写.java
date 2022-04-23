package g_class;

public class F_extends_2_继承中方法的覆写 {
    public static void main(String[] args) {
        F_Japanese japanese = new F_Japanese();
        japanese.sayHi();

        F_Korean korean = new F_Korean();
        korean.sayHi();

        F_Chinese chinese = new F_Chinese();
        chinese.sayHi();

    }
}

// 父类
class F_Person {
    public void sayHi() {
        System.out.println("hello");
    }
}

// 子类1
class F_Japanese extends F_Person {
    public void sayHi2() {
        System.out.println("亚麻得...");
    }

    @Override
    public void sayHi() {
        System.out.println("亚麻得 ... ...");
    }
}

// 子类2
class F_Korean extends F_Person {
    @Override
    public void sayHi() {
        System.out.println("欧巴, 泡菜思密达 ... ...");
    }
}
// 子类3
class F_Chinese extends F_Person {
    @Override
    public void sayHi() {
        System.out.println("吃了吗... ...");
    }
}