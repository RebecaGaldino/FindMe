package findMe.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import findMe.domain.Monitor;
import findMe.domain.TimeTable;

public class TimeTableDAO {

	private Connection conn;
	
	public TimeTableDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");
		
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
}
