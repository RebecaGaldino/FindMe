package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradeValidate {
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
	public static CustomException validate(final String grade) throws CustomException {
		if(grade == null)
			return new CustomException("Preencha a série!");
		
		pattern = Pattern.compile(Grade_PATTERN);
		matcher = pattern.matcher(grade.trim());
		
		if(matcher.matches()){
			return null;
		}
		else
	    	  return new CustomException("Série inválido!");

	}
}
