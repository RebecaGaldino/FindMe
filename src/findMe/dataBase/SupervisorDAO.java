package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.Supervisor;

public class SupervisorDAO{
		private Connection conn;
		
		public SupervisorDAO(){
			conn = DBConnection.getConnection();
			if(conn != null)
				System.out.println("Connection established");
			else System.out.println("Error in DB connection");
			
		}	
		
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
		
		public void updateSupervisor(Supervisor supervisor){
			String sql = "update person set cpf = ?, namePerson = ?, birth_dt = ?, password = ? where id = ?";
			try {
				
				PreparedStatement st = conn.prepareStatement(sql);
				PersonDAO p = new PersonDAO();
				
				st.setString(1, supervisor.getCpf());
				st.setString(2, supervisor.getName());
				st.setDate(3, p.convertStringToDate(supervisor.getBirth_dt()));
				st.setString(4, supervisor.getId());
				
				st.execute();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
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
		
}
