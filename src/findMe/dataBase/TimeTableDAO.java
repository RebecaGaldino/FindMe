package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import findMe.domain.Monitor;
import findMe.domain.Student;
import findMe.domain.TimeTable;
import findMe.extraMethods.Methods;
import javafx.scene.input.DataFormat;

public class TimeTableDAO {

	private Connection conn;
	
	public TimeTableDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/*------------------------INSERT----------------------------*/
	public void insertTimeTable(TimeTable timeTable) throws ParseException {
		String sql = "insert into timetable (id, dayname, begin_time, end_time, id_monitor) values (?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			java.util.Date begin_time = (java.util.Date)formatter.parse(Methods.convertHourToSqlString(timeTable.getBegin_time().toString()));
			java.util.Date end_time = (java.util.Date)formatter.parse(Methods.convertHourToSqlString(timeTable.getEnd_time().toString()));
			
			st.setInt(1, timeTable.getId());
			st.setString(2, timeTable.getDayName());
			st.setDate(3, new java.sql.Date(timeTable.getBegin_time().getTime()));
			st.setDate(4, new java.sql.Date(timeTable.getEnd_time().getTime()));
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
			System.out.println("TimeTable deletada");
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
			st.setDate(3, new java.sql.Date(timetable.getBegin_time().getTime()));
			st.setDate(4, new java.sql.Date(timetable.getEnd_time().getTime()));
			st.setInt(5, timetable.getId());
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
