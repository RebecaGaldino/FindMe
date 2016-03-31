package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

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
	
	/*------------------------INSERT----------------------------*/
	public void insertMonitor(Monitor monitor) {
	
		String sql = "insert into monitor (id, id_schoolsubject, id_supervisor, roomwork, id_bankaccount) values (?, ?, ?, ?, ?)";
		try {
			
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
			System.out.println("Monitor cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	public void deleteMonitor(String id) {
		String sql = "delete from monitor where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
			System.out.println("Monitor deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*------------------------UPDATE----------------------------*/
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
			System.out.println("Monitor atualizado com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			
			System.out.println("Exception is :"+e);
		}
			return " ";
	}
	
	/**
	 * Lista e exibe todos os monitores e suas matrículas
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
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	
	public List<TimeTable> getMonitorsTimes(String id){
		String sql = "	SELECT timetable.dayname DayName, timetable.begin_time BeginTime, timetable.end_time EndTime "
						+"FROM person p INNER JOIN monitor ON p.id = monitor.id "
						+"INNER JOIN timetable ON monitor.id = timetable.id_monitor "
						+"WHERE monitor.id = "+id;
		
		try {
			
			List<TimeTable> tb = new ArrayList<TimeTable>();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				TimeTable tms = new TimeTable();
				tms.setDayName(rs.getString("DayName"));
				tms.setBegin_time(rs.getDate("BeginTime"));
				tms.setEnd_time(rs.getDate("EndTime"));
				
				tb.add(tms);
				
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
	 * Retorna uma lista de monitores, com todas as suas informações relacionadas com outras tabelas
	 * @param id
	 * @return
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
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Verifica a senha e id do usuário Monitor
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
			System.out.println(e.getMessage());
		}
			return false;
	}
	
	
	
	
	/**
	 * Verifica se um monitor ja existe no bd a partir do id
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
			System.out.println(e.getMessage());
		}
			return false;
	}
	
}