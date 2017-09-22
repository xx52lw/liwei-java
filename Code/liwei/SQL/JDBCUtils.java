package liwei.SQL;
/**
 * 实现JDBC的工具类
 * 定义方法，直接返回数据库的连接对象
 * 写关闭方法
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
    private JDBCUtils() {}
    private static Connection connection;
	private static ResultSet resultSet;
    static {
    	   try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/lwSql";
			url = url + "?allowMultiQueries=true&characterEncoding=utf-8&autoReconnect=true"; 
			String username = "root";
			String pwd = "root";
			connection = DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e + "数据库连接失败");
		}
    	
    }
    // 定义静态方法，返回数据库的连接对象
    public static Connection getConnection() {
		return connection;
	}
    /**
     * 定义关闭方法
     * Connection 连接
     * Statement 状态
     * */
    public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
    /**
     * 定义关闭方法
     * Connection 连接
     * Statement 状态
     * ResultSet 结果集合
     * */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		close(connection, statement);
	}
}
