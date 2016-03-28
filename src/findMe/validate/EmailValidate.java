package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class EmailValidate {
	
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Format: string + @ + string + .com
	 */
	private static final String EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws CustomException 
	 */
	public static CustomException validate(final String email) throws CustomException {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email.trim());
		if(matcher.matches()){
			return null;
		}
		else
	    	  return new CustomException("Email inválido!");

	}
			
			
}
