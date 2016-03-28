package findMe.validate;

import findMe.customExceptions.CustomException;
import findMe.domain.Person;

public class PersonValidate {
	public static Boolean validate(Person person) throws CustomException{
		if(!(NameValidate.validate(person.getName())))
			return false;
		if(!(PasswordValidate.validate(person.getPassword())))
			return false;
		if(!(CpfValidate.validate(person.getCpf())))
			return false;
		if(!(RgValidate.validate(person.getRg())))
			return false;
		if(!(DateValidate.validate((person.getBirth_dt()))))
			return false;
		if(!(EmailValidate.validate((person.getEmail()))))
				return false;
		if(!(IdValidate.validate((person.getId()))))
			return false;
		return true;
	}
}
