package findMe.domain;

import java.util.Date;

public class Monitor extends Student{
	
	private SchoolSubject subject;
	private Supervisor supervisor;
	private String roomWork;
	private BankAccount bankAccount;
	
	
	/**
	 * Monitor's default constructor
	 */
	public Monitor(){
		super();
		setSubject(subject);
		setSupervisor(supervisor);
		setRoomWork("0");
		setBankAccount(bankAccount);
	}
	
	/**
	 * Monitor's constructor
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param password
	 * @param sex
	 * @param rg
	 * @param email
	 * @param course
	 * @param grade
	 * @param subject
	 * @param roomWork
	 * @param bankAccount
	 * @param supervisor
	 */
	public Monitor(String id, String cpf, String birth_dt, String name, String password, String sex, String rg, String email, String course, String grade, SchoolSubject subject, String roomWork, BankAccount bankAccount, Supervisor supervisor) {
		super(id, cpf, birth_dt, name, password, sex, rg, email, course, grade);
		setSubject(subject);
		setBankAccount(bankAccount);
		setSupervisor(supervisor);
		setRoomWork(roomWork);
	}
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public Supervisor getSupervisor() {
		if( supervisor == null){
			return null;
		}
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
