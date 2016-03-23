package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.Student;
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
		/**
		 * 
		 * @param person
		 */
		public void insertPerson(Person person) {

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password)values (?,?,?,?,?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);

				
				st.setString(1, person.getId());
				st.setString(2, person.getCpf());
				st.setString(3, person.getName());
				st.setDate(4, new java.sql.Date(person.getBirth_dt().getTime()));
				st.setString(5,person.getPassword());

				
				st.execute();
				st.close();
				System.out.println("Person cadastrado com sucesso!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}	
		
		/**
		 * 
		 * @param person
		 */
		public void insertPerson(Supervisor supervisor) {

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password)values (?,?,?,?,?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);

				
				st.setString(1, supervisor.getId());
				st.setString(2, supervisor.getCpf());
				st.setString(3, supervisor.getName());
				st.setDate(4, new java.sql.Date(supervisor.getBirth_dt().getTime()));
				st.setString(5, supervisor.getPassword());
				
				st.execute();
				st.close();
				System.out.println("Person cadastrado com sucesso!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		/**
		 * 
		 * @param person
		 */
		public void insertPerson(Student student) {

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password)values (?,?,?,?,?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);

				
				st.setString(1, student.getId());
				st.setString(2, student.getCpf());
				st.setString(3, student.getName());
				st.setDate(4,  new java.sql.Date(student.getBirth_dt().getTime()));
				st.setString(5, student.getPassword());

				
				st.execute();
				st.close();
				System.out.println("Person cadastrado com sucesso!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		/**
		 * 
		 * @param person
		 */
		public void insertPerson(Monitor monitor) {

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password)values (?,?,?,?,?)";
			try {
				PreparedStatement st = conn.prepareStatement(sql);

				st.setString(1, monitor.getId());
				st.setString(2, monitor.getCpf());
				st.setString(3, monitor.getName());
				st.setDate(4, new java.sql.Date(monitor.getBirth_dt().getTime()));
				st.setString(5, monitor.getPassword());

				
				st.execute();
				st.close();
				System.out.println("Person cadastrado com sucesso!");
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
		
		
		/**
		 * 
		 * @param person
		 */
		public void updatePerson(Person person) {
			String sql = "update person set cpf = ?, namePerson = ?, birth_dt = ?, password = ? where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, person.getCpf());
				st.setString(2, person.getName());
				st.setDate(3, new java.sql.Date(person.getBirth_dt().getTime()));
				st.setString(4, person.getPassword());
				st.setString(5, person.getId());
				
				st.execute();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
}
