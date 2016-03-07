package findMe.dataBase;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.Supervisor;

public class PersonDAO {
		private Connection conn;
		
		public PersonDAO() {
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Connection established");
			else System.out.println("Error in DB connection");
			
		}
		
		/*------------------------INSERT----------------------------*/
		public void insertPerson(Person person) {

			String q = "insert into person (id, cpf, namePerson, birth_dt)values (?,?,?,?)";
			try {
				// prepared statement para inserção
				PreparedStatement st = conn.prepareStatement(q);

				// seta os valores
				st.setString(1, person.getId());
				st.setString(2, person.getCpf());
				st.setString(3, person.getName());
				//st.setDate(4, person.getBirth_dt());
				//Buscar informações sobre isso.

				// executa
				st.execute();
				st.close();
				System.out.println("Cadastrado com sucesso!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}	
		
		/*------------------------DELETE----------------------------*/
		public void deletePerson(String id) {
			String sql = "delete from person where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, id);
				
				st.execute();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		/*------------------------UPDATE----------------------------*/
		public void updatePerson(Person person) {
			String sql = "update person set cpf = ?, namePerson = ?, birth_dt = ? where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, person.getCpf());
				st.setString(2, person.getName());
				//st.setString(3, person.getBirth_dt());
				st.setString(4, person.getId());
				
				st.execute();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
}
