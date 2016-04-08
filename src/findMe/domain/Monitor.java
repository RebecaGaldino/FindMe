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
		super(id, cpf, birth_dt, name, course, grade, password, sex, rg, email);
		
		setSubject(subject);
		setBankAccount(bankAccount);
		setSupervisor(supervisor);
		setRoomWork(roomWork);
	}
	
	/*---------------------------------------------------------------------------------------------------------*/
	/**
	 * Get monitor's supervisor
	 * @return
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result + ((roomWork == null) ? 0 : roomWork.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		return result;
	}
	
	
	/**
	 * Method that checks whether a monitor is equal to another monitor
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monitor other = (Monitor) obj;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (roomWork == null) {
			if (other.roomWork != null)
				return false;
		} else if (!roomWork.equals(other.roomWork))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		return true;
	}
	
}
