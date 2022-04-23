package d_JDBC;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
JDBCUtils的使用
 */
public class Demo05 {
    // JDBC 查
    @Test
    public void search() throws Exception{
        //1. 注册驱动.(工具类中已经注册）
        //2. 获取连接对象.
        Connection conn = JDBCUtils.getConnection();
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
        JDBCUtils.release(rs,stat,conn);
    }

    // JDBC 增
    @Test
    public void add() throws Exception{
        //1. 注册驱动.(工具类中已经注册）
        //2. 获取连接对象.
        Connection conn = JDBCUtils.getConnection();
        //3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
        //4. 执行SQL语句, 获取结果集.
        String sql = "insert into users values(null,'小红','8888');";
        int line_num = stat.executeUpdate(sql);
        //5. 操作结果集.
        System.out.println(line_num>0?"添加成功":"添加失败");
        //6. 释放资源.
        JDBCUtils.release(null, stat, conn);

    }
}
