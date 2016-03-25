package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import findMe.domain.Manager;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;

public class ManagerDAO {
	
	/*------------------------Connection method-----------------*/
	private Connection conn;
	
	public ManagerDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/*------------------------INSERT----------------------------*/
	public void insertManager(Manager manager) {
		String sql = "insert into bankaccount(id) values(?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, manager.getId());
			
			
			
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	public void deleteManager(String id) {
		String sql = "delete from manager where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*-------------------------CONSULTS-------------------------*/
	
	/**
	 * Return the Managers' informations
	 * @return ArrayList with managers' data  
	 * @author Rebeca Galdino
	 */
	public List<Person> getManagersInformations(){
		String sql ="SELECT person.id, person.cpf, person.birth_dt as 'Data de nascimento', person.namePerson as 'Nome', person.password as 'Senha', person.sex as 'Sexo', person.email, person.rg "
				+"from manager "
				+"left join person on manager.id = person.id";
	try {
				
				List<Person> managers = new ArrayList<Person>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					Person p = new Person();
					p.setId(rs.getString("id"));
					p.setCpf(rs.getString("cpf"));
					p.setBirth_dt(rs.getString("Data de nascimento"));
					p.setName(rs.getString("Nome"));
					p.setPassword(rs.getString("Senha"));
					p.setSex(rs.getString("Sexo"));
					p.setEmail(rs.getString("email"));
					p.setRg(rs.getString("rg"));
			
					managers.add(p);
				}
				
				rs.close();
				st.close();
				return managers;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
				
	}
}
