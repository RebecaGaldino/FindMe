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
		
		public int getIdPessoa(String cpf){
				
				String cpf = ""; 
				String sql = "select cpf from person where cpf = ?";
				
				try{
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1,matricula);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						idPessoa = rs.getInt("idPessoa");
					}
					return idPessoa;
				}catch(Exception e){
					System.out.println("Exception is :"+e);
				}
			return 0;	
		}
}
