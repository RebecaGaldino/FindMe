package findMe.domain;

import java.util.Date;

public class TimeTable {
	private int id;
	private String dayName;
	private Date begin_time;
	private Date end_time;
	private Monitor monitor;
	
	public TimeTable(int id, String dayName, Date begin_time, Date end_time, Monitor monitor) {
		setId(id);
		setDayName(dayName);
		setBegin_time(begin_time);
		setEnd_time(end_time);
		setMonitor(monitor);
	}
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public int getId() {
		return id;
	}
	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDayName() {
		return dayName;
	}
	
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public Date getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
}
