package findMe.domain;

import java.sql.Date;

public class Monitor extends Student{
	
	private SchoolSubject subject;
	private Supervisor supervisor;
	private String roomWork;
	private BankAccount bankAccount;
	/**
	 * 
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param course
	 * @param year
	 * @param subject
	 * @param roomWork
	 * @param bankAccount
	 * @param password
	 */
	public Monitor(String id, String cpf, Date birth_dt, String name, String course, String year, SchoolSubject subject, String roomWork, BankAccount bankAccount, String password) {
		super(id, cpf, birth_dt, name, course, year, password);
		setSubject(subject);
		setBankAccount(bankAccount);
		setRoomWork(roomWork);
		
	}
	
	/**
	 * Constructor with Supervisor ID
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param course
	 * @param year
	 * @param subject
	 * @param roomWork
	 * @param bankAccount
	 * @param supervisor
	 * @param password
	 */
	public Monitor(String id, String cpf, Date birth_dt, String name, String course, String year, SchoolSubject subject, String roomWork, BankAccount bankAccount, Supervisor supervisor, String password) {
		super(id, cpf, birth_dt, name, course, year, password);
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
