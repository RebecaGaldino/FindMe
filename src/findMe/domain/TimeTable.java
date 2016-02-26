package findMe.domain;

import java.sql.Date;

public class TimeTable {
	private int id;
	private String dayName;
	private Date begin;
	private Date end;
	// private Monitor monitor;  --> Colocamos?
	
	
	
	
	/*---------------------------------------------------------------------------------------------------------*/

	public int getId() {
		return id;
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
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
}
