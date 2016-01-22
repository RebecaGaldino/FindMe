package findMe.domain;

import java.sql.Date;

public class Monitor extends Student{
	
	private Subject subject;
	
	public Monitor(String id, String cpf, Date birth_dt, String name,
			String course, String year) {
		super(id, cpf, birth_dt, name, course, year);
	}
	
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
}
