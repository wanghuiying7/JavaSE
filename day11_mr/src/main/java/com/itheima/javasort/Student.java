package com.itheima.javasort;

public class Student implements Comparable<Student>{

    private String name;
    private int age;

    public Student() {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // 当前Student对象 this
    // compareTo 传递进来的对象 stu
    // 比较 两个学生对象谁大谁小
    @Override
    public int compareTo(Student stu) {
        // 假设以年龄进行排序
        // 假设以年龄进行排序
        // num 是正数 说明 当前对象的age 比传递进来的 age要大
        // num 是负数 说明 当前对象的age 比传递进来的 age要小
        //int num = this.getAge() - stu.getAge();
        //倒叙排序
        //int num = stu.getAge() - this.getAge();
        // 按照姓名排序 然后在按照age排序
        // 姓名一样的情况下 再按照 age排序
        // String 也重写了 compareTo 方法 比较谁大谁小的
        // int num = this.getName().compareTo(stu.getName());
        // int num = stu.getName().compareTo(this.getName());

        int num = this.getName().compareTo(stu.getName());
        //name 相同再按照 age排序
        if (num == 0) {
            num = stu.getAge() - this.getAge();
        }
        return num;
    }
}
