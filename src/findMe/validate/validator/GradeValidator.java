package findMe.validate.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class GradeValidator {
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Accept only numbers
	 */
	private static final String Grade_PATTERN = ("[1-3]*");
	
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws CustomException 
	 */
	public static boolean validate(final String grade) {
		if(grade == null)
			return false;
		
		pattern = Pattern.compile(Grade_PATTERN);
		matcher = pattern.matcher(grade.trim());
		
		if(matcher.matches()){
			return true;
		}
		return false;

	}
}
