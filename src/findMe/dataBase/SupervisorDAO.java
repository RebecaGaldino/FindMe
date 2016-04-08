package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DialogBox.AlertBox;

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
		 * Method that inserts a new supervisor in the database
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
				System.out.println("Supervisor cadastrado com sucesso!");
			} catch (SQLException e) {
				AlertBox.error("Monitor Manager", e.getMessage() );
			}
		}
		
		/*------------------------DELETE----------------------------*/
		
		/**
		 * Method that excludes a supervisor of the database
		 * @param id
		 */
		public void deleteSupervisor(String id) {
			String sql = "delete from supervisor where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, id);
				
				st.execute();
				st.close();
				System.out.println("Supervisor deletado com sucesso!");
			} catch (SQLException e) {
				AlertBox.error("Monitor Manager", e.getMessage() );
			}
		}
		
		/**
		 * Returns a person's Id from your cpf
		 * @param cpf
		 * @return
		 */
		public String getIdPerson(String cpf){
			String idPerson = " "; 
			String sql = "select id from person where cpf = ?";
			
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
		/**
		 * Updates the information of a supervisor
		 * @param supervisor
		 */
		public void updateSupervisor(Supervisor supervisor){
			String sql = " update person set cpf = ?, namePerson = ?, birth_dt = ?, password = ? "
					+ "sex = ?, email = ?, rg = ? where person.id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				PersonDAO p = new PersonDAO();
				
				st.setString(1, supervisor.getCpf());
				st.setString(2, supervisor.getName());
				st.setDate(3, p.convertStringToDate(supervisor.getBirth_dt()));
				st.setString(4, supervisor.getPassword());
				st.setString(5, supervisor.getSex());
				st.setString(6, supervisor.getEmail());
				st.setString(7, supervisor.getRg());
				st.setString(8, supervisor.getId());
				
				st.execute();
				st.close();
				System.out.println("Supervisor atualizado com sucesso!");
			} catch (SQLException e) {
				AlertBox.error("Monitor Manager", e.getMessage() );
			}
		}
		
		/*-------------------------CONSULTS-------------------------*/
		/**
		 * Lists all supervisors and their Ids
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
				AlertBox.error("Monitor Manager", e.getMessage() );
			}
			return null;
		}
		
		
		/**
		 * List all supervisors who have a SchoolSubject and your information
		 * @return
		 */
		public List<Supervisor> getInfoAllSupervisors(){
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
		 * Lists all supervisors and their information
		 * @return
		 */
		public List<Supervisor> getAllInfoAllSupervisors(){
			String sql = " select supervisor.*, p1.*, s1.id id_subject, s1.namesubject from supervisor left join supervisor_schoolsubject as sb1 "
					+"on supervisor.id = sb1.id_supervisor left join person as p1 on supervisor.id = p1.id "
					+"left join schoolsubject s1 on sb1.id_schoolsubject = s1.id order by p1.namePerson";
			
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
		 * Checks the ID and password of the supervisor User
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
				AlertBox.error("Monitor Manager", e.getMessage() );
			}
				return false;
		}
		
		
		
		/**
		 * Checks whether a supervisor exists in the database by his id
		 * @param id
		 * @param password
		 * @return boolean
		 * @author ViniFarias
		 */
		public boolean userChecksSupervisorId(String id){
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
		
		
		/**
		 * checks whether a supervisor exists in the database by his name
		 * @param id
		 * @param password
		 * @return boolean
		 * @author ViniFarias
		 */
		public boolean userChecksSupervisorName(String name){
			String sql = "SELECT p1.namePerson from supervisor INNER JOIN person as p1 ON supervisor.id = p1.id"
						+"where p1.namePerson = "+name;
			
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
		 * Returns a supervisor by his id
		 * @param id
		 * @return
		 * @author ViniFarias
		 */
		public Supervisor getSupervisorById(String id){
			String sql = "select supervisor.*, p1.*, s1.id id_subject, s1.namesubject from supervisor "
						+"left join supervisor_schoolsubject as sb1 on supervisor.id = sb1.id_supervisor "
						+"left join person as p1 on supervisor.id = p1.id left join schoolsubject s1 "
						+"on sb1.id_schoolsubject = s1.id where supervisor.id = "+id;
			
			try{
				Supervisor s = new Supervisor();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					SchoolSubject sb = new SchoolSubject();
					
					sb.setName(rs.getString("nameSubject"));
					sb.setId(rs.getString("id_subject"));
					
					s.setId(rs.getString("id"));
					s.setCpf(rs.getString("cpf"));
					s.setBirth_dt(rs.getString("birth_dt"));
					s.setName(rs.getString("namePerson"));
					s.setRg(rs.getString("rg"));
					s.setSex(rs.getString("sex"));
					s.setEmail(rs.getString("email"));
					
				}
				
				rs.close();
				st.close();
				return s;
			} catch(Exception e){
				System.out.println("Exception is :"+e);
			}
			return null;
		}
		
		
		
		/**
		 * returns a supervisor by his name
		 * @param id
		 * @return
		 * @author ViniFarias
		 */
		public Supervisor getSupervisorByName(String name){
			String sql = "select supervisor.*, p1.*, s1.id id_subject, s1.namesubject from supervisor "
						+"left join supervisor_schoolsubject as sb1 on supervisor.id = sb1.id_supervisor "
						+"left join person as p1 on supervisor.id = p1.id left join schoolsubject s1 "
						+"on sb1.id_schoolsubject = s1.id where p1.namePerson = \""+name+"\"";
			
			try{
				Supervisor s = new Supervisor();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					SchoolSubject sb = new SchoolSubject();
					
					sb.setName(rs.getString("nameSubject"));
					sb.setId(rs.getString("id_subject"));
					
					s.setId(rs.getString("id"));
					s.setCpf(rs.getString("cpf"));
					s.setBirth_dt(rs.getString("birth_dt"));
					s.setName(rs.getString("namePerson"));
					s.setRg(rs.getString("rg"));
					s.setSex(rs.getString("sex"));
					s.setEmail(rs.getString("email"));
					
				}
				
				rs.close();
				st.close();
				return s;
			} catch(Exception e){
				System.out.println("Exception is :"+e);
			}
			return null;
		}
	
}


