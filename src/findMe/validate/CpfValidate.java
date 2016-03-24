package findMe.validate;

public class CpfValidate {

		/**
		 * Cpf validate
		 * @param cpf
		 * @return boolean validation
		 */
		public static boolean ifCpf (String cpf )
	   {

			String aux = cpf.substring(0, 2) + cpf.substring(3, 6) + cpf.substring(7, 10) + cpf.substring(11, 15);

			int[] multi1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
			int sum = 0;

			for (int i = 1; i < 13; i++) {
				sum += multi1[i - 1] * Integer.parseInt(aux.substring(i - 1, i));
			}

			if (sum % 11 < 2) {
				aux += "0";
			} else {
				aux += String.format("%d", 11 - (sum % 11));
			}

			int[] multi2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
			sum = 0;

			for (int i = 1; i < 14; i++) {
				sum += multi2[i - 1] * Integer.parseInt(aux.substring(i - 1, i));
			}

			if (sum % 11 < 2) {
				aux += "0";
			} else {
				aux += String.format("%d", 11 - (sum % 11));
			}

			if (aux.charAt(aux.length() - 1) == cpf.charAt(cpf.length() - 1)
					&& aux.charAt(aux.length() - 2) == cpf.charAt(cpf.length() - 2)) {
				return true;
			}

			return false;
		}
	
}
