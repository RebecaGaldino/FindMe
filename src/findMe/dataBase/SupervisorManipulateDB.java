package findMe.dataBase;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import findMe.domain.Supervisor;

public class SupervisorManipulateDB {
		private Connection conn;
		
		public SupervisorManipulateDB() {
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Conex√£o estabelecida");
			else System.out.println("Erro na conex√£o com o BD");
			
		}
		
		public void insertSupervisora(String id, String name) {
			try {
				Statement st = conn.createStatement();
				String q = "insert into person values(" + id +"," + name  + ")";
				st.executeUpdate(q);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}	
		
		public void insertSupervisor(Supervisor supervisor) {
			
			String q = "insert into supervisor (id)values (?)";
			try {
				// prepared statement para inserÁ„o
				PreparedStatement st = conn.prepareStatement(q);

				// seta os valores
				st.setString(1, getIdPerson(supervisor.getCpf()));

				// executa
				st.execute();
				st.close();
				System.out.println("Cadastrado com sucesso!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
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
