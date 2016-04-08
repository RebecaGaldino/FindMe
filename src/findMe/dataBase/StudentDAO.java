package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.Student;

public class StudentDAO{

		private Connection conn;
		
		public StudentDAO() {
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Connection established");
			else System.out.println("Error in DB connection");
			
		}
		
		/*------------------------INSERT----------------------------*/
		/**
		 * Insert school student on data base
		 * @param student
		 * @throws SQLException sql's exception
		 */
		public void insertStudent(Student student) {
			String sql = "insert into student (id, course, grade) values (?, ?, ?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				PersonDAO pdao = new PersonDAO();
				
				pdao.insertPerson(student);
				
				st.setString(1, student.getId());
				st.setString(2, student.getCourse());
				st.setString(3, student.getGrade());
				
				st.execute();
				st.close();
				System.out.println("Student cadastrado com sucesso!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		/**
		 * Method that inserts a person in the database from a monitor
		 * @param monitor
		 * @throws SQLException sql's exception
		 */
		public void insertStudent(Monitor monitor) {
			String sql = "insert into student(id, course, grade) values (?, ?, ?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				PersonDAO pdao = new PersonDAO();
				
				pdao.insertPerson(monitor);
				
				st.setString(1, monitor.getId());
				st.setString(2, monitor.getCourse());
				st.setString(3, monitor.getGrade());
				
				st.execute();
				st.close();
				System.out.println("Student cadastrado com sucesso!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		/*------------------------DELETE----------------------------*/
		/**
		 * Method that excludes a student of the database
		 * @param id
		 * @throws SQLException sql's exception
		 */ 
		public void deleteStudent(String id) {
			String sql = "delete from student where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, id);
				
				st.execute();
				st.close();
				System.out.println("Student deletado com sucesso!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		/*------------------------UPDATE----------------------------*/
		/**
		 * Updates the information of a Student
		 * @param student
		 * @throws SQLException sql's exception
		 */
		public void updateStudent(Student student) {
			String sql = "update student set course = ?, grade = ? where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, student.getCourse());
				st.setString(2, student.getGrade());
				st.setString(3, student.getId());
				
				st.execute();
				st.close();
				System.out.println("Student atualizado com sucesso!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		/**
		 * Return a person's id by cpf
		 * @param cpf
		 * @return id
		 * @throws SQLException sql's exception
		 */
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
