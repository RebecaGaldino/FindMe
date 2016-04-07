package findMe.validate.validator;

import findMe.domain.Supervisor;

/**
 * Validate Supervisor as Person
 * @author thayanneLuiza
 *
 */
public class SupervisorValidator {
	public static boolean validate(Supervisor supervisor){
		if(!PersonValidate.validate(supervisor))
			return false;
		return true;
	}
}
