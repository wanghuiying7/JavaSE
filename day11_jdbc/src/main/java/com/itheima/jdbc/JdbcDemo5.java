package com.itheima.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDemo5 {
    public static void main(String[] args) throws SQLException {
        //c3p0-config.xml 配置文件只能叫这个名字
        //当我们创建连接池对象的时候 --> 会自动去resources(maven)/src(普通java项目)下找c3p0-config.xml文件
        //读取 默认配置 的信息 default-config
        //ComboPooledDataSource("webdb") --> 我们也可以指定去找哪一个配置 命名配置(webdb)
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection conn = cpds.getConnection();
        System.out.println(conn);
        //剩下的操作 跟之前的一模一样

    }
}
