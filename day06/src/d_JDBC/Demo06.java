package d_JDBC;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
使用Prep进行数据库 插入记录 增
*/
public class Demo06 {
    public static void main(String[] args) throws SQLException {
        //1. 注册驱动.
        //2. 获取连接对象.
        Connection conn = JDBCUtils.getConnection();
        //3.书写sql语句并进行预编译获取ps对象
        String sql = "insert into users values(?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        //4.给占位符赋值并执行sql语句.
        ps.setInt(1, 10);
        ps.setString(2, "小杰");
        ps.setString(3, "123123");
        int len_num = ps.executeUpdate();
        //5. 操作结果集.
        System.out.println(len_num > 0 ? "添加成功" : "添加失败");
        //6. 释放资源.
        JDBCUtils.release(null, ps, conn);


    }
}
