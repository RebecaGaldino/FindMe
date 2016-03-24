package findMe.domain;

import java.util.Date;

public class Manager extends Person {
	
	/**
	 * Manager's constructor
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param password
	 * @param sex
	 * @param email
	 */
	public Manager(String id, String cpf, Date birth_dt, String name, String password, String sex, String rg, String email) {
		super(id, cpf, birth_dt, name, password, sex, rg, email);
	}
	
	/**
	 * Manager's default constructor
	 */
	public Manager(){
		super();
	}

}
