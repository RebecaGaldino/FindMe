package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidate {
	
	private Pattern patternPassword;
	private Matcher matcher;
	/**
	 * Formart: Lower case, Upper case, letters, symbols and numbers
	 */
	private static final String PASSWORD_PATTERN = "([0-9])([a-z])([A-Z]).{6,25}";
	
	public boolean validate(final String password) throws CustomException {
		if (password == null || password.trim().equals(""))
			return false;
		matcher = patternPassword.matcher(password);
		if(matcher.matches())
			return true;
		else
	    	  throw new CustomException("Senha inválida!");
	}
}
