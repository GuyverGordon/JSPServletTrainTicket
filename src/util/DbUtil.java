package util;

import java.sql.*;

public class DbUtil {
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "hr";
	private static final String PASSWORD = "hr";
	
	public DbUtil() { }
	
	public static Connection getConnection() throws  ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}
	
}
