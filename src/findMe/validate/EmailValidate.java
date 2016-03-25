package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static boolean validate(final String email) throws CustomException {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email.trim());
		if(matcher.matches()){
			return true;
		}
		else
	    	  throw new CustomException("Email inválido!");

	}
			
			
}
