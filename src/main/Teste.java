package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {
	
	public static void Main(String[] args){
		if(validate("thay102"))
			System.out.println("foi");
	}
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
	 */
	
	 
	public static boolean validate(final String name){
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher(name.trim());
		return matcher.matches();
	}

}
