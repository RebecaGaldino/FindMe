package main;

import java.text.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;

public class Test {
	public static void main(String[] args) throws ParseException {
		
		MonitorDAO mdb = new MonitorDAO();
		
		String inputStr = "02/03/2014";
		
		Date dt;
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dt = (java.util.Date)formatter.parse(inputStr);
		
		SupervisorDAO s = new SupervisorDAO();
		PersonDAO p = new PersonDAO();
		
		
		
		SchoolSubject schoolSubject = new SchoolSubject("info", "123");
		BankAccount bankAccount = new BankAccount("123456", "6538291937", "34", "nao gosto desse banco");
		Person person = new Person("2014111", "2174282", dt, "Marcus", "123456");
		p.insertPerson(person);
		
		
	}
	
}
