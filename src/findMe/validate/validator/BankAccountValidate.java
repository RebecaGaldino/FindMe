package findMe.validate.validator;

import findMe.domain.BankAccount;

public class BankAccountValidate {
	/**
	 * Validate BankAccount
	 * @param bankAccount
	 * @return true if is validate, false if is invalid
	 */
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
