package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/*
自定义工具类的特点:
    1.构造方法私有化
    2.所有的方法都是静态方法
    3.所有的字符或者数字尽量统一管理,制作成全局变量
 */
public class C3P0Utils {
    //1.构造方法私有化
    private C3P0Utils() {
    }

    //创建成员变量记录连接池对象
    private  static final DataSource ds = new ComboPooledDataSource();

    //2.注册驱动(c3po配置文件已经帮我们注册好驱动了)

    //3.获取连接池对象(备用)
    public static DataSource getDatasource() {
        return ds;
    }

    //4.提供方法获取连接对象
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //4.释放资源
    public static void release(ResultSet rs, Statement stat, Connection conn) {
        // 一般在开发中不这样用
        // 我们此处按照业务逻辑来分析是为了进行空值判断,例如增删改时不会产生rs,则我们需要判断其为空时不关闭
        try {
            if (rs != null) {
                rs.close();
                rs = null; // 系统会抢先回收值为null的对象
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
