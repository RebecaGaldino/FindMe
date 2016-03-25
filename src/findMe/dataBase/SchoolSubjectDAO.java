package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;

public class SchoolSubjectDAO {

	private Connection conn;
	
	public SchoolSubjectDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/*------------------------INSERT----------------------------*/
	public void insertSchoolSubject(SchoolSubject schoolSubject) {
		String sql = "insert into schoolsubject (id, namesubject) values (?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, schoolSubject.getId());
			st.setString(2, schoolSubject.getName());
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	public void deleteSchoolSubject(String id) {
		String sql = "delete from schoolsubject where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*------------------------UPDATE----------------------------*/
	public void updateSchoolSubject(SchoolSubject schoolSubject) {
		String sql = "update schoolsubject set name = ? where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, schoolSubject.getName());
			st.setString(2, schoolSubject.getId());
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Verify if one subject is already in the database 
	 * @param nameSubject
	 * @return boolean
	 */
	public boolean checksNameSubject(String nameSubject){
		String sql = "SELECT schoolsubject.namesubject "
					+"FROM schoolsubject WHERE schoolsubject.namesubject = \""+nameSubject+"\"";
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
	 * Return the subjects' names 
	 * @return ArrayList with subjects and their names 
	 * @author Rebeca Galdino
	 */
	public List<SchoolSubject> getSubjectsnames(){
		String sql = "SELECT namesubject as Disciplinas from schoolsubject "
					+"order by Disciplinas";
	try {
				
				List<SchoolSubject> subjects = new ArrayList<SchoolSubject>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					SchoolSubject s = new SchoolSubject();
					s.setName(rs.getString("Disciplinas"));
					
					subjects.add(s);
					
				}
				
				rs.close();
				st.close();
				return subjects;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
				
	}
	
     //IMPORTANTE: TESTE E TEMPORÁRIA
	 /**
	 * Return the subjects's name and the supervisor related to them 
	 * @return List with the supervisors and subjects' names 
	 * @author Rebeca Galdino  
	 */
	public Map<List<SchoolSubject>,List<Supervisor>> getSubjectsandSupervisorsMap(){
		String sql = "SELECT schoolsubject.namesubject as Disciplina, person.nameperson as Supervisor from person "
				+"inner join supervisor on supervisor.id = person.id "
				+"inner join schoolsubject on schoolsubject.id is not null "
				+"inner join supervisor_schoolsubject on supervisor.id = supervisor_schoolsubject.id_supervisor and schoolsubject.id = supervisor_schoolsubject.id_schoolsubject " 
				+"order by Disciplina";
		
	try {
		
		List<SchoolSubject> subjects = new ArrayList<SchoolSubject>();
		List<Supervisor> supervisors = new ArrayList<Supervisor>();
		Map<List<SchoolSubject>,List<Supervisor>> subjectsandsupervisors = new HashMap<List<SchoolSubject>,List<Supervisor>>();
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){
			
			SchoolSubject s = new SchoolSubject();
			s.setName(rs.getString("Disciplina"));
			Supervisor su = new Supervisor();
			su.setName(rs.getString("Supervisor"));
			
			subjects.add(s);
			supervisors.add(su);
			
		}
		
		subjectsandsupervisors.put(subjects, supervisors);
		rs.close();
		st.close();
		return subjectsandsupervisors;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	

	}
	
	/* A SER USADA CASO A COM MAP NAO FUNCIONAR 
	public List<Person> getSubjectsandSupervisors(){
		String sql = "SELECT schoolsubject.namesubject as Disciplina, person.nameperson as Supervisor from person "
				+"inner join supervisor on supervisor.id = person.id "
				+"inner join schoolsubject on schoolsubject.id is not null "
				+"inner join supervisor_schoolsubject on supervisor.id = supervisor_schoolsubject.id_supervisor and schoolsubject.id = supervisor_schoolsubject.id_schoolsubject " 
				+"order by Disciplina";
		
	try {
		List<Person> persons = new ArrayList<Person>();
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){
			
			Person p = new Person();
			p.setId(rs.getString("Disciplina"));
			p.setName(rs.getString("Supervisor"));
			
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
	*/
	/**
	 * Show all the names of a subject's monitor
	 * @return List with names of subjects and their monitors
	 * @author Rebeca Galdino
	 */
	public List<Person> getMonitorsofasubject(){
		String sql = "SELECT schoolsubject.namesubject as Disciplina, person.nameperson as Monitor from person "
				+"inner join monitor on monitor.id = person.id "
				+"inner join schoolsubject on monitor.id_schoolsubject = schoolsubject.id "
				+"order by Disciplina";
	try {
				
				List<Person> persons = new ArrayList<Person>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					Person p = new Person();
					p.setId(rs.getString("Disciplina"));
					p.setName(rs.getString("Monitor"));
					
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
