package findMe.domain;

import java.util.Date;
/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class Supervisor extends Person{
	
	/**
	 * Supervisor's default constructor
	 */
	public Supervisor(){
		super();
	}
	
	/**
	 * Supervisor's constructor
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param password
	 * @param sex
	 * @param rg
	 * @param email
	 */
	public Supervisor(String id, String cpf, String birth_dt, String name, String password, String sex, String rg, String email) {
		super(id, cpf, birth_dt, name, password, sex, rg, email);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
