package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import findMe.domain.Supervisor;

public class BankAccountDAO {
	private Connection conn;
	
	public BankAccountDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	public void insertSupervisor(Supervisor supervisor) {
		String sql = "insert into supervisor_schoolsubject(id_supervisor, id_schoolsubject) values(?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			PersonDAO pdao = new PersonDAO();
			pdao.insertPerson(supervisor);
			
			st.setString(1, supervisor.getId());
			
			
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteSupervisor(String id) {
		String sql = "delete from supervisor where id = ?";
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
