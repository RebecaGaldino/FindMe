package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import findMe.domain.Student;



public class StudentManipulateDB {

	
		private Connection conn;
		
		public StudentManipulateDB() {
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Conexão estabelecida");
			else System.out.println("Erro na conexão com o BD");
			
		}
		
		public void insertStudent(Student student) {
			String sql = "insert into student (id, course, year) values (?, ?, ?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, getIdPerson(student.getCpf()));
				st.setString(2, student.getCourse());
				st.setString(3, student.getGrade());
				
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
