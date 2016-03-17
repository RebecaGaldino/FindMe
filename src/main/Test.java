package main;

import java.text.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.SchoolSubject;

public class Test {
	public static void main(String[] args) throws ParseException {
		
		MonitorDAO mdb = new MonitorDAO();
		
		String inputStr = "11-11-2012";
		
		/*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		DateFormat data = DateFormat.getDateInstance();
		
		Date inputDate = (Date) dateFormat.parse("11-11-2012");*/
		
		SupervisorDAO s = new SupervisorDAO();
		
		
		
		SchoolSubject schoolSubject = new SchoolSubject("info", "123");
		BankAccount bankAccount = new BankAccount("123456", "6538291937", "34", "nao gosto desse banco");
		//Supervisor supervisor = new Supervisor();
		
		Monitor monitor = new Monitor("2014", "1223099", (java.sql.Date) '2014-11-18' , "blouakiss", "Infor", "2º", schoolSubject, "salaNada", bankAccount);
		mdb.insertMonitor(monitor);
		
		//s.insertSupervisor(id, name);
		//Supervisor supervisor = new Supervisor();
		
	}
	
}
