package ftnt.qa.autotest.ui.framework.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.configuration.ConfigurationException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class RSC3p0Util {

		// 获得c3p0连接池对象
		static ComboPooledDataSource ds = new ComboPooledDataSource("reportserver");
		

		/**
		 * 获得数据库连接对象
		 *
		 * @return
		 * @throws SQLException
		 */
		public static Connection getConnection() throws SQLException {
			return ds.getConnection();
		}

		/**
		 * 获得c3p0连接池对象
		 * 
		 * @return
		 * @throws ConfigurationException 
		 */
		public static DataSource getDataSource(){
			return ds;
		}

		public static void closeDB(Connection conn, PreparedStatement ps, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		// 释放资源，将数据库连接还给数据库连接池
		public static void closeDB(PreparedStatement ps, Connection conn) {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
