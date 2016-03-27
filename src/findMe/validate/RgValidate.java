package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RgValidate {
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 *Pattern with only letters 
	 */
	
	private static final String RG_PATTERN = "[0-9]{1}?\\.[0-9]{3}?\\.[0-9]{3}?";
	/**
	 * 
	 * @param name
	 * @return
	 * @throws CustomException 
	 */
	public static CustomException validate(final String name) throws CustomException{
		pattern = Pattern.compile(RG_PATTERN);
		matcher = pattern.matcher(name.trim());
		if(matcher.matches())
			return null;
		else
	    	  return new CustomException("RG inválido!");
	}
}