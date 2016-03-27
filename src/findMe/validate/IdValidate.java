package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static boolean validate(final String id) throws CustomException {
		pattern = Pattern.compile(Id_PATTERN);
		matcher = pattern.matcher(id.trim());
		if(matcher.matches()){
			return true;
		}
		else
	    	  throw new CustomException("Id inválido!");

	}
}
