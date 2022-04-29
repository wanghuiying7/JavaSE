package com.itheima.jdbc;

import java.sql.*;

public class JdbcDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 原生JDBC操作
        // 1.注册驱动
        // 注册驱动 这种方式一般不用...
        // 注册了两次驱动...
        // DriverManager.registerDriver(new Driver());
        //只需要将 Driver 这个类加载一下就可以了
        // 8.x 数据库 版本 驱动 com.mysql.cj.jdbc.Driver
        // 5.x 数据库 版本 驱动 com.mysql.jdbc.Driver
        // 最主要的原因 将驱动的配置由静态的代码变成了字符串 --> 配置文件
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获得连接
        // 链接数据库 url jdbc:mysql: 协议 127.0.0.1 ip地址(数据库所在的机器)3306 默认的端口号 serverTimezone=GMT%2B8 设置时区
        // 账号 user
        // 密码 password
        // 本地的数据库 8.0.16 需要设置时区 异常信息: The server time zone
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/day11?serverTimezone=GMT%2B8", "root", "123456");
        //做一个测试
        System.out.println(conn);
        // 3.准备sql
        String sql = "select * from category";
        // 4.创建执行sql对象
        Statement stat = conn.createStatement();
        // 5.执行sql executeUpdate 执行DML  executeQuery() 执行DQL
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果集对象rs.next() 判断是否又下一条数据
        // cid | cname
        // 1 | 家电   |
        // 2 | 服饰   |
        // 3 | 化妆品 |
        while (rs.next()){
            int cid = rs.getInt("cid");
            String cname = rs.getString(2);
            System.out.println(cid + "---" + cname);
        }
        // 7.释放资源 先开后放 后开先放
        rs.close();
        stat.close();
        conn.close();

    }
}
