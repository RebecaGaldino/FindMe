package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.Student;
import findMe.domain.Supervisor;
import main.Teste;

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

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password, sex, email, rg)values (?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);

				
				st.setString(1, person.getId());
				st.setString(2, person.getCpf());
				st.setString(3, person.getName());
				st.setDate(4, convertStringToDate(person.getBirth_dt()));
				st.setString(5,person.getPassword());
				st.setString(6,person.getSex());
				st.setString(7,person.getEmail());
				st.setString(8,person.getRg());

				
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

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password, sex, email, rg)values (?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement st = conn.prepareStatement(sql);

				String date = "2000-11-01";
			    java.sql.Date test = java.sql.Date.valueOf(date);

				st.setString(1, supervisor.getId());
				st.setString(2, supervisor.getCpf());
				st.setString(3, supervisor.getName());
				st.setDate(4, test);
				st.setString(5, supervisor.getPassword());
				st.setString(6, supervisor.getSex());
				st.setString(7, supervisor.getEmail());
				st.setString(8, supervisor.getRg());
				
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

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password, sex, email, rg)values (?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);

				
				st.setString(1, student.getId());
				st.setString(2, student.getCpf());
				st.setString(3, student.getName());
				st.setDate(4,  convertStringToDate(student.getBirth_dt()));
				st.setString(5, student.getPassword());
				st.setString(6, student.getSex());
				st.setString(7, student.getEmail());
				st.setString(8, student.getRg());

				
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

			String sql = "insert into person (id, cpf, namePerson, birth_dt, password, sex, email, rg)values (?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement st = conn.prepareStatement(sql);

				st.setString(1, monitor.getId());
				st.setString(2, monitor.getCpf());
				st.setString(3, monitor.getName());
				st.setDate(4, convertStringToDate(monitor.getBirth_dt()));
				st.setString(5, monitor.getPassword());
				st.setString(6, monitor.getSex());
				st.setString(7, monitor.getEmail());
				st.setString(8, monitor.getRg());

				
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
				System.out.println("Person deletado com sucesso!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param person
		 */
		public void updatePerson(Person person) {
			String sql = "update person set cpf = ?, namePerson = ?, birth_dt = ?, password = ?, sex = ?, email = ?, rg = ? where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, person.getCpf());
				st.setString(2, person.getName());
				st.setDate(3, convertStringToDate(person.getBirth_dt()));
				st.setString(4, person.getPassword());
				st.setString(5, person.getSex());
				st.setString(6, person.getEmail());
				st.setString(7, person.getRg());
				st.setString(8, person.getId());
				
				st.execute();
				st.close();
				System.out.println("Person deletado com sucesso!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		/**
		 * Verifica se existe uma pessoa cadastrada com determinado id no banco
		 * @param id
		 * @return boolean
		 * @author ViniFarias
		 */
		public boolean checksId(String id){
			String sql = "SELECT id from person where id = "+id;
			
			try {
			
				PreparedStatement st = conn.prepareStatement(sql);
			
				ResultSet rs = st.executeQuery();
			
				if(rs.next()){
					return true;
				}
				else{
					return false;
				}
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
				return false;
		}
		
		
		/**
		 * Verifica a senha e id do usuario
		 * @param id
		 * @param password
		 * @return boolean
		 * @author ViniFarias
		 */
		public boolean userChecks(String id, String password){
			String sql = "SELECT person.password from person where id = "+id;
			
			try {
			
				PreparedStatement st = conn.prepareStatement(sql);
			
				ResultSet rs = st.executeQuery();
			
				if(rs.next()){
					String pass = rs.getString("password");
					
					if(password.equals(pass)){
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
				return false;
		}
		
		
		/*----------Metodos Auxiliares----------------*/
		/**
		 * Convert String to sql date
		 * @param date
		 * @return
		 * @author ViniFarias
		 */
		public java.sql.Date convertStringToDate(String date){
			try {
				Teste.convertStringToSqlString(date);
				java.sql.Date dt = java.sql.Date.valueOf(date);
				return dt;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		
		
}


