package a_dbcp;

/*
使用工具类,完成连接池的使用
 */

import Utils.C3P0Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        // 1.创建你数据库连连接池对象,它会自动去src目录下读取配置信息
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
        // 2.从数据库连接池中获取连接对象
//        Connection conn = cpds.getConnection();
        Connection conn = C3P0Utils.getConnection();
        // 3.和之前的sql执行步骤一致(获取可执行的stat对象, 执行sql语句,获取结果集...)
        // 3.1获取stat对象
        Statement stat = conn.createStatement();
        // 3.2 准备sql语句并执行
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
        // 3.3 处理结果集
        while(rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }
        // 4.释放资源
//        conn.close();
//        stat.close();
//        rs.close();
        C3P0Utils.release(rs, stat, conn);


    }
}

