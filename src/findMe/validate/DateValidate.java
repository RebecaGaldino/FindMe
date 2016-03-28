package findMe.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.customExceptions.CustomException;

public class DateValidate {
public static final String FORMATO_DATA = "dd/MM/yyyy";
	
	public static final int ANO_ZERO = 0;

	public static CustomException validate(final String value) throws CustomException {

		if (value == null || value.trim().equals(""))
			return new CustomException("Preencha este campo!");


		try {
			
			SimpleDateFormat format = new SimpleDateFormat(FORMATO_DATA);
			format.setLenient(false);
			format.parse(value.trim());
			
		} catch (ParseException e) {
			
			return new CustomException("Data inválida!");
		}

		return null;
	}
}
