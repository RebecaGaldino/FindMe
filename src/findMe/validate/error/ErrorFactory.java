package findMe.validate.error;

import java.util.HashMap;
import java.util.Map;
/**
 * The Error Factory class has all Custom Exceptions and Error of System, put in all on hash map
 * @author thayanneLuiza
 *
 */
public class ErrorFactory {
	
	private ErrorFactory() {}
	
	/**
	 * Person's Errors
	 */
	
	public static final int CPF_INVALIDO = 1 ;
	public static final int ID_INVALIDO = 2 ;
	public static final int NOME_INVALIDO = 3;
	public static final int RG_INVALIDO = 4;
	public static final int SENHA_INVALIDA = 5;
	public static final int EMAIL_INVALIDO = 6;
	public static final int NASCIMENTO_INVALIDO = 7;
	public static final int REGISTRO_DUPLICADO = 8;
	public static final int PESSOA_INEXISTENTE = 9 ;
	public static final int SEXO_INVALIDO = 10 ;

	
	
	/**
	 * Student's Errors
	 */
	
	public static final int CURSO_INVALIDO = 11;
	public static final int ANO_INVALIDO = 12;
	public static final int ESTUDANTE_DUPLICADO = 13;
	public static final int ESTUDANTE_INEXISTENTE = 14;

	/** 
	 * Monitor's Errors
	 */
	public static final int MATERIA_INVALIDA = 15 ;
	public static final int SUPERVISOR_INVALIDO = 16 ;
	public static final int SALA_INVALIDA = 17;
	public static final int CONTA_BANCARIA_INVALIDA = 18;
	public static final int MONITOR_DUPLICADO = 19;
	public static final int MONITOR_INEXISTENTE = 20;

	
	/** 
	 * Subject's Errors
	 */
	public static final int TITULO_INVALIDO = 21;
	public static final int ID_MATERIA_INVALIDO = 22;
	public static final int MATERIA_DUPLICADA = 23;
	public static final int MATERIA_INEXISTENTE = 24;
	
	/** 
	 * Supervisor's Errors
	 */
	public static final int SUPERVISOR_DUPLICADO = 25;
	public static final int SUPERVISOR_INEXISTENTE = 26;
	
	
	/** 
	 * Bank Account's Errors
	 */
	public static final int ID_CONTA_INVALIDO = 27;
	public static final int	NUMERO_CONTA_INVALIDO = 28 ;
	public static final int AGENCIA_INVALIDA = 29;
	public static final int TIPO_INVALIDO = 30;
	public static final int CONTA_DUPLICADA = 31;
	public static final int CONTA_INEXISTENTE = 32;

	
	/** 
	 * User's Errors
	 */
	public static final int USERNAME_INVALIDO = 33 ;
	public static final int SENHA_USER_INVALIDA = 34;
	public static final int LOGIN_INVALIDO = 35;

	
	
	/** 
	 * Manager's Errors
	 */
	public static final int MANAGER_DUPLICADO = 36;
	public static final int MANAGER_INEXISTENTE = 37;

	
	
	
	/**
	 * Map of errors with codes and messages
	 */
	private static final Map<Integer, String> mapErrors = generateErrorMapping();

	private final static Map<Integer, String> generateErrorMapping() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		/**
		 * Person
		 */
		hashMap.put(CPF_INVALIDO, "CPF inválido.");
		hashMap.put(ID_INVALIDO, "ID inválido.");
		hashMap.put(NOME_INVALIDO,"Nome inválido.");
		hashMap.put(RG_INVALIDO, "RG inválido.");
		hashMap.put(SENHA_INVALIDA, "Senha inválida. Deve conter letras maiúsculas, mínusculas, números, sinais e de 6-20 caracteres.");
		hashMap.put(EMAIL_INVALIDO, "Email inválido.");
		hashMap.put(NASCIMENTO_INVALIDO, "Data de Nascimento inválida.");
		hashMap.put(REGISTRO_DUPLICADO, "Esta pessoa já foi cadastrada.");
		hashMap.put(PESSOA_INEXISTENTE, "Usuário não encontrado.");
		hashMap.put(SEXO_INVALIDO, "Sexo inválido. Deve ser: Feminino ou Masculino.");
		/**
		 * Student
		 */
		hashMap.put(CURSO_INVALIDO, "Curso inválido.");
		hashMap.put(ANO_INVALIDO, "Série inválida.");
		hashMap.put(ESTUDANTE_DUPLICADO, "Este estudante já existe.");
		hashMap.put(ESTUDANTE_INEXISTENTE, "Estudante não encontrado.");

		/**
		 * Monitor
		 */
		hashMap.put(MATERIA_INVALIDA, "Matéria inválida.");
		hashMap.put(SALA_INVALIDA,"Sala de monitoria inválida.");
		hashMap.put(CONTA_BANCARIA_INVALIDA,"Conta bancária inválida.");
		hashMap.put(MONITOR_DUPLICADO, "Monitor já cadastrado.");
		hashMap.put(MONITOR_INEXISTENTE, "Monitor não encontrado.");
		
		/**
		 * Subject
		 */
		hashMap.put(TITULO_INVALIDO,"Nome de matéria inválido.");
		hashMap.put(ID_MATERIA_INVALIDO, "Código da matéria inválido.");
		hashMap.put(MATERIA_DUPLICADA, "Matéria já cadastrada.");
		hashMap.put(MATERIA_INEXISTENTE, "Matéria não encontrada.");
		
		/** 
		 * Supervisor
		 */
		hashMap.put(SUPERVISOR_DUPLICADO, "Supervisor já cadastrado.");
		hashMap.put(SUPERVISOR_INEXISTENTE, "Supervisor não encontrado.");
		
		
		/** 
		 * Bank Account
		 */
		hashMap.put(ID_CONTA_INVALIDO, "ID inválido.");
		hashMap.put(NUMERO_CONTA_INVALIDO, "Número de conta bancária inválido.");
		hashMap.put(AGENCIA_INVALIDA, "Agência bancária inválida.");
		hashMap.put(TIPO_INVALIDO, "Tipo de conta inválido.");
		hashMap.put(CONTA_DUPLICADA, "Conta bancária já cadastrada.");
		hashMap.put(CONTA_INEXISTENTE, "Conta bancária não encontrada.");

		
		/**
		 * User
		 */
		hashMap.put(USERNAME_INVALIDO,"Username inválido.");
		hashMap.put(SENHA_USER_INVALIDA, "Senha inválida.");
		hashMap.put(LOGIN_INVALIDO, "O usuário e senha que você digitou não coincidem.");
		

		/** 
		 * Manager's Errors
		 */
		hashMap.put(MANAGER_DUPLICADO, "Gerente já cadastrado.");
		hashMap.put(MANAGER_INEXISTENTE, "Gerente não encontrado.");
		
		
		return hashMap;
	}
	
public static final Error getErrorFromIndex(int index) {
		
		Error error = new Error();
		error.setCode(index);
		error.setMessage(mapErrors.get(index));
		
		return error;
	}
	
}
