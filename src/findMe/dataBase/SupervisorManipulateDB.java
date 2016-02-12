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
				System.out.println("Conexão estabelecida");
			else System.out.println("Erro na conexão com o BD");
			
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
				// prepared statement para inserção
				PreparedStatement st = conn.prepareStatement(q);

				// seta os valores
				/*st.setString(1, person.getId());
				st.setString(2, person.getCpf());
				st.setString(3, person.getName());
				//st.setDate(4, person.getBirth_dt());*/
				//Buscar informações sobre isso.

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
