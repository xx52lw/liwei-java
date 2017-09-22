package liwei.SQL;
/** 
 * 使用QueryRunner类，实现对数据表的
 * insert delete update
 * 调用QueryRunner类的方法update（Connection con, string sql,Object...）
 * Object..param可变参数，Object类型，SQL语句会出现？占位符
 * 
 * */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class QueryRunnerDemo {
     
	private static Connection con = JDBCUtilsConfig.getConnection();
     
    public static void main(String[] args) throws SQLException {
//		insert();
//		update();
//    	delete();
    	
//    	arrayHander();
//    	arrayListHandler();
//    	beanHandler(); 
//    	beanListHander();
    	
//    	columnListHandler();
//    	scalarHandler();
//    	mapHandle();
    	mapListHandler();
	}
    /**
     * 结果集第八种处理方式，MapListHandler
     * 将结果集每一行存储到map集合
     * Map<键，值> 键：列名 值：这列的数据
     * @throws SQLException 
     * */
    public static void mapListHandler() throws SQLException {
       	QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		List<Map<String, Object>> list = qRunner.query(con, sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			for(String key : map.keySet()) {
				System.out.println(key + ".." + map.get(key));
			}
			System.out.println();
		}
	}
    
    /**
     * 结果集第七种处理方法，mapHandler
     * 将结果集第一行数据，封装到Map结合中
     * Map<键，值> 键：列名 值：这列的数据
     * @throws SQLException 
     * */
    public static void mapHandle() throws SQLException {
       	QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		Map<String, Object> map = qRunner.query(con, sql, new MapHandler());
		for(String key : map.keySet()) {
			System.out.println(key + ".." + map.get(key));
		}
	}
    
    /**
     * 结果集第六种处理方法ScalarHandler
     * 对于查询后，只有一个结果
     * */
    public static void scalarHandler() throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		String sql = "select COUNT(*) from product";
		long count = qRunner.query(con, sql, new ScalarHandler<Long>());
		System.out.println(count);
	}
    
    /**
     * 结果集合第五种处理方法ColumnListHandler
     * 结果集，指定列的数据，存储到list集合
     * List<Object>每个列数据类型不同
     * @throws SQLException 
     * */
    public static void columnListHandler() throws SQLException {
       	QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		List<Object> list = qRunner.query(con, sql, new ColumnListHandler<>("pname"));
		for (Object object : list) {
			System.out.println(object);
		}
	}
    /**
     * 结果集第四种处理方式，beanListHandler
     * 结果集每一个行数据，封装JavaBean对象
     * 多个JavaBean对象,存储到list集合
     * @throws SQLException 
     * */
    public static void beanListHander() throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		List<Product> list =qRunner.query(con, sql, new BeanListHandler<Product>(Product.class));
		for (Product product : list) {
			System.out.println(product);
			System.out.println(product.getPname());
		}
	}
    /**
     * 结果集的第三种处理方式BeanHandler
     * 将结果集的第一行数据，封装成JavaBean对象
     * 注意：被封装成数据到JavaBean对象，Prouct类必须有空参数构造
     * @throws SQLException 
     * */
    public static void beanHandler() throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		Product product = qRunner.query(con, sql, new BeanHandler<Product>(Product.class));
		System.out.println(product);
	}
    
    /**
     *   结果的第二种处理方式
     *   将结果集的
     *       每一行，
     *   封装到对象数组中，出现很多对象数组
     *   对象数组存储到list集合
     * @throws SQLException 
     * */
    public static void arrayListHandler() throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		List<Object[]> result = qRunner.query(con, sql, new ArrayListHandler());
		for (Object[] objects : result) {
			// 遍历对象数组
			for (Object object : objects) {
				System.out.println(object + "  ");
			}
			System.out.println();
		}
	}
    /**
     * 结果第一种处理方式ArrayHandler
     *  将结果集的 
     *       第一行
     *  存储到对象数组中Object[]
     * @throws SQLException 
     * 
     * */
    public static void arrayHander() throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		String sql = "select * from product";
		Object[] result = qRunner.query(con, sql, new ArrayHandler());
		for (Object object : result) {
			System.out.println(object);
		}
	}
    
    /**
     * 删除数据
     * @throws SQLException 
     * */
    public static void delete() throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		String sql = "delete from product where pname = ?";
		Object[] params = {"体育"};
        int row = qRunner.update(con, sql, params);
        System.out.println(row);
        DbUtils.close(con);
	}
    /**
     * 更新数据
     * @throws SQLException 
     * */
    public static void update() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update product set pname = ? where id = ?";
		Object[] params = {"更新",9};
		int row = qr.update(con,sql,params);
		System.out.println(row);
		DbUtils.close(con);
	}
    /**
     * 插入数据
     * @throws SQLException 
     * */
    public static void insert() throws SQLException {
		// 创建QueryRunner类对象
    	    QueryRunner qr = new QueryRunner();
    	    String sql = "insert into product(pname,price) values(?,?)";
    	    Object[] params = {"体育",23.1};
    	    int row = qr.update(con, sql, params);
    	    System.out.println(row);
    	    DbUtils.close(con);
	}
     
}
