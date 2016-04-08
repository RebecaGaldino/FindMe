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
	public Student(String id, String cpf, String birth_dt, String name, String course, String grade, String password, String sex, String rg, String email) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		return result;
	}
	
	
	/**
	 * Method that checks whether a student is equal to another student
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}
}
