package findMe.domain;

import java.util.Date;

/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class Student extends Person{
	
	private String course;
	private String grade;
	
	
	
	public Student(String id, String cpf, Date birth_dt, String name, String course, String grade, String password) {
		super(id, cpf, birth_dt, name, password);
		setCourse(course);
		setGrade(grade);
	}
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
