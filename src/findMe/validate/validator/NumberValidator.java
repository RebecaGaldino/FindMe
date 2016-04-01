package findMe.validate.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import findMe.customExceptions.CustomException;

public class NumberValidator {
	private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Accept only numbers
	 */
	private static final String NUMBER_PATTERN = ("[0-9]*");
	
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws CustomException 
	 */
	public static boolean validate(final String number)  {
		pattern = Pattern.compile(NUMBER_PATTERN);
		matcher = pattern.matcher(number.trim());
		if(matcher.matches()){
			return true;
		}
		else
	    	  return false;

	}
	
	public static boolean validate(final String value, int size) {
		
		return(validate(value) && (value.length() == size));
		
	}
	
	public boolean validate(final String value, int tamanhoMenor, 
			int tamanhoMaior) {
		
		return ((validate(value)) && (value.length() >= tamanhoMenor) && (value.length() <= tamanhoMaior));
	}  
}
