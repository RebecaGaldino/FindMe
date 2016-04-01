package findMe.validate.validator;

import findMe.customExceptions.CustomException;

/**
 * CPF Validate made by Carlos Caldas
 * Link: https://www.vivaolinux.com.br/script/Codigo-para-validar-CPF-e-CNPJ-otimizado
 * @author thayanneLuiza
 *
 */
public class CpfValidator {
	
	/**
	 * Validate CPF
	 * @param cpf
	 * @return True if is validate, False if is invalid
	 * 
	 */
	public static boolean validate(String cpf) {

	      if(cpf == null || cpf.equals(null))
	    	  return false;
		

	      if(cpf.length() == 14){
	    	  return true;
	      }
	      return false;
	   }
	
}
