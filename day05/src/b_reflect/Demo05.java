package b_reflect;

/*
需求: 通过反射运行配置文件中指定类的指定方法

Properties 配置文件 我们在java中有Properties类可以直接读取该文件
Properties 是一个集合类:
    他表示双列集合, 是Hashable的子类, 键值都是字符串类型
    他可以直接读取配置文件中的信息,也可以直接向配置文件中写入信息(*.properties)
 */
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo05 {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件中的信息
        Properties prop = new Properties();

        prop.load(new FileInputStream("Day05/config/myConfig.properties"));
        //2.把读取到的配置文件信息,赋值给变量
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        //打印结果,查看是否读取成功
//        System.out.println("className = " + className);
//        System.out.println("methodName = " + methodName);

        //3.使用反射运行该类的指定方法
        //3.1.获取该类的字节码对象
        Class<?> class1 = Class.forName(className);
        //3.2.获取要操作的成员对象(构造器, 成员变量, 成员方法)
        Method eat = class1.getMethod(methodName);
        //3.3.创建一个该类的实例
        // 如果我们知道要执行那个类的实例,则书写向下转型,如果不知道则不要写
        Object s = class1.newInstance();
        //3.4.操作该指定的实例完成需求
        eat.invoke(s);


    }
}
