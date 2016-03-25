package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidate {
	
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Formart: Lower case, Upper case, letters, symbols and numbers
	 */
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	public static boolean validate(final String password) throws CustomException {
		if (password == null || password.trim().equals(""))
			return false;
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		if(matcher.matches())
			return true;
		else
	    	  throw new CustomException("Senha inválida!");
	}
}
