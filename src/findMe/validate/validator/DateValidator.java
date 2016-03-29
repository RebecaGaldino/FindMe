package findMe.validate.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.customExceptions.CustomException;

public class DateValidator {
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	

	public static final int ANO_ZERO = 0;



	public static boolean validate(final String value) {
	
		if (value == null || value.trim().equals(""))
			return false;
	
		boolean valido = true;
	
		try {
			
			SimpleDateFormat format = new SimpleDateFormat(FORMATO_DATA);
			format.setLenient(false);
			format.parse(value.trim());
			
		} catch (ParseException e) {
			
			valido = false;
		}
	
		return valido;
	}
}
