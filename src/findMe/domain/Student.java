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
	
	/**
	 * Student's default constructor
	 */
	public Student(){
		super();
		setCourse("0");
		setGrade("0");
	}
	
	/**
	 * Student's constructor
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param course
	 * @param grade
	 * @param password
	 * @param sex
	 * @param rg
	 * @param email
	 */
	public Student(String id, String cpf, Date birth_dt, String name, String course, String grade, String password, String sex, String rg, String email) {
		super(id, cpf, birth_dt, name, password, sex, rg, email);
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
