package findMe.actions;

import findMe.dataBase.BankAccountDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.StudentDAO;
import findMe.dataBase.TimeTableDAO;
import findMe.domain.Monitor;
import findMe.domain.TimeTable;

public class MonitorActions {
	
	MonitorDAO mdao = new MonitorDAO();
	StudentDAO sdao = new StudentDAO();
	PersonDAO pdao = new PersonDAO();
	BankAccountDAO badao = new BankAccountDAO();
	TimeTableDAO tdao = new TimeTableDAO();
	
	public MonitorActions() {
		// TODO Auto-generated constructor stub
	}
	
	public void updateMonitor(Monitor monitor){
		mdao.updateMonitor(monitor);
		sdao.updateStudent(monitor);
		pdao.updatePerson(monitor);
		badao.updateBankAccount(monitor.getBankAccount());
	}
	
	public void insertTimeTable(TimeTable t){
		tdao.insertTimeTable(t);
	}
	
	public void updateTimeTable(TimeTable t){
		tdao.updateTimeTable(t);
	}
}
