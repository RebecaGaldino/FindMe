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

public class TestVini {
	public static void main(String[] args) throws ParseException {
		
		
		
		/*----------------Teste getMonitorsAndIds-----------------------*/
		/*MonitorDAO m = new MonitorDAO();
		for(Person p : m.getMonitorsAndIds()){
			
			System.out.println(p.getName()+" "+p.getId());
		
		}*/
		
		
		
		/*-----------------Teste do checksId----------------------------*/
		/*PersonDAO p = new PersonDAO();
		if(p.checksId("20102001039")){
			System.out.println("S");
		}
		else{
			System.out.println("N");
		}*/
		
		
		
		/*------------------Teste do checksNameSubject------------------*/
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		if(s.checksNameSubject("Fisica")){
			System.out.println("S");
		}
		else{
			System.out.println("N");
		}*/
		
		
		
		/*-----------Teste convertStringToSqlString---------------------*/
		/*String inputStr = "02/03/2014";
		
		PersonDAO p = new PersonDAO();
		Person person = new Person("20141009157", "2174282", convertStringToSqlString(inputStr), "Marcus", "123456", "Masculino", "4.112.544", "example@example.com");
		p.insertPerson(person);*/
		
		
		/*-----------Teste userChecks-----------------------------------*/
		/*PersonDAO p = new PersonDAO();
		if(p.userChecks("20192001040", "easperinhas")){
			System.out.println("S");
		}
		else{
			System.out.println("N");
		}*/
		
		
		
		/*----------------Teste getSupervisorsAndIds-----------------------*/
		/*SupervisorDAO s = new SupervisorDAO();
		for(Person p : s.getSupervisorsAndIds()){
			System.out.println(p.getName()+" "+p.getId());
		}*/
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
