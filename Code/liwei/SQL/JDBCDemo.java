package liwei.SQL;
import java.awt.List;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import java.sql.ResultSet;

import liwei.SQL.Product;

/**
 * JDBC操作数据库的步骤
 * 1.注册驱动
 *   告知JVM使用的是哪一个数据库驱动
 * 2.获取连接
 *   使用JDBC中的类，完成对MySQL数据库的连接
 * 3.获得语句执行平台
 *   通过连接对象获取对SQL语句的执行者对象
 * 4.执行sql语句
 *   使用执行者对象，向数据库执行SQL语句
 *   获取到数据库的执行后的结果
 * 5.处理结果
 * 6.释放资源 -堆close()
 * */
public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//     function2();
//		function3();
//		function4();
//		function5();
		function6();
	}
	/** 
	 * JDBC读取数据表，每行数据封装到类的对象中 
	 * @throws SQLException 
	 * */
	public static void function6() throws SQLException {
		
		Connection con = JDBCUtilsConfig.getConnection();
		String sql = "select * from product";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		// 创建集合对象
		ArrayList<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product(rs.getInt("id"), rs.getString("pname"), rs.getDouble("price"));
			list.add(product);
		}
		JDBCUtilsConfig.close(con, pst, rs);
		
		// 遍历集合
		for (Product product : list) {
			System.out.println(product);
		}
	}
	
	
	public static void function5() throws SQLException {
		Connection connection  = JDBCUtilsConfig.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select pname from product");
		java.sql.ResultSet rSet =  preparedStatement.executeQuery();
		while (rSet.next()) {
			System.out.println(rSet.getString("pname"));
		}
		JDBCUtilsConfig.close(connection, preparedStatement, rSet);
	}
	public static void function4() throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select pname from product");
		java.sql.ResultSet rSet =  preparedStatement.executeQuery();
		while (rSet.next()) {
			System.out.println(rSet.getString("pname"));
		}
		JDBCUtils.close(connection, preparedStatement, rSet);
	}
	
	public static void function3() throws ClassNotFoundException, SQLException {
		ConnectionSQL connectionSQL = new ConnectionSQL();
		Connection connection = connectionSQL.createSQLConnection();
		String sql = "select * from product";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// 调用pst对象方法执行查询语句
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString("id") +"  "+resultSet.getString("pname") +"  "+ resultSet.getDouble("price"));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	
	public static void function2() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/lwSql";
		url = url + "?allowMultiQueries=true&characterEncoding=utf-8&autoReconnect=true"; 
		String username = "root";
		String pwd = "root";
		Connection connection = DriverManager.getConnection(url, username, pwd);
		// 拼写修改的SQL语句采用？占位
		String sql = "UPDATE product SET pname=?,price=? WHERE id=?";
		// 调用数据库连接对象connection的方法pareStatement获取SQL语句的预编译对象
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setObject(1,"北极");
		pStatement.setObject(2, 21.50);
		pStatement.setObject(3, 2);
		
	   // 执行SQL
		pStatement.executeUpdate();
		pStatement.close();
		connection.close();
	}
	public static void function1() {
		 // 注册驱动，反射技术，将驱动类加入到内容
//		DriverManager.registerDriver(new Driver());
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/lwSql?allowMultiQueries=true&characterEncoding=utf-8&autoReconnect=true";
		String username = "root";
		String password = "root";
		Connection connection;
		try {
			connection = DriverManager.getConnection(url,username,password);
			try {
				Statement statement = connection.createStatement();
			doStatement(statement);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("获得语句执行平台, 通过数据库连接对象,获取到SQL语句的执行者对象- 失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}
	}
   public static void doStatement(Statement statement) throws SQLException {
	   int row = statement.executeUpdate("INSERT INTO product(pname,price) VALUES ('hah说',800)");
		System.out.println(row);
   }
}
