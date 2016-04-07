package findMe.validate.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class EmailValidator {
	
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Format: string + @ + string + .com
	 */
	private static final String EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	
	/**
	 * Validate email on format nameEmail@email.com
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
