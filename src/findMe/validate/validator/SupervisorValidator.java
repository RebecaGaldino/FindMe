package findMe.validate.validator;

import findMe.domain.Supervisor;

public class SupervisorValidator {
	public static boolean validate(Supervisor supervisor){
		if(!PersonValidate.validate(supervisor))
			return false;
		return true;
	}
}
