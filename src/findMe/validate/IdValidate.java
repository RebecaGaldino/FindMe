package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class IdValidate {
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Accept only numbers
	 */
	private static final String Id_PATTERN = ("[0-9]*");
	
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws CustomException 
	 */
	public static CustomException validate(final String id) throws CustomException {
		pattern = Pattern.compile(Id_PATTERN);
		matcher = pattern.matcher(id.trim());
		if(matcher.matches()){
			return null;
		}
		else
	    	  return new CustomException("Id inválido!");

	}
}
