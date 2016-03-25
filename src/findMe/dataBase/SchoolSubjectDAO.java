package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import findMe.domain.AuxiliarObject;
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
	
	
	public List<AuxiliarObject> getSubjectsandSupervisors(){
		String sql = "SELECT schoolsubject.namesubject as Disciplina, person.nameperson as Supervisor from person "
				+"inner join supervisor on supervisor.id = person.id "
				+"inner join schoolsubject on schoolsubject.id is not null "
				+"inner join supervisor_schoolsubject on supervisor.id = supervisor_schoolsubject.id_supervisor and schoolsubject.id = supervisor_schoolsubject.id_schoolsubject " 
				+"order by Disciplina";
		
	try {
		List<AuxiliarObject> subjectsandsupervisors = new ArrayList<AuxiliarObject>();
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){
			

			AuxiliarObject a = new AuxiliarObject();
			a.setA(rs.getString("Disciplina"));
			a.setB(rs.getString("Supervisor"));
			
			subjectsandsupervisors.add(a);
			
			
		}
		
		rs.close();
		st.close();
		return subjectsandsupervisors;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	

	}
	
	/**
	 * Show all the names of a subject's monitor
	 * @return List with names of subjects and their monitors
	 * @author Rebeca Galdino
	 */
	public List<AuxiliarObject> getMonitorsofasubject(){
		String sql = "SELECT schoolsubject.namesubject as Disciplina, person.nameperson as Monitor from person "
				+"inner join monitor on monitor.id = person.id "
				+"inner join schoolsubject on monitor.id_schoolsubject = schoolsubject.id "
				+"order by Disciplina";
	try {
				
				List<AuxiliarObject> monitorsandsubjects = new ArrayList<AuxiliarObject>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				
				while(rs.next()){
					
					AuxiliarObject a = new AuxiliarObject();
					a.setA(rs.getString("Disciplina"));
					a.setB(rs.getString("Monitor"));
					
					monitorsandsubjects.add(a);
					
				}
				
				rs.close();
				st.close();
				return monitorsandsubjects;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
}
