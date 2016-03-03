package findMe.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;





import findMe.domain.Monitor;

public class MonitorDAO {
	private Connection conn;
	
	public MonitorDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");
		
	}
	
	/*------------------------INSERT----------------------------*/
	public void insertMonitor(Monitor monitor) {
		String sql = "insert into monitor (id, id_schoolsubject, id_supervisor) values (?, ?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, getIdStudent(monitor.getCpf()));
			st.setString(2, monitor.getSubject().getId());
			st.setString(3, monitor.getSupervisor().getId());
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	public void deleteMonitor(String id) {
		String sql = "delete from monitor where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getIdStudent(String cpf){
		
		String idStudent = " "; 
		String sql = "select id from student where cpf = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				 idStudent = rs.getString("id");
				}
			return idStudent;
			
		} catch(Exception e){
			
			System.out.println("Exception is :"+e);
		}
			return " ";
		}
		
}
