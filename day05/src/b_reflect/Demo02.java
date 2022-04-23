package b_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
获取构造方法的方法:
 	Constructor<?>[] getConstructors()	 	返回所有公共构造方法对象的数组
 	Constructor<?>[] getDeclaredConstructors()	 	返回所有构造方法对象的数组
 	Constructor getConstructor(Class<?>... parameterTypes)	 	返回单个公共构造方法对象
 	Constructor getDeclaredConstructor(Class<?>... parameterTypes)	 	返回单个构造方法对象

使用反射可以操作的内容又 (成员方法, 成员变量, 构造方法)

反射使用的步骤:
    1.获取该类的字节码对象
    2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
    3.创建一个该类的实例
    4.操作该指定的实例完成需求

 */


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        // 需求: 获取Student中的构造方法,创建该类的对象
        // Student s1 = new Student("小明", 18);
        // 通过反射获取全参构造
        // 1.获取该类的字节码对象
        /*Class<?> class1 = Class.forName("b_reflect.Student");
        // 2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
        Constructor<?> con = class1.getConstructor(String.class, int.class);
        // 3.创建一个该类的实例  使用字节码对象创建创建实例的方法newinstance()
        Object s = con.newInstance("小芳", 19);
        // 4.操作该指定的实例完成需求
        System.out.println(s.getClass().toString());
        // 如果我们想要使用对象中的方法还需要对其进行向下转型
//         Student s1 = (Student) s;
//         s1.eat();*/

        // 通过反射获取私有的构造方法
        // 1.获取该类的字节码对象
        Class<?> class1 = Class.forName("b_reflect.Student");
        // 2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
        Constructor<?> decon = class1.getDeclaredConstructor(String.class);
        // 私有构造方法使用时会报错,因为系统不建议你使用析构构造
        // b_reflect.Demo02 can not access a member of class cn.itcast.demo02_reflect.Student with modifiers "private"
        // 如果想使用你私有构造,必须进行暴力反射,   私有属性和方法也是一样
        decon.setAccessible(true);
        // 3.创建一个该类的实例
        Student s = (Student) decon.newInstance("小红");
        // 4.操作该指定的实例完成需求
        System.out.println(s.getName());

        // 如果我们使用功能的是公共的空参构造, 则可以简化代码, 无序获取构造方法,直接使用字节码对象即可进行实例化
        //1.获取字节码对象
//        Class<?> class1 = Class.forName("b_reflect.Student");
//        //2.使用空参构造实例化对象
//        Student s = (Student) class1.newInstance();
//        //3.使用实例
//        System.out.println(s);

        //如果我们不知道构造方法的参数类型,也不知道有哪些构造方法,我们可以通过方法进行查询getConstructors,getDeclaredConstructor
        // 1.获取字节码对象
//        Class<?> class1 = Class.forName("b_reflect.Student");
//        // 2.获取全部的构造方法列表
//        Constructor<?>[] decons = class1.getDeclaredConstructors();
//        // 3.遍历打印
//        for (Constructor<?> decon : decons) {
//            System.out.println(decon);
//        }


    }
}
