package findMe.domain;

import java.sql.Date;

public class Monitor extends Student{
	
	private SchoolSubject subject;
	
	public Monitor(String id, String cpf, Date birth_dt, String name, String course, String year, SchoolSubject subject) {
		super(id, cpf, birth_dt, name, course, year);
		setSubject(subject);
	}
	
	//Cria um monitor com o id do supervisor
	/*public Monitor(String id, String cpf, Date birth_dt, String name, String course, String year, SchoolSubject subject, supervisor.getId()) {
		super(id, cpf, birth_dt, name, course, year);
		setSubject(subject);
	}*/
	/*---------------------------------------------------------------------------------------------------------*/
	
	public SchoolSubject getSubject() {
		return subject;
	}

	public void setSubject(SchoolSubject subject) {
		this.subject = subject;
	}
	
	
}
