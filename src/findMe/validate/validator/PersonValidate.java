package findMe.validate.validator;

import findMe.customExceptions.CustomException;
import findMe.domain.Person;

public class PersonValidate {
	
	/**
	 * Validate all attributes on person
	 * @param person
	 * @return
	 * @throws CustomException
	 */
	public static boolean validate(Person person) {
		
		if(!(StringValidator.onlyLetters(person.getName())))
			return false;
		if(!(StringValidator.password(person.getPassword())))
			return false;
		if(!(CpfValidator.validate(person.getCpf())))
			return false;
		if(!(RgValidator.validate(person.getRg())))
			return false;
		if( !(DateValidator.validate((person.getBirth_dt()))))
			return false;
		if( !(EmailValidator.validate((person.getEmail()))))
			return false;
		if( !(NumberValidator.validate((person.getId()))))
			return false;
		
		
		return true;
	}
}
