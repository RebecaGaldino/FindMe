package main;
import java.text.*;
import java.util.*;
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
		
		
		/*-------------- Subjects and supervisors test (SEM o MAP) --------------- */
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(Person p : s.getSubjectsandSupervisors()){
			
			System.out.println(p.getId()+" "+p.getName());
		}		
		*/
		
		/*-------------- Subjects and monitors test --------------- */
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(Person p : s.getMonitorsofasubject()){
			
			System.out.println(p.getId()+" "+p.getName());
		}		
		*/
		
		/*-------------- Subjects and supervisors test (COM o MAP) --------------- */
		SchoolSubjectDAO s = new SchoolSubjectDAO();
		Map<List<SchoolSubject>,List<Supervisor>> map = s.getSubjectsandSupervisorsMap();
		
		Iterator<Map.Entry<List<SchoolSubject>,List<Supervisor>>> entries = map.entrySet().iterator();
		int i = 0;
		while (entries.hasNext()) {
			
			Map.Entry<List<SchoolSubject>,List<Supervisor>> entry = entries.next();
		   /* System.out.println("Key = ");
		    showSubjects(entry.getKey()); 
		    System.out.println(" Value = ");
		    showSupervisors(entry.getValue()); */
			System.out.println(entry.getKey().get(i).getName() + " " + entry.getValue().get(i).getName());
			i++;
		}
		
	}	
	/* Para ser usado caso vá manualmente e separado 
	public static void showSubjects(List<SchoolSubject> s){
		for(int p = 0; p < s.size(); p++)
			System.out.println("Name: " + s.get(p).getName());
	}
	
	public static void showSupervisors(List<Supervisor> s){
		for(int p = 0; p < s.size(); p++)
			System.out.println("Name: " + s.get(p).getName());
	}
	
	*/
	
	
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