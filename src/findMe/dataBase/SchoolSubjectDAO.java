package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DialogBox.AlertBox;

import java.util.*;

import findMe.domain.AuxiliarObject;
import findMe.domain.Monitor;
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
	
	/**
	 * Insert school subject on data base
	 * @param schoolSubject
	 * @throws SQLException sql's exception
	 */
	public void insertSchoolSubject(SchoolSubject schoolSubject) {
		String sql = "insert into schoolsubject (id, namesubject) values (?, ?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, schoolSubject.getId());
			st.setString(2, schoolSubject.getName());
			
			st.execute();
			st.close();
			//AlertBox.confirm("Monitor Manager", "Disciplina " + schoolSubject.getName() +  " atualizada com sucesso!" );

		} catch (SQLException e) {
			//AlertBox.error("Monitor Manager", e.getMessage() );
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	/**
	 * Method that excludes a SchoolSubject of the database
	 * @param id
	 * @throws SQLException sql's exception
	 */ 
	public void deleteSchoolSubject(String id) {
		String sql = "delete from schoolsubject where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
			//AlertBox.confirm("Monitor Manager", "Disciplina deletada com sucesso!" );
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*------------------------UPDATE----------------------------*/
	/**
	 * Updates the information of a SchoolSubject
	 * @param person
	 * @throws SQLException sql's exception
	 */
	public void updateSchoolSubject(SchoolSubject schoolSubject) {
		String sql = "update schoolsubject set namesubject = ? where id = ?";
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
	
	/*--------------------------CONSULTS--------------------------*/
	/**
	 * Verify if one subject is already in the database 
	 * @param nameSubject
	 * @throws SQLException sql's exception
	 * @return boolean
	 * @throws SQLException sql's exception
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
	 * Return the subjects's name and the supervisor related to them 
	 * @return List with the supervisors and subjects' names 
	 * @throws SQLException sql's exception
	 * @author Rebeca Galdino 
	 */
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
	 * @throws SQLException sql's exception
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
	
	
	/**
	 * Returns an array of all SchoolSubject and its id and name
	 * @return List<SchoolSUbject>
	 * @throws SQLException sql's exception
	 * @author ViniFarias
	 */
	public List<SchoolSubject> getInfoAllSubject(){
		String sql = " select schoolsubject.* from schoolsubject left join supervisor_schoolsubject as sb1 "
					+"on schoolsubject.id = sb1.id_schoolsubject left join supervisor as s1 on sb1.id_supervisor = s1.id "
					+"left join person as p1 on s1.id = p1.id left join monitor as m1 on "
					+"schoolsubject.id = m1.id_schoolsubject left join person as p2 on m1.id = p2.id order by schoolsubject.namesubject";
	try {
				
				List<SchoolSubject> subjects = new ArrayList<SchoolSubject>();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					SchoolSubject s = new SchoolSubject();
					s.setName(rs.getString("nameSubject"));
					s.setId(rs.getString("id"));
					
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
	
	
	
	/**
	 * Returns all information of a SchoolSubject and its monitors, supervisors and basic information, by its id
	 * @return Monitor
	 * @throws SQLException sql's exception
	 * @author ViniFarias
	 */
	public Monitor getAllInfoSubject(String id){
		String sql = "select schoolsubject.*, p1.id idP1, p1.namePerson namePersonP1, p1.email emailP1, "
					+"m1.roomwork roomworkM1, p2.id idP2, p2.namePerson namePersonP2, p2.email emailP2 from schoolsubject "
					+"left join supervisor_schoolsubject as sb1 on schoolsubject.id = sb1.id_schoolsubject "
					+"left join supervisor as s1 on sb1.id_supervisor = s1.id left join person as p1 on s1.id = p1.id "
					+"left join monitor as m1 on schoolsubject.id = m1.id_schoolsubject left join person as p2 "
					+"on m1.id = p2.id  where schoolsubject.id =  "+id;
		try {
				
				Monitor m = new Monitor();
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					
					SchoolSubject sb = new SchoolSubject();
					Supervisor s = new Supervisor();
					
					sb.setName(rs.getString("nameSubject"));
					sb.setId(rs.getString("id"));
					
					s.setId(rs.getString("idP1"));
					s.setName(rs.getString("namePersonP1"));
					s.setEmail(rs.getString("emailP1"));
					
					m.setId(rs.getString("idP2"));
					m.setRoomWork(rs.getString("roomworkM1"));
					m.setEmail(rs.getString("emailP2"));
					m.setName(rs.getString("namePersonP2"));
					
					m.setSubject(sb);
					m.setSupervisor(s);
					
					
					
				}
				
				rs.close();
				st.close();
				return m;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
	}
	
	
	
	/**
	 * Returns a SchoolSubject by his name
	 * @param id
	 * @return SchoolSubject
	 * @throws SQLException sql's exception
	 * @author ViniFarias
	 */
	public SchoolSubject getSchoolSubjectByName(String name){
		String sql = "select schoolsubject.* from schoolsubject where schoolsubject.namesubject = \""+name+"\"";
		
		try{
			SchoolSubject s = new SchoolSubject();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				s.setName(rs.getString("namesubject"));
				s.setId(rs.getString("id"));
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
	 * returns a SchoolSubject by id
	 * @param id
	 * @return SchoolSubject
	 * @throws SQLException sql's exception
	 */
	public SchoolSubject getSchoolSubjectById(String id){
		String sql = "select * from schoolsubject where id = "+id;
		
		try{
			SchoolSubject s = new SchoolSubject();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				s.setName(rs.getString("namesubject"));
				s.setId(rs.getString("id"));
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
