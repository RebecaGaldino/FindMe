package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import findMe.actions.ManagerActions;
import findMe.dataBase.MonitorDAO;
import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
import findMe.validate.validator.MonitorValidate;
import findMe.validate.validator.NumberValidator;
import findMe.validate.validator.StringValidator;

public class MonitorValidatorTest {
	Monitor m1;
	Monitor m2;
	BankAccount b1;
	ManagerActions mact;
	MonitorDAO mdao;
	Supervisor s1;
	SchoolSubject sb1;
	
	@Before
	public void setUp() throws Exception {
		BankAccount b1 = new BankAccount("2121","31114", "242432423", "12", "nao gosto desse banco");
		Supervisor s1 = new Supervisor("20122003011", "912.236.570-70", "02/03/1999", "Marcus Vinicius de Farias Barbosa", 
				"Aa#Ç~12", "Masculino", "4.123.133", "vinifarias@gmail.com");
		SchoolSubject sb1 = new SchoolSubject("Informatica", "122");
		
		b1.setId(b1.getAccountNumber());
		
		m1 = new Monitor("3111", "123.145.789-98", "10/02/1900", 
				"Thayanne Luiza Victor Landim de Sousa", 
				"52618241", "Feminino", "1.233.789", "thayannevls@gmail.com", "Informatica", "2", sb1, "Sala", b1, s1);
	}

	@Test
	public void testMonitorValidator() {
		
		assertTrue(MonitorValidate.validate(m1));
	}
	@Test
	public void testMonitorGrade(){
		assertTrue(NumberValidator.validate(m1.getGrade()));
	}
	@Test
	public void testMonitorCourse(){
		assertTrue(StringValidator.onlyLetters(m1.getCourse()));
	}
	
	
}
