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

public class Test {
	public static void main(String[] args) throws ParseException {
		
		MonitorDAO mdb = new MonitorDAO();
		
		
		/*Inserção de Pessoa - OK
		String inputStr = "02/03/2014";
		Date dt;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dt = (java.util.Date)formatter.parse(inputStr);
		PersonDAO p = new PersonDAO();
		SchoolSubject schoolSubject = new SchoolSubject("info", "123");
		BankAccount bankAccount = new BankAccount("123456", "6538291937", "34", "nao gosto desse banco");
		Person person = new Person("2014111", "2174282", dt, "Marcus", "123456");
		p.insertPerson(person);*/
		
		
		/*Inserção de Student - OK
		String inputStr = "01/05/2011";
		Date dt;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dt = (java.util.Date)formatter.parse(inputStr);
        
		StudentDAO p = new StudentDAO();
		Student student = new Student("2014112", "133.222.999-10", dt, "Vinicius", "Mineração", "2", "123456");
		p.insertStudent(student);*/
		
		/*Inserção de Monitor - 
		String inputStr = "01/05/2011";
		Date dt;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dt = (java.util.Date)formatter.parse(inputStr);
		MonitorDAO p = new MonitorDAO();
		SchoolSubject schoolSubject = new SchoolSubject("info", "123");
		BankAccount bankAccount = new BankAccount("123459", "6538291937", "34", "nao gosto desse banco");
		Supervisor supervisor = new Supervisor("20141005", "122.223.345-90", dt, "Joao", "134y248");
		Monitor monitor = new Monitor("2014119", "133.222.999-10", dt, "Vinicius", "Mineração", "2", schoolSubject, "Sala2", bankAccount, supervisor, "1443422");
		p.insertMonitor(monitor);*/
		
		
		
		
		/*Inserção de Monitor - 
		String inputStr = "01/05/2011";
		Date dt;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dt = (java.util.Date)formatter.parse(inputStr);
		MonitorDAO p = new MonitorDAO();
		SchoolSubject schoolSubject = new SchoolSubject("info", "123");
		BankAccount bankAccount = new BankAccount("123435", "6538299037", "14", "nao gosto desse banco");
		Supervisor supervisor = new Supervisor("20141009", "122.223.345-90", dt, "Joao", "134y248");
		Monitor monitor = new Monitor("2014115", "133.222.999-10", dt, "Abathur", "Informatica", "2", schoolSubject, "Sala2", bankAccount, supervisor, "1443422");
		p.insertMonitor(monitor);*/
		
		/*MonitorDAO p = new MonitorDAO();
		p.deleteMonitor("2014112");*/
		
		/*Delete Person - OK
		PersonDAO p = new PersonDAO();
		p.deletePerson("2014112");*/
		
		/*------------------------------------------------------------*/
		MonitorDAO m = new MonitorDAO();
		for(Person p : m.getMonitoresAndIds()){
			
			System.out.println(p.getId()+" "+p.getName());
			
		}
		
		//Teste do checksId
		/*PersonDAO p = new PersonDAO();
		if(p.checksId("20102001039")){
			System.out.println("S");
		}
		else{
			System.out.println("N");
		}*/
		
		//Teste do checksNameSubject
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		if(s.checksNameSubject("Fisica")){
			System.out.println("S");
		}
		else{
			System.out.println("N");
		}*/
		
	}
	
}
