package findMe.dataBase;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PersonManipulateDB {
		private Connection conn;
		
		public PersonManipulateDB() {
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Conex�o estabelecida");
			else System.out.println("Erro na conex�o com o BD");
			
		}
		
		public void insertPerson(String id, String cpf, String name, Date birth_dt ) {
			try {
				Statement st = conn.createStatement();
				String q = "insert into Person values(" + id +","+ cpf + "," + name + "," + birth_dt + ")";
				st.executeUpdate(q);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
}
