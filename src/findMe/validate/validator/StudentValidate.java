package findMe.validate.validator;

import findMe.domain.Monitor;
import findMe.domain.Student;

public class StudentValidate {
	/**
	 * Validate student as person and the course and grade
	 * @param student
	 * @return
	 */
	public static boolean validate(Student student) {
		if( !(PersonValidate.validate(student)))
			return false;
		if(!(StringValidator.onlyLetters(student.getCourse())))
			return false;
		if(!(NumberValidator.validate(student.getGrade())))
			return false;
		
		return true;
	}
}
