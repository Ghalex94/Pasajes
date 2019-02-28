package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public MySQLConexion(){}
	
	private static String URL="jdbc:mysql://localhost:3306/db_venta_pasajes?useSSL=false";
	private static String USER="root";
	private static String PASS="Aa123";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConection(){
		Connection con = null;
		try {
			con=DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
