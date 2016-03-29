package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;

public class SupervisorDAO{
	/*------------------------Connection method-----------------*/
		private Connection conn;
		
		public SupervisorDAO(){
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Connection established");
			else System.out.println("Error in DB connection");
			
		}	
		/*------------------------INSERT----------------------------*/
		/**
		 * 
		 * @param supervisor
		 */
		public void insertSupervisor(Supervisor supervisor) {
			String sql = "insert into supervisor(id) values(?)";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				PersonDAO pdao = new PersonDAO();
				pdao.insertPerson(supervisor);
				
				st.setString(1, supervisor.getId());
				
				
				
				st.execute();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		/*------------------------DELETE----------------------------*/
		/**
		 * 
		 * @param id
		 */
		public void deleteSupervisor(String id) {
			String sql = "delete from supervisor where id = ?";
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
		 * @param cpf
		 * @return
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
		/*------------------------UPDATE----------------------------*/
		public void updateSupervisor(Supervisor supervisor){
			String sql = "update person set id = ?, cpf = ?, namePerson = ?, birth_dt = ?, password = ?, sex = ?, email = ?, rg = ? "
					+ "where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				PersonDAO p = new PersonDAO();
				
				st.setString(1, supervisor.getId());
				st.setString(2, supervisor.getCpf());
				st.setString(3, supervisor.getName());
				st.setDate(4, p.convertStringToDate(supervisor.getBirth_dt()));
				st.setString(5, supervisor.getPassword());
				st.setString(6, supervisor.getSex());
				st.setString(7, supervisor.getEmail());
				st.setString(8, supervisor.getRg());
				st.setString(9, supervisor.getId());
				
				st.execute();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		/*-------------------------CONSULTS-------------------------*/
		/**
		 * Lista e exibe todos os supervisores e suas matrículas
		 * @return ArrayList
		 * @author ViniFarias
		 */
		public List<Person> getSupervisorsAndIds(){
			String sql = "SELECT person.namePerson Nome, person.id Matricula FROM supervisor "
						+"INNER JOIN person ON supervisor.id = person.id ORDER BY person.namePerson";
			try {
				
				List<Person> persons = new ArrayList<Person>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					Person p = new Person();
					p.setId(rs.getString("Matricula"));
					p.setName(rs.getString("Nome"));
					
					persons.add(p);
					
				}
				
				rs.close();
				st.close();
				return persons;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		
		
		public List<Supervisor> getAllInfoSupervisors(){
			String sql = "SELECT schoolsubject.id id_subject, schoolsubject.namesubject, person.* "
					+"from person inner join supervisor on supervisor.id = person.id "
					+"inner join schoolsubject on schoolsubject.id is not null "
					+"inner join supervisor_schoolsubject on supervisor.id = supervisor_schoolsubject.id_supervisor "
					+"and schoolsubject.id = supervisor_schoolsubject.id_schoolsubject "
					+"order by person.namePerson";
			
			try {
				
				List<Supervisor> tb = new ArrayList<Supervisor>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					Supervisor supervisor = new Supervisor();
					SchoolSubject ss = new SchoolSubject();
					
					supervisor.setId(rs.getString("id"));
					supervisor.setCpf(rs.getString("cpf"));
					supervisor.setBirth_dt(rs.getString("birth_dt"));
					supervisor.setName(rs.getString("namePerson"));
					supervisor.setPassword(rs.getString("password"));
					supervisor.setSex(rs.getString("sex"));
					supervisor.setEmail(rs.getString("email"));
					supervisor.setRg(rs.getString("rg"));
					
					ss.setId(rs.getString("id_subject"));
					ss.setName(rs.getString("namesubject"));
					
					tb.add(supervisor);
					
				}
				
				rs.close();
				st.close();
				return tb;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		
		/**
		 * Verifica a senha e id do usuário Supervisor
		 * @param id
		 * @param password
		 * @return boolean
		 * @author ViniFarias
		 */
		public boolean userChecksSupervisor(String id, String password){
			String sql = "SELECT p1.password from supervisor INNER JOIN person as p1 "
					+"ON supervisor.id = p1.id where supervisor.id = "+id;
			
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
		
		
		
		/**
		 * Verifica se um supervisor ja existe no bd a partir do id
		 * @param id
		 * @param password
		 * @return boolean
		 * @author ViniFarias
		 */
		public boolean userChecksSupervisorId(String id, String password){
			String sql = "SELECT p1.id from supervisor INNER JOIN person as p1 ON supervisor.id = p1.id "
					+"where supervisor.id = "+id;
			
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
}
