package liwei.SQL;
/**
 * 编写数据库连接的工具类,JDBC工具类
 * 获取连接对象采用的配置文件方式
 * 读取文件获取连接，执行一次,static{}
 * */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsConfig {
       private static Connection connection;
       private static String driverClass;
       private static String url;
       private static String username;
       private static String pwd;
       static {
    	     try {
		    readConfig();
		    Class.forName(driverClass);
		    connection = DriverManager.getConnection(url, username, pwd);
		 } catch (Exception e) {
				// TODO: handle exception
			 throw new RuntimeException(e + "数据库连接失败");
		 }
    	   
       }
       // 读取配置
       public static void readConfig() throws IOException {
		InputStream inputStream = JDBCUtilsConfig.class.getResourceAsStream("database.properties");
		Properties properties  = new Properties();
		properties.load(inputStream);
		driverClass = properties.getProperty("driverClass");
	    url = properties.getProperty("url");
	    username = properties.getProperty("username");
	    pwd = properties.getProperty("pwd");
	    System.out.println(url);
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
