package a_dbcp;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection conn = cpds.getConnection();
        Statement stat = conn.createStatement();
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }
        // 4.释放资源
        conn.close();
        stat.close();
        rs.close();


    }
}
