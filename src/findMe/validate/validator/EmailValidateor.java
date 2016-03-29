package findMe.validate.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class EmailValidateor {
	
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
	public static boolean validate(final String email)  {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email.trim());
		if(matcher.matches())
			return true;
		
		return false;

	}
			
			
}
