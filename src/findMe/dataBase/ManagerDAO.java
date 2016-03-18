package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import findMe.domain.Manager;
import findMe.domain.Monitor;

public class ManagerDAO {
private Connection conn;
	
	public ManagerDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	public void insertManager(Manager manager) {
		String sql = "insert into bankaccount(id) values(?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, manager.getId());
			
			
			
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteManager(String id) {
		String sql = "delete from manager where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
