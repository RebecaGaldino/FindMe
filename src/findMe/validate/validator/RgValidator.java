package findMe.validate.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class RgValidator {
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
	public static boolean validate(final String name) {
		pattern = Pattern.compile(RG_PATTERN);
		matcher = pattern.matcher(name.trim());
		if(matcher.matches())
			return true;
		return false;
	}
}
