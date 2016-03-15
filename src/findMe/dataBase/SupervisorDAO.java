package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import findMe.domain.Monitor;
import findMe.domain.Supervisor;

public class SupervisorDAO{
		private Connection conn;
		
		public SupervisorDAO(){
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Connection established");
			else System.out.println("Error in DB connection");
			
		}	
		
		/*------------------------INSERT----------------------------*/
		public void insertSupervisor(Supervisor supervisor) {
			String sql = "insert into supervisor(id) values(?)";
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
		
		
		/*------------------------DELETE----------------------------*/
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
		
		public String getIdPerson(String cpf){
			String idPerson = " "; 
			String sql = "select id from pessoa where cpf = ?";
			
			try{
				
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1,cpf);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					 idPerson = rs.getString("id");
				}
				return idPerson;
				
			} catch(Exception e){
				System.out.println("Exception is :"+e);
			}
			return " ";
		}
}
