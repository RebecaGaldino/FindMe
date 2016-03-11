package findMe.domain;

public class BankAccount {
	private String id;
	private String accountNumber;
	private String agency;
	private String notes;
	
	public BankAccount(String id, String accountNumber, String agency, String notes){
		setId(id);
		setAccountNumber(accountNumber);
		setAgency(agency);
		setNotes(notes);
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
