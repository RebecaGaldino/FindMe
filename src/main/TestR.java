package main;
import java.text.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.StudentDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Student;
import findMe.domain.Supervisor;

public class TestR {
	public static void main(String[] args) throws ParseException {
		
		/**
		 * SchoolSubject and Manager tests
		 * @author Rebeca Galdino 
		 */
		/*---------------Subjects' names test--------------------------*/
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(SchoolSubject ss : s.getSubjectsnames()){
			System.out.println(ss.getName());
		}*/
		
		
		/*-------------- Subjects and supervisors test --------------- */
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(Person p : s.getSubjectsandSupervisors()){
			
			System.out.println(p.getId()+" "+p.getName());
		}		
		*/
		
		/*-------------- Subjects and supervisors test --------------- */
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(Person p : s.getMonitorsofasubject()){
			
			System.out.println(p.getId()+" "+p.getName());
		}		
		*/
		
	
	}
	
	
	/**
	 * Convert a string (dd/mm/yyy) to sql string (yyyy-mm-dd)
	 * @param input
	 * @return
	 * @throws ParseException
	 * @author ViniFarias
	 */
	public static String convertStringToSqlString(String input) throws ParseException{
		Date dtJava;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dtJava = (java.util.Date)formatter.parse(input);
		
		java.sql.Date date = new java.sql.Date(dtJava.getTime());
		
		String dtSql = (String)date.toString();
		
		return dtSql;
	}
}