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
		
}
