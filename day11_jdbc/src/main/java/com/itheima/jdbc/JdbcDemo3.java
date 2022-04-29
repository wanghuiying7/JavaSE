package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDemo3 {
    public static void main(String[] args) throws Exception{
        //PreparedStatement的使用
        // 1.注册驱动 com.mysql.cj.jdbc.Driver 全限定类名
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.创建连接
        // url : jdbc:mysql://ip地址:端口号/数据库名
        // 前提条件: 连接的是win/mac上mysql ip与端口号可以省略 斜线不要省略
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day11?serverTimezone=GMT%2B8","root","123456");

        // 3.准备sql
        // ? 代表的是占位符 提前占据位置 使用在参数值上
        String sql = "update category set cname = ? where cid = ?";

        // 4.预编译sql
        // 预编译如何理解?? --> 将上面这条sql看做为一个完整的sql语法 -- ?的位置不论你输入什么 都只看作为参数值, 而不是语法的一部分
        // 复用这一条sql 提高效率
        PreparedStatement pstm = conn.prepareStatement(sql);

        // 5.设置参数 setXxx(占位符的位置, 占位符的值)
        // Xxx代表的就是数据类型 设置什么数据就是什么类型
        // 占位符(?)的位置 sql 从左往右 从1开始...
        pstm.setString(1,"体育");
        pstm.setInt(2,1);

        // 6.将预编译之后的sql发送给数据库执行
        // 小细节: 预编译sql的对象 调用执行sql的方法时 里面不要写sql 否则报错
        // 影响的行数
        /*
        mysql> update category set cname = 'jiadian' where cid = 2;
        Query OK, 1 row affected (0.00 sec)
        Rows matched: 1  Changed: 1(影响的行数)  Warnings: 0
         */
        int num = pstm.executeUpdate();
        if(num > 0 )
            System.out.println("执行成功...");
        // 7.处理结果集
        // 8.释放资源
        pstm.close();
        conn.close();
    }
}
