package g_class;

public class D_Student {
    // 1 设置私有的属性
    private int id; // 学号
    private String name; // 姓名
    private int age; // 年龄

    // 2 为了实例化类的对象 准备构造方法
    // 2.1 无参数的构造
    public D_Student(){

    }

    // 2.2 有参数的构造
    public D_Student(int id,String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 3 因为属性是私有的, 在外部没法修改, 所以提供 属性的get/set方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    // 4 自定义扩展的一些功能方法: 除 get/set以外的方法
    public void sing(){
        System.out.println("音乐");
    }

    // 5 为了方便查看对象的属性值, 一般覆写toString方法

    @Override
    public String toString() {
        return "D_Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
