package findMe.validate.validator;

import findMe.domain.BankAccount;

public class BankAccountValidate {
	public static boolean validate(BankAccount bankAccount){
		if(!(NumberValidator.validate(bankAccount.getId())))
			return false;
		if(!(NumberValidator.validate(bankAccount.getAccountNumber()) ))
			return false;
		if(!(NumberValidator.validate(bankAccount.getTypeAccount())))
			return false;
		if(!(StringValidator.onlyLetters(bankAccount.getNotes())))
			return false;
		return true;
	}
}
