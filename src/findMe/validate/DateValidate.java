package findMe.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidate {
public static final String FORMATO_DATA = "dd/MM/yyyy";
	
	public static final int ANO_ZERO = 0;

	public static boolean validate(final String value) throws CustomException {

		if (value == null || value.trim().equals(""))
			return false;


		try {
			
			SimpleDateFormat format = new SimpleDateFormat(FORMATO_DATA);
			format.setLenient(false);
			format.parse(value.trim());
			
		} catch (ParseException e) {
			
			throw new CustomException("Data inválida!");
		}

		return true;
	}
}
