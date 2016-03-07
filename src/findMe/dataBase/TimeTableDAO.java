package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import findMe.domain.Monitor;
import findMe.domain.Student;
import findMe.domain.TimeTable;

public class TimeTableDAO {

	private Connection conn;
	
	public TimeTableDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/*------------------------INSERT----------------------------*/
	public void insertTimeTable(TimeTable timeTable) {
		String sql = "insert into timetable (id, dayname, begin_time, end_time, id_monitor) values (?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, timeTable.getId());
			st.setString(2, timeTable.getDayName());
			st.setDate(3, timeTable.getBegin_time());
			st.setDate(4, timeTable.getEnd_time());
			st.setString(5, timeTable.getMonitor().getId());
			
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*------------------------DELETE----------------------------*/
	public void deleteTimeTable(int id) {
		String sql = "delete from timetable where id = ?";
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
	public void updateTimeTable(TimeTable timetable) {
		String sql = "update timetable set id_monitor = ?, dayname = ?, begin_time = ?, end_time = ? where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, timetable.getMonitor().getId());
			st.setString(2, timetable.getDayName());
			/*st.setString(3, timetable.getBegin_time());
			st.setString(3, timetable.getEnd_time());*/
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
