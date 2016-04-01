package findMe.actions;

import findMe.dataBase.BankAccountDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.StudentDAO;
import findMe.domain.Monitor;

public class MonitorActions {
	
	MonitorDAO mdao = new MonitorDAO();
	StudentDAO sdao = new StudentDAO();
	PersonDAO pdao = new PersonDAO();
	BankAccountDAO badao = new BankAccountDAO();
	
	public MonitorActions() {
		// TODO Auto-generated constructor stub
	}
	
	public void updateMonitor(Monitor monitor){
		mdao.updateMonitor(monitor);
		sdao.updateStudent(monitor);
		pdao.updatePerson(monitor);
		badao.updateBankAccount(monitor.getBankAccount());
	}
}
