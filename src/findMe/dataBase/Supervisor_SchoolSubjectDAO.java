package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import findMe.domain.Person;
import findMe.domain.Supervisor_SchoolSubject;

public class Supervisor_SchoolSubjectDAO {
	
private Connection conn;
	
	public Supervisor_SchoolSubjectDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/*------------------------INSERT----------------------------*/
	/**
	 * Insert Supervisor_SchoolSubject on data base
	 * @param supervisor_SchoolSubject
	 * @throws SQLException sql's exception
	 */
	public void insertSupervisor_SchoolSubject(Supervisor_SchoolSubject supervisor_SchoolSubject) {
		String sql = "insert into supervisor_schoolsubject ( id_supervisor, id_schoolsubject) values (?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, supervisor_SchoolSubject.getSupervisor().getId());
			st.setString(2, supervisor_SchoolSubject.getSchoolSubject().getId());
			
			st.execute();
			st.close();
			System.out.println("Relacionamento cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	/**
	 * Method that excludes a Supervisor_SchoolSubject of the database
	 * @param id
	 * @throws SQLException sql's exception
	 */ 
	public void deleteSupervisor_SchoolSubject(int id) {
		String sql = "delete from supervisor_schoolsubject where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, id);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*------------------------UPDATE----------------------------*/
	/**
	 * Updates the information of a Supervisor_SchoolSubject
	 * @param supervisor_SchoolSubject
	 * @throws SQLException sql's exception
	 */
	public void updateSupervisor_SchoolSubject(Supervisor_SchoolSubject supervisor_SchoolSubject) {
		String sql = "update supervisor_schoolsubject set id_supervisor = ?, id_schoolsubject = ? where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, supervisor_SchoolSubject.getSupervisor().getId());
			st.setString(2, supervisor_SchoolSubject.getSchoolSubject().getId());
			st.setInt(3, supervisor_SchoolSubject.getId());
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
