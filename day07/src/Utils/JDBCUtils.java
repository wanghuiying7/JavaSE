package Utils;

import java.sql.*;

/*
自定义工具类的特点:
    1.构造方法私有化
    2.所有的方法都是静态方法
    3.所有的字符或者数字尽量统一管理,制作成全局变量
 */


public class JDBCUtils {
    //1. 构造方法私有化.
    private JDBCUtils() {
    }

    //2. 定义成员变量, 记录数据库连接的一些值.
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String pasword = "123456";

    //通过对之JDBC增删改查代码的分析得知,注册驱动, 获取连接对象,和释放资源都是一样的,所以我们可以直接封装到工具类中
    //3. 注册驱动
    static {    //静态代码块, 随着类的加载而加载
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //4. 提供方法, 获取连接对象.
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, pasword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //如果有问题, 就返回null
        return null;
    }

    //5. 提供方法, 释放资源.
    public static void release(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;   //GC会优先回收null对象.
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn = null;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
