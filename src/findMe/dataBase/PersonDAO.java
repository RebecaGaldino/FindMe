package findMe.dataBase;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import findMe.domain.Person;
import findMe.domain.Supervisor;

public class PersonDAO {
		private Connection conn;
		
		public PersonDAO() {
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Conexão estabelecida");
			else System.out.println("Erro na conexÃ£o com o BD");
			
		}
		
		
		public void insertPerson(Person person) {

			String q = "insert into person (id, cpf, name, birth_dt)values (?,?,?,?)";
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
}
