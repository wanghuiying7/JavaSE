package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CP30Utils {
    //创建一个C3P0的连接池对象（使用c3p0-config.xml中default-config标签中对应的参数）
    public static DataSource ds = new ComboPooledDataSource();

    //从池中获得一个连接
    public static Connection getConnection() throws SQLException, SQLException {
        return ds.getConnection();
    }

    //释放资源
    public static void closeAll(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            rs = null;
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            stat = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conn = null;
        }
    }
}

