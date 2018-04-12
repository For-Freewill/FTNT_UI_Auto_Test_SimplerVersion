package ftnt.qa.autotest.ui.framework.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

/**
 * @ClassName: CommonsRSDButil
 * @Description:操作ReportServer，使用dbutils框架的QueryRunner类完成CRUD
 * @author Wulei
 * @date 2018-4-10
 */

// * ArrayHandler：把结果集中的第一行数据转成对象数组。
// * ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
// * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中.
// * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
// * ScalarHandler查询指定列名的值（单条数据）
// * ColumnListHandler：将结果集中某一列的数据存放到List中。
// * KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
// * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
// * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
 
public class CommonsRSDButil {
	private static final QueryRunner runner = new QueryRunner();
	private static final Logger logger = Logger.getLogger(CommonsRSDButil.class);

	//获取数据库连接，获取的是c3p0的连接
	public static Connection openConnection() {
		Connection conn = null;
		try {
			conn = RSC3p0Util.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭数据库连接
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * @作用：ArrayHandler：把结果集中的第一行数据转成对象数组。
	 * @用法：
	*/ 
	public static Object[] queryArray(String sql, Object... params) {
		Object[] result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new ArrayHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	/**
	 * @作用：ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
	 * @用法：
	*/ 
	public static List<Object[]> queryArrayList(String sql, Object... params) {
		List<Object[]> result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new ArrayListHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	
	/**
	 * @作用：BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中.
	 * @用法：DeviceTable deviceTable = (DeviceTable)
	 QueryRunnerCRUDTest.queryBean(DeviceTable.class,"select
	 access_ip,discover_method,unmanaged from ph_device where access_ip!=? and
	 discover_method=?","10.30.2.173","LOG");
	 System.out.println("====="+deviceTable.getAccess_ip()+deviceTable.getUnmanaged());
	 */
	public static <T> T queryBean(Class<T> cls, String sql, Object... params) {
		T result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new BeanHandler<T>(cls), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	/**
	 * @作用：BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
	 * @用法：
	 	 List<DeviceTable> deviceTables = (List<DeviceTable>)
		 QueryRunnerCRUDTest.queryBeanList(DeviceTable.class,"select
		 access_ip,discover_method,unmanaged from ph_device where access_ip!=? and
		 discover_method=?","10.30.2.173","LOG");
		 for (DeviceTable deviceTable : deviceTables) {
		 System.out.println("====="+deviceTable.getAccess_ip()+deviceTable.getUnmanaged());
		 }
	*/
	public static <T> List<T> queryBeanList(Class<T> cls, String sql, Object... params) {
		List<T> result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new BeanListHandler<T>(cls), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}


	/**
	 * @作用：ScalarHandler查询指定列名的值（单条数据） 
	 * @用法：String result= queryColumn("access_ip", "select * from ph_device")
	 */
	public static <T> T queryColumn(String column, String sql, Object... params) {
		T result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new ScalarHandler<T>(column), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}

	/**
	 * @作用：ColumnListHandler：将结果集中某一列的数据存放到List中。
	 * @方法：List<Object> result2 =QueryRunnerCRUDTest.queryColumnList("access_ip", "select * from ph_device")
	 */
	public static <T> List<T> queryColumnList(String column, String sql, Object... params) {
		List<T> result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new ColumnListHandler<T>(column), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	/**
	 * @作用：KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
	 * @用法：
		 Map<String, Map> resule = (Map) QueryRunnerCRUDTest.queryKeyMap("name",
		 "select * from ph_device where access_ip!=? and discover_method=?",
		 "10.30.2.173", "LOG");
		 for (Map.Entry<String, Map> me : resule.entrySet()) {
		 String ip = me.getKey();
		 Map<String, Object> innermap = me.getValue();
		 for (Map.Entry<String, Object> innerme : innermap.entrySet()) {
		 String columnName = innerme.getKey();
		 Object value = innerme.getValue();
		 System.out.println(columnName + "=" + value);
		 }
		 System.out.println(ip);
		 System.out.println("----------------");
		 }
	*/
	public static <T> Map<T, Map<String, Object>> queryKeyMap(String column, String sql, Object... params) {
		Map<T, Map<String, Object>> result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new KeyedHandler<T>(column), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}

	/**
	 * @作用：MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
	 * @用法：
	 Map<String, Object> result1 = QueryRunnerCRUDTest
	 .queryMap("select access_ip,discover_method from ph_device where
	 cust_org_id=? LIMIT 10", 2000);
	 for (Map.Entry<String, Object> me : result1.entrySet()) {
	 System.out.println(me.getKey() + "=" + me.getValue());
	 }
	 */
	public static Map<String, Object> queryMap(String sql, Object... params) {
		Map<String, Object> result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new MapHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}

	// MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
	// 用法：
	// List<Map<String, Object>> result3 = QueryRunnerCRUDTest.queryMapList("select
	// access_ip,discover_method,unmanaged from ph_device where cust_org_id=? LIMIT
	// 10", 2000);
	// for(Map<String,Object> map :result3){
	// for(Map.Entry<String, Object> me : map.entrySet())
	// {
	// System.out.println(me.getKey() + "=" + me.getValue());
	// }
	// }
	public static List<Map<String, Object>> queryMapList(String sql, Object... params) {
		List<Map<String, Object>> result = null;
		Connection conn = openConnection();
		try {
			result = runner.query(conn, sql, new MapListHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	

	// 更新（包括UPDATE、INSERT、DELETE，返回受影响的行数）
	public static int update(String sql, Object... params) {
		Connection conn = openConnection();
		int result = 0;
		try {
			result = runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
}