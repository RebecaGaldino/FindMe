package findMe.validate.validator;

import findMe.customExceptions.CustomException;

/**
 * CPF Validate made by Carlos Caldas
 * Link: https://www.vivaolinux.com.br/script/Codigo-para-validar-CPF-e-CNPJ-otimizado
 * @author thayanneLuiza
 *
 */
public class CpfValidator {
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};	
		
	
	private static int calcularDigito(String str, int[] peso) {
	      int soma = 0;
	      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
	         digito = Integer.parseInt(str.substring(indice,indice+1));
	         soma += digito*peso[peso.length-str.length()+indice];
	      }
	      soma = 11 - soma % 11;
	      return soma > 9 ? 0 : soma;
	  }

	/**
	 * Validate CPF
	 * @param cpf
	 * @return True if is validate, False if is invalid
	 * 
	 */
	public static boolean validate(String cpf) {
	      
	
	      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
	      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
	      if(cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString()))
	    	  return true;
	      else
	    	  return false;
	   }
	
}
