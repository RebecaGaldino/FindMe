package findMe.actions;

import java.text.ParseException;

import findMe.dataBase.BankAccountDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.StudentDAO;
import findMe.dataBase.TimeTableDAO;
import findMe.domain.Monitor;
import findMe.domain.TimeTable;
/**
 * This class provides Monitor Actions using MonitorDAO
 * @author thayanneLuiza
 *
 */
public class MonitorActions {
	
	MonitorDAO mdao = new MonitorDAO();
	StudentDAO sdao = new StudentDAO();
	PersonDAO pdao = new PersonDAO();
	BankAccountDAO badao = new BankAccountDAO();
	TimeTableDAO tdao = new TimeTableDAO();
	
	public MonitorActions() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Update monitor by monitor attributes
	 * @param monitor
	 */
	public void updateMonitor(Monitor monitor){
		mdao.updateMonitor(monitor);
		sdao.updateStudent(monitor);
		pdao.updatePerson(monitor);
		badao.updateBankAccount(monitor.getBankAccount());
	}
	/**
	 * Insert in your own timetable
	 * @param t
	 * @throws ParseException
	 */
	public void insertTimeTable(TimeTable t) throws ParseException{
		tdao.insertTimeTable(t);
	}
	
	public void updateTimeTable(TimeTable t){
		tdao.updateTimeTable(t);
	}
}
