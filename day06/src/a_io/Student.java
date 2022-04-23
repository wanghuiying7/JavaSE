package a_io;

import java.io.Serializable;

public class Student implements Serializable {
    //序列化版本号
    public static final long serialVersionUID = 2L;

    private String name;
    private int age;
    private transient String gender; // 该属性不会参加序列化和反序列化

    public Student() {
    }

    Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void eat(){
        System.out.println("我喜欢吃火锅,但是已经一个月没有吃过了");
    }

    private void study(){
        System.out.println("我喜欢学习,但是现在每天光学习有点无聊");
    }
}
