package com.itheima.jdbc;

public class JdbcDemo {
    public static void main(String[] args) {
        // JDBC 规范
        // DriverManager 驱动管理类
        // 1. 注册驱动
        // 2. 创建连接
        // Connection 接口 链接对象
        // 1.创建操作sql的对象
        // 2. 事务管理
        // Statement 接口
        // 1.将静态sql发送给数据库
        // PreparedStatement 接口
        // 1.预编译sql, 将配置了参数的sql发送给数据库执行
        // ResultSet 结果集对象
        // 封装结果集
        // JDBC使用
        // mysql驱动 -- 数据库厂商提供操作数据库api
        // 连接池 c3p0 -- 就是封装了链接对象的池子(容器)
    }
}
