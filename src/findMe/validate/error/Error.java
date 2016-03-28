package findMe.validate.error;

public class Error {
	private int code;
	
	private String message;

	
	public Error() { }
	/**
	 * 
	 *  Construtor da classe, que contém todos os seus atributos 
	 *  
	 *  @param codigo
	 * @param mensagem
	 * 
	 */
	public Error(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
