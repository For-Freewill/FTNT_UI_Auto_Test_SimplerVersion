package utils.test.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ftnt.qa.autotest.ui.framework.db.CommonsDButil;
import ftnt.qa.autotest.ui.framework.db.CommonsRSDButil;
import ftnt.qa.autotest.ui.framework.db.model.DeviceModel;

//* ArrayHandler：把结果集中的第一行数据转成对象数组。
//* ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
//* BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中.
//* BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
//* ScalarHandler查询指定列名的值（单条数据）
//* ColumnListHandler：将结果集中某一列的数据存放到List中。
//* KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
//* MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
//* MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List

public class CommonsDButilTest {
	public static void main(String[] args) {
		//查看ReportServerde的AO创建的数据库和自动同步的数据库
		// ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
//		List<Object[]> resultlist = CommonsRSDButil
//				.queryArrayList("select tablename,tableowner from pg_tables where schemaname=? and tableowner=?", "public","phoenix");
//		for (Object[] objects : resultlist) {
//			for (Object object2 : objects) {
//				System.out.println("ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。" + Arrays.asList(object2));
//			}
//		}
//		
		
		// ArrayHandler：把结果集中的第一行数据转成对象数组。
		Object[] result = CommonsDButil
				.queryArray("select access_ip,discover_method from ph_device where cust_org_id=? LIMIT 10;", 2000);
		for (Object object : result) {
			System.out.println("ArrayHandler：把结果集中的第一行数据转成对象数组。" + Arrays.asList(object));
		}

		// ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
		List<Object[]> resultlist2 = CommonsDButil
				.queryArrayList("select access_ip,discover_method from ph_device where cust_org_id=? LIMIT 2;", 2000);
		for (Object[] objects : resultlist2) {
			for (Object object2 : objects) {
				System.out.println("ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。" + Arrays.asList(object2));
			}
		}

		// BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中.
		DeviceModel deviceTable = (DeviceModel) CommonsDButil.queryBean(DeviceModel.class,
				"select access_ip,discover_method,unmanaged from ph_device where access_ip!=? and discover_method=?",
				"10.30.2.173", "LOG");
		System.out.println("BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中." + deviceTable.getAccess_ip()
				+ deviceTable.getUnmanaged());

		// BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
		List<DeviceModel> deviceTables = (List<DeviceModel>) CommonsDButil.queryBeanList(DeviceModel.class,
				"select access_ip,discover_method,unmanaged from ph_device where access_ip!=? and discover_method=? LIMIT 2",
				"10.30.2.173", "LOG");
		for (DeviceModel deviceTable1 : deviceTables) {
			System.out.println("BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。" + deviceTable1.getAccess_ip()
					+ deviceTable1.getUnmanaged());
		}

		// * ScalarHandler查询指定列名的值（单条数据）
		String resultcol = CommonsDButil.queryColumn("access_ip", "select * from ph_device limit 2");
		System.out.println("ScalarHandler查询指定列名的值（单条数据）:" + resultcol);

		// * ColumnListHandler：将结果集中某一列的数据存放到List中。
		List<Object> result2 = CommonsDButil.queryColumnList("access_ip", "select * from ph_device");
		System.out.println("ColumnListHandler：将结果集中某一列的数据存放到List中。" + result2);

		// * KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
		System.out.println("KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key-------");
		@SuppressWarnings("unchecked")
		Map<String, Map> resule = (Map) CommonsDButil.queryKeyMap("name",
				"select name,access_ip from ph_device where access_ip!=? and discover_method=? LIMIT 2", "10.30.2.173",
				"LOG");
		for (Map.Entry<String, Map> me : resule.entrySet()) {
			String ip = me.getKey();
			Map<String, Object> innermap = me.getValue();
			for (Map.Entry<String, Object> innerme : innermap.entrySet()) {
				String columnName = innerme.getKey();
				Object value = innerme.getValue();
				System.out.println(columnName + "=" + value);
			}
			System.out.println(ip);
		}

		// * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
		System.out.println("MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。");
		Map<String, Object> result1 = CommonsDButil
				.queryMap("select access_ip,discover_method from ph_device where cust_org_id=? LIMIT 2", 2000);
		for (Map.Entry<String, Object> me : result1.entrySet()) {
			System.out.println(me.getKey() + "=" + me.getValue());
		}

		// * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
		System.out.println("MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List");
		List<Map<String, Object>> result3 = CommonsDButil.queryMapList(
				"select access_ip,discover_method,unmanaged from ph_device where cust_org_id=? LIMIT 2", 2000);
		for (Map<String, Object> map : result3) {
			for (Map.Entry<String, Object> me : map.entrySet()) {
				System.out.println(me.getKey() + "=" + me.getValue());
			}
		}
		
	}

}