package main;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.PersonDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Person;
import findMe.domain.Supervisor;

public class Test {
	public static void main(String[] args) throws ParseException {
		PersonDAO mdb = new PersonDAO();
		String inputStr = "11-11-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse("11-11-2012");
		SupervisorDAO s = new SupervisorDAO();
		
		Person monitor = new Person("202020", "083.738.794-98", inputDate, "thayanne");
		mdb.insertPerson(person);
		
		//s.insertSupervisor(id, name);
		//Supervisor supervisor = new Supervisor();
		
	}
	
}
