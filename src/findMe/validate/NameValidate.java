package findMe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class NameValidate {
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 *Pattern with only letters 
	 */
	
	private static final String NAME_PATTERN = "[a-zA-ZáàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ]*";
	
	/**
	 * Validate name with Name_Pattern
	 * @param name
	 * @return
	 * @throws CustomException 
	 */
	public static CustomException validate(final String name) throws CustomException{
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher(name.trim());
		if(matcher.matches())
			return null;
		else
	    	  return new CustomException("Nome inválido!");

	}
}
