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

public class MonitorTest {

	Monitor m1;
	Monitor m2;
	BankAccount b1;
	ManagerActions mact;
	MonitorDAO mdao;
	Supervisor s1;
	SchoolSubject sb1;
	
	@Before
	public void setUp() throws Exception {
		mact = new ManagerActions();
		mdao = new MonitorDAO();
		BankAccount b1 = new BankAccount("7224", "242432423", "12", "nao gosto desse banco");
		Supervisor s1 = new Supervisor("20141204012", "912.236.570-70", "02/03/1999", "Marcus Vinicius de Farias Barbosa", 
				"Aa#Ç~12", "Masculino", "4.123.133", "vinifarias@gmail.com");
		SchoolSubject sb1 = new SchoolSubject("Informatica", "2324");
		
		m1 = new Monitor("311321", "123.145.789-98", Methods.convertStringToSqlString("10/02/1900"), 
				"Thayanne Luiza Victor Landim de Sousa", 
				"52618241", "Feminino", "1.233.789", "thayannevls@gmail.com", "Informatica", "2", sb1, "Sala1", b1, s1);
		
	}

	@Test
	public void testInsertMonitor() {
		try{
			mact.registerMonitor(m1); 			

			assertEquals(mdao.getIdStudent(m1.getCpf()), m1.getId());
		}catch(Exception e){
			e.printStackTrace();
			fail("Não inseriu");
		}
	}

}
