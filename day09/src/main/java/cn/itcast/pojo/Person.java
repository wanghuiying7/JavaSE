package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目的: 使用lombok 插件提供的注解,给该类提供   set方法  get方法  toString方法
 * 编写测试
 *
 * 实现步骤:
 * 1.安装lombok插件,重启idea
 * 2.pom.xml到如lombok的jar包  (如果本地仓库有该jar ,自动提示补全,如果没有?)
 * 3.在Person类上添加一个@Data注解   ( set方法  get方法  toString方法)
 * 4.编写测试类,使用以上提供的方法,打印查看
 */

@Data   //set方法  get方法  toString方法  没有全餐构造
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String sex;

}
