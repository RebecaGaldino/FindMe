package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import DialogBox.AlertBox;

import java.sql.PreparedStatement;

import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.domain.TimeTable;

public class MonitorDAO{
	private Connection conn;
	
	public MonitorDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/**
	 * Insert on monitor using studentDAO
	 * @param monitor
	 */
	public void insertMonitor(Monitor monitor) {
	
		String sql = "insert into monitor (id, id_schoolsubject, id_supervisor, roomwork, id_bankaccount) values (?, ?, ?, ?, ?)";
		try {
			System.out.println("oi");
			PreparedStatement st = conn.prepareStatement(sql);
			
			StudentDAO sdao = new StudentDAO();
			sdao.insertStudent(monitor);
			
			BankAccountDAO badao = new BankAccountDAO();
			badao.insertBankAccount(monitor);
			
			st.setString(1, monitor.getId());
			st.setString(2, monitor.getSubject().getId());
			st.setString(3, monitor.getSupervisor().getId());
			st.setString(4, monitor.getRoomWork());
			st.setString(5, monitor.getBankAccount().getId());
			
			st.execute();
			st.close();
			AlertBox.confirm("Monitor Manager", "Monitor cadastrado com sucesso!" );
		} catch (SQLException e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	/**
	 * Delete Monitor by id
	 * @param id
	 */
	public void deleteMonitor(String id) {
		String sql = "delete from monitor where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
			AlertBox.confirm("Monitor Manager", "Monitor deletado com sucesso!" );

		} catch (SQLException e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	
	/**
	 * Update any monitors attribute 
	 * @param monitor
	 */
	public void updateMonitor(Monitor monitor) {
		String sql = "update monitor set id_supervisor = ?, id_schoolsubject = ?, roomwork = ?, id_bankAccount = ? where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, monitor.getSupervisor().getId());
			st.setString(2, monitor.getSubject().getId());
			st.setString(3, monitor.getRoomWork());
			st.setString(4, monitor.getBankAccount().getId());
			st.setString(5, monitor.getId());
			
			st.execute();
			st.close();
			AlertBox.confirm("Monitor Manager", "Dados atualizados com sucesso!" );
		} catch (SQLException e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	public String getIdStudent(String cpf){
		
		String idStudent = " "; 
		String sql = "select id from student where cpf = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,cpf);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				 idStudent = rs.getString("id");
			}
			
			return idStudent;
			
		} catch(Exception e){
			
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
			return " ";
	}
	
	/**
	 * Lists and show all the monitors and theirs enrolments
	 * @return ArrayList
	 * @author ViniFarias
	 */
	public List<Person> getMonitorsAndIds(){
		String sql = "SELECT person.namePerson Nome, person.id Matricula FROM monitor "
					+"INNER JOIN student ON monitor.id = student.id "
					+"INNER JOIN person ON student.id = person.id ORDER BY person.namePerson";
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
	 * Show the monitor's timetable, based on the id 
	 * @param id
	 * @return Timetable List
	 */
	public List<TimeTable> getMonitorsTimes(String id){
		String sql = "SELECT timetable.id, timetable.id_monitor, timetable.dayname, timetable.begin_time, "
				+ "timetable.end_time FROM person p INNER JOIN monitor ON p.id = monitor.id INNER JOIN "
				+ "timetable ON monitor.id = timetable.id_monitor WHERE monitor.id = "+id;
		
		try {
			
			List<TimeTable> tb = new ArrayList<TimeTable>();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				MonitorDAO mdao = new MonitorDAO();
				Monitor m = new Monitor();
				
				m = mdao.getMonitorById(rs.getString("id_monitor"));
				
				TimeTable tms = new TimeTable();
				tms.setId(rs.getInt("id"));
				tms.setMonitor(m);
				tms.setDayName(rs.getString("dayname"));
				tms.setBegin_time(rs.getDate("begin_time"));
				tms.setEnd_time(rs.getDate("end_time"));
				
				tb.add(tms);
				
			}
			
			rs.close();
			st.close();
			return tb;
		} catch (SQLException e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
		return null;
	}
	
	/**
	 * Return a list of monitors, with all their informations from another tables
	 * @param id 
	 * @return List of monitors 
	 */
	public List<Monitor> getAllInfoMonitors(){
		String sql = "SELECT p1.*, student.course course, student.grade grade, monitor.id_supervisor idSupervisor, "
				+"p2.namePerson namePersonSupervisor, schoolsubject.namesubject, bankaccount.*, monitor.roomwork "
				+"FROM monitor INNER JOIN student ON monitor.id = student.id INNER JOIN person as p1 "
				+"ON student.id = p1.id INNER JOIN person as p2 ON monitor.id_supervisor = p2.id LEFT JOIN schoolsubject "
				+"ON monitor.id_schoolsubject = schoolsubject.id LEFT JOIN bankaccount ON monitor.id_bankaccount = bankaccount.id "
				+"ORDER BY p1.namePerson";
		
		try {
			
			List<Monitor> tb = new ArrayList<Monitor>();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Monitor m = new Monitor();
				Supervisor supervisor = new Supervisor();
				SchoolSubject ss = new SchoolSubject();
				BankAccount ba = new BankAccount();
				
				m.setId(rs.getString("id"));
				m.setCpf(rs.getString("cpf"));
				m.setBirth_dt(rs.getString("birth_dt"));
				m.setName(rs.getString("namePerson"));
				m.setPassword(rs.getString("password"));
				m.setSex(rs.getString("sex"));
				m.setEmail(rs.getString("email"));
				m.setRg(rs.getString("rg"));
				m.setCourse(rs.getString("course"));
				m.setGrade(rs.getString("grade"));
				
				supervisor.setName(rs.getString("namePersonSupervisor"));
				m.setSupervisor(supervisor);
				
				ss.setName(rs.getString("namesubject"));
				m.setSubject(ss);
				
				ba.setId(rs.getString("id"));
				ba.setAccountNumber(rs.getString("numberaccount"));
				ba.setAgency(rs.getString("agency"));
				ba.setTypeAccount(rs.getString("typeaccount"));
				ba.setNotes(rs.getString("notes"));
				
				m.setBankAccount(ba);
				m.setRoomWork(rs.getString("roomwork"));
				
				tb.add(m);
				
			}
			
			rs.close();
			st.close();
			return tb;
		} catch (SQLException e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
		return null;
	}
	
	
	
	/**
	 * Return all the informations from a monitor based on the id
	 * @param id
	 * @return Monitor
	 */
	public Monitor getMonitorById(String id){
		String sql = "SELECT p1.*, student.course course, student.grade grade, monitor.id_supervisor idSupervisor, "
				+"p2.namePerson namePersonSupervisor, schoolsubject.namesubject, bankaccount.id id_bankaccount, "
				+"bankaccount.numberaccount, bankaccount.agency, bankaccount.notes, bankaccount.typeaccount, monitor.roomwork "
				+"FROM monitor INNER JOIN student ON monitor.id = student.id INNER JOIN person as p1 "
				+"ON student.id = p1.id INNER JOIN person as p2 ON monitor.id_supervisor = p2.id LEFT JOIN schoolsubject "
				+"ON monitor.id_schoolsubject = schoolsubject.id LEFT JOIN bankaccount ON monitor.id_bankaccount = bankaccount.id "
				+"where monitor.id = "+id;
		
		try {
			
			Monitor m = new Monitor();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Supervisor supervisor = new Supervisor();
				SchoolSubject ss = new SchoolSubject();
				BankAccount ba = new BankAccount();
				
				m.setId(rs.getString("id"));
				m.setCpf(rs.getString("cpf"));
				m.setBirth_dt(rs.getString("birth_dt"));
				m.setName(rs.getString("namePerson"));
				m.setPassword(rs.getString("password"));
				m.setSex(rs.getString("sex"));
				m.setEmail(rs.getString("email"));
				m.setRg(rs.getString("rg"));
				m.setCourse(rs.getString("course"));
				m.setGrade(rs.getString("grade"));
				
				supervisor.setName(rs.getString("namePersonSupervisor"));
				m.setSupervisor(supervisor);
				
				ss.setName(rs.getString("namesubject"));
				m.setSubject(ss);
				
				ba.setId(rs.getString("id_bankaccount"));
				ba.setAccountNumber(rs.getString("numberaccount"));
				ba.setAgency(rs.getString("agency"));
				ba.setTypeAccount(rs.getString("typeaccount"));
				ba.setNotes(rs.getString("notes"));
				
				m.setBankAccount(ba);
				m.setRoomWork(rs.getString("roomwork"));
				
				
			}
			
			rs.close();
			st.close();
			return m;
		} catch (SQLException e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
		return null;
	}
	
	/**
	 * Verifies a password and the id of a monitor
	 * @param id
	 * @param password
	 * @return boolean
	 * @author ViniFarias
	 */
	public boolean userChecksMonitor(String id, String password){
		String sql = "SELECT p1.password from monitor INNER JOIN student as s1 ON monitor.id = s1.id "
				+"INNER JOIN person as p1 ON s1.id = p1.id where monitor.id = "+id;
		
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
	 * Verifies if a monitor already exists in the database based on his id
	 * @param id
	 * @param password
	 * @return boolean
	 * @author ViniFarias
	 */
	public boolean userChecksMonitorId(String id, String password){
		String sql = "SELECT p1.id from monitor INNER JOIN student as s1 ON monitor.id = s1.id "
				+"INNER JOIN person as p1 ON s1.id = p1.id where monitor.id = "+id;
		
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
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
			return false;
	}
	
}