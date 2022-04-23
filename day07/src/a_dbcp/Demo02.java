package a_dbcp;

/*
数据库连接池:
    概述: 实际开发中,当我们需要使用大量的声明周期比较短暂的连接对象的时候,每次频繁的创建和销毁这些对象是非常消耗资源的,
    所以针对于这种情况,我们可以设置一个连接池,预先在内部存放一些连接对象,当需要使用的时候,优先从连接池中拿,使用完毕后
    再放回连接池中,这个池子,就叫做数据库连接池(DBCP)
    连接池好处: 节约资源,提高效率

    分类:
        DBCP:属于Apache基金会,目前使用的不多, 不能自动回收空闲连接池
        C3P0:属于Apache基金会, 可以自动回收空闲的连接池,可以设置最大空闲时间
                Java框架中,底层只要涉及到数据库的相关操作,使用了连接池,那默认就是C3P0
        Druid: 属于阿里巴巴, 中文名称叫做德鲁伊, 采用的是分布式事务的方式实现的, 能够更好的兼容分布式集群(以后可能会用到)

    使用步骤:
        0.准备工作:
            将jar包导入工程,lib文件中,并使用功能as library 配置到运行变量中
            将c3p0的配置文件写入src目录下,并修改配置信息
        1.创建你数据库连连接池对象,它会自动去src目录下读取配置信息
        2.从数据库连接池中获取连接对象
        3.和之前的sql执行步骤一致(获取可执行的stat对象, 执行sql语句,获取结果集...)
        4.释放资源
            如果连接对象,是我们自己床架你的conn.close()  就是销毁
            如果是从连接池对象中获取的连接,使用conn.close就是回收.
 */

import Utils.CP30Utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        Connection conn = cpds.getConnection();
        Connection conn = CP30Utils.getConnection();
        Statement stat = conn.createStatement();
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }
        // 4.释放资源
//        conn.close();
//        stat.close();
//        rs.close();
        CP30Utils.closeAll(rs, stat, conn);


    }
}

