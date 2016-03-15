package findMe.domain;

import java.sql.Date;

public class Monitor extends Student{
	
	private SchoolSubject subject;
	private Supervisor supervisor;
	private String roomWork;
	private BankAccount bankAccount;
	
	public Monitor(String id, String cpf, Date birth_dt, String name, String course, String year, SchoolSubject subject, String roomWork, BankAccount bankAccount) {
		super(id, cpf, birth_dt, name, course, year);
		setSubject(subject);
		setBankAccount(bankAccount);
		setRoomWork(roomWork);
		setSupervisor(supervisor);
	}
	
	//Cria um monitor com o id do supervisor
	public Monitor(String id, String cpf, Date birth_dt, String name, String course, String year, SchoolSubject subject, String roomWork, BankAccount bankAccount, Supervisor supervisor) {
		super(id, cpf, birth_dt, name, course, year);
		setSubject(subject);
		setBankAccount(bankAccount);
		setSupervisor(supervisor);
	}
	/*---------------------------------------------------------------------------------------------------------*/
	
	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public SchoolSubject getSubject() {
		return subject;
	}

	public void setSubject(SchoolSubject subject) {
		this.subject = subject;
	}

	public String getRoomWork() {
		return roomWork;
	}

	public void setRoomWork(String roomWork) {
		this.roomWork = roomWork;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
	
	
}
