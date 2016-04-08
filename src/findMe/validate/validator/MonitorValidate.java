package findMe.validate.validator;

import findMe.domain.Monitor;
import findMe.validate.validator.StudentValidate;

/**
 * Validate Monitor as person and the others attributes
 * @author thayanneLuiza
 *
 */
public class MonitorValidate {
	/**
	 * Validate Monitor using person validate and student validate
	 * @param monitor
	 * @return
	 */
	public static boolean validate(Monitor monitor) {
		if (!(PersonValidate.validate(monitor)))
			return false;
		if( !(StudentValidate.validate(monitor)))
			return false;
		if( !( BankAccountValidate.validate(monitor.getBankAccount())) )
			return false;
		if(!(StringValidator.onlyLetters(monitor.getRoomWork())))
			return false;
	
		
		
		return true;
		
		
		
	}
}
