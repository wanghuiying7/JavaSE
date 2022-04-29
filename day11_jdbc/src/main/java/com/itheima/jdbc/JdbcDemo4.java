package com.itheima.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

public class JdbcDemo4 {
    public static void main(String[] args) throws Exception{
        //java 连接池规范: DataSource 所有的连接池都直接或者间接的去继承了这个接口
        //Connection getConnection() --> 从连接池中获取连接...
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql:///day11?serverTimezone=GMT%2B8");
        cpds.setUser("root");
        cpds.setPassword("123456");
        cpds.setMaxPoolSize(10);
        // 四大参数设置给连接池 --> 连接池可以拿着这些参数创建连接对象
        for (int i = 0; i < 15; i++) {
            Connection conn = cpds.getConnection();
            System.out.println(conn);
            conn.close();

            //从连接池中获取的对象 调用close() 时候 不再是释放而是归还(对close方法进行增强(底层用的是 动态代理))
        }


    }
}
