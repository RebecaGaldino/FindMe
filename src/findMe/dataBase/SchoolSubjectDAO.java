package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import findMe.domain.Person;
import findMe.domain.SchoolSubject;

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
	 * Verifica se existe uma disciplina cadastrada com determinado nome no banco
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
	
}
