package findMe.domain;

import java.sql.Date;
/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class Supervisor extends Person{

	public Supervisor(String id, String cpf, Date birth_dt, String name, String password) {
		super(id, cpf, birth_dt, name, password);
	}
	
	
}
