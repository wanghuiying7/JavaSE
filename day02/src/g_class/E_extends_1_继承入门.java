package g_class;

public class E_extends_1_继承入门 {
    public static void main(String[] args) {
        /*
            需求
            1.按照标准格式定义一个人类(Person类), 属性为姓名和年龄.
            2.定义老师类(Teacher), 继承自人类, 并在老师类中定义teach()方法.
            3.定义学生类(Student), 继承自人类, 并在学生类中定义study()方法.
            4.在PersonTest测试类的main方法中, 分别创建老师类和学生类的对象, 并调用各自类中的成员.
         */
        E_teacher t1 = new E_teacher();
        t1.setName("鬼谷子");
        t1.setAge(66);
        System.out.println(t1);

        E_Student s1 = new E_Student();
        s1.setName("孙膑");
        s1.setAge(20);
        System.out.println(s1);

    }
}

// 一个文件中可以出现多个类
// 注意事项: 使用public修饰的类 必须跟当前文件名保持一致, 否则报错

//3.定义学生类(Student), 继承自人类, 并在学生类中定义study()方法.
class E_Student extends E_Person {
    // 自定义方法
    public void study() {
        // this指当前对象
        // super指父类对象
        System.out.println(this.getName() + "正在认真的学习新知识 ... ...");
    }
}



//2.定义老师类(Teacher), 继承自人类, 并在老师类中定义teach()方法.
class E_teacher extends E_Person{

    //// 自定义方法
    public void teach(){
        System.out.println(this.getName()+ "正在授课... ...");
    }
}


//1.按照标准格式定义一个人类(Person类), 属性为姓名和年龄.
class E_Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "E_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
