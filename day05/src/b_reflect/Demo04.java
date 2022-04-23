package b_reflect;

import java.lang.reflect.Method;

/*
使用反射操作成员方法的方法
 	Method[] getMethods()	 	返回所有公共成员方法对象的数组，包括继承的
 	Method[] getDeclaredMethods()	 	返回所有成员方法对象的数组，不包括继承的
 	Method getMethod(String name, Class<?>... parameterTypes)	 	返回单个公共成员方法对象
 	Method getDeclaredMethod(String name, Class<?>... parameterTypes)	 	返回单个成员方法对象

反射的使用步骤:
    1.获取该类的字节码对象
    2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
    3.创建一个该类的实例
    4.操作该指定的实例完成需求
 */


public class Demo04 {
    public static void main(String[] args) throws Exception {
        /*//1.获取该类的字节码对象
        Class<?> class1 = Class.forName("b_reflect.Student");
        //2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
        Method eat = class1.getMethod("eat");
        //3.创建一个该类的实例
        Student s = (Student) class1.newInstance();
        //4.操作该指定的实例完成需求
        eat.invoke(s);*/


        //1.获取该类的字节码对象
        Class<?> class1 = Class.forName("b_reflect.Student");
        //2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
        Method study = class1.getDeclaredMethod("study");
        //3.创建一个该类的实例
        Student s = (Student) class1.newInstance();
        //使用私有的成员方法也是需要进行暴力反射的
        study.setAccessible(true);

        //4.操作指定的实例完成需求
        study.invoke(s);

        //注意:使用暴力反射时,  如果你获取的是私有的构造方法,就对私有构造方法独享进行设置,如果你获取的是私有的
        //成员变量,或者私有的成员方法,则对私有成员变量或方法对象进行暴力反射设置.

    }
}
