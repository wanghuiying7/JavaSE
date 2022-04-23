package b_transaction;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static  void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            // 1.获取连接对象
            conn = JDBCUtils.getConnection();
            // 2.获取可以执行sql语句的对象
            stat = conn.createStatement();
            // 3.执行sql语句，获取结果集
            String sql1 = "update account set money = money - 1000 where name = 'Jack';";
            String sql2 = "update account set money = money + 1000 where name = 'Rose';";
            // 3.1关闭事务的提交功能（默认是打开的）
            conn.setAutoCommit(false);
            // 3.2执行sql语句
            int line_num1 = stat.executeUpdate(sql1);
            int line_num2 = stat.executeUpdate(sql2);
            if(line_num1+line_num2==2){
                System.out.println("转账成功");
                conn.commit();
            }
        }
        catch (Exception e){
            System.out.println("转账失败");
            try{
                conn.rollback();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }

        }finally{
            JDBCUtils.release(null,stat,conn);
        }
    }
}
