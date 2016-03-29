package findMe.validate.validator;

import findMe.customExceptions.CustomException;
import findMe.domain.Person;

public class PersonValidate {
	public static Boolean validate(Person person) throws CustomException{
		if(!(NameValidate.validate(person.getName())))
			return false;
		if(!(PasswordValidate.validate(person.getPassword())))
			return false;
		if(!(CpfValidator.validate(person.getCpf())))
			return false;
		if(!(RgValidator.validate(person.getRg())))
			return false;
		if(!(DateValidator.validate((person.getBirth_dt()))))
			return false;
		if(!(EmailValidateor.validate((person.getEmail()))))
				return false;
		if(!(IdValidate.validate((person.getId()))))
			return false;
		return true;
	}
}
