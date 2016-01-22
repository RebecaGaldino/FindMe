package findMe.domain;

import java.sql.Date;

public class Student extends Person{
	
	private String course;
	private String year;
	
	public Student(String id, String cpf, Date birth_dt, String name) {
		super(id, cpf, birth_dt, name);
	}
	
	public Student(String id, String cpf, Date birth_dt, String name, String course, String year) {
		super(id, cpf, birth_dt, name);
	}
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
