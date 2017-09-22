package liwei.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
   public Connection createSQLConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/lwSql";
	url = url + "?allowMultiQueries=true&characterEncoding=utf-8&autoReconnect=true"; 
	String username = "root";
	String pwd = "root";
	Connection connection = DriverManager.getConnection(url, username, pwd);
	return connection;
   }
}
