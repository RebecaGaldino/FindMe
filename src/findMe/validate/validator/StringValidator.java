package findMe.validate.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class StringValidator {
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Formart: Lower case, Upper case, letters, symbols and numbers
	 */
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	
	private static final String LETTERS_PATTERN = "[a-zA-ZáàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ. ]*";
	 
	/**
	 * Validate name with LETTERS_Pattern
	 * @param name
	 * @return
	 * @throws CustomException 
	 */
	public static boolean onlyLetters(final String text) {
		
		
		pattern = Pattern.compile(LETTERS_PATTERN);
		matcher = pattern.matcher(text.trim());
		
		if(matcher.matches())
			return true;
		else
	    	  return false;

	}
	
	/**
	 * Validate with PASSWORD_PATTERN
	 * @param password
	 * @return
	 * @throws CustomException
	 */
	public static boolean password(final String password)  {
		
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		if(matcher.matches())
			return true;
		else
	    	  return false;
	}
}
