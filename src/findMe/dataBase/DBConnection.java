package findMe.dataBase;

import java.sql.*;

public class DBConnection {
	
	public static String status = "";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// Carregando o driver JDBC para MySQL. Cada SGBD tem seu proprio driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://localhost/findme?user=root&password=root";

			conn = DriverManager.getConnection(url);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
}