package d_JDBC;

import org.junit.Test;

import java.sql.*;

public class Demo02 {
    //JDBC的 查
    @Test
    public void method1() throws SQLException, ClassNotFoundException {
        //1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day06?useUnicode=true&characterEncoding=utf8", "root", "123456");
        //3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
        //4. 执行SQL语句, 获取结果集.
        String sql = "select * from users";
        ResultSet rs = stat.executeQuery(sql);
        //5. 操作结果集.
        while (rs.next()){
            System.out.println(rs.getInt("uid")+","+rs.getString("username")+","+rs.getString("password"));
        }
        //6. 释放资源.
        rs.close();
        stat.close();
        conn.close();


    }

    //JDBC的 增
    @Test
    public void method2() throws SQLException, ClassNotFoundException {
        //1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day06?useUnicode=true&characterEncoding=utf8", "root", "123456");
        //3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
        //4. 执行SQL语句, 获取结果集.
        String sql = "INSERT INTO users VALUES (NULL ,'唐老师','tanglaoshi');";
        int num  = stat.executeUpdate(sql);
        //5. 操作结果集.
        System.out.println(num>0 ? "添加成功":"添加失败");
        //6. 释放资源.

        stat.close();
        conn.close();


    }

    //JDBC的 改
    @Test
    public void method3() throws SQLException, ClassNotFoundException {
        //1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day06?useUnicode=true&characterEncoding=utf8", "root", "123456");
        //3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
        //4. 执行SQL语句, 获取结果集.
        String sql = "update users set username = '杨飞' where uid = 4;";
        int num  = stat.executeUpdate(sql);
        //5. 操作结果集.
        System.out.println(num>0 ? "修改成功":"修改失败");
        //6. 释放资源.

        stat.close();
        conn.close();


    }

    //JDBC的 删
    @Test
    public void method4() throws SQLException, ClassNotFoundException {
        //1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day06?useUnicode=true&characterEncoding=utf8", "root", "123456");
        //3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
        //4. 执行SQL语句, 获取结果集.
        String sql = "delete from users where uid = 4;";
        int num  = stat.executeUpdate(sql);
        //5. 操作结果集.
        System.out.println(num>0 ? "删除成功":"删除失败");
        //6. 释放资源.

        stat.close();
        conn.close();


    }

}
