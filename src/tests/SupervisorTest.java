package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import findMe.actions.ManagerActions;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;

public class SupervisorTest {
	
	
	Supervisor s1;
	Supervisor s2;
	ManagerActions mact;
	SupervisorDAO sdao;
		
	
	@Before
	public void setUp() throws Exception {
		s1 = new Supervisor("20141004012", "91223657070", Methods.convertStringToSqlString("02/03/1999"), "Marcus Vinicius de Farias Barbosa", "Aa#Ç~12", "Masculino", "4.123.133", "vinifarias@gmail.com");
		s2 = new Supervisor("20131002016", "18943687090", Methods.convertStringToSqlString("02/06/1997"), "Michelle Machado Tavares da Rocha", "Ba#k~23", "Feminino", "6.353.098", "michellemtr@gmail.com");
		mact = new ManagerActions();
		sdao = new SupervisorDAO();
	
	}

	@Test
	public void testInsertSupervisor() {
		mact.registerSupervisor(s1);
		assertTrue(sdao.getIdPerson(s1.getCpf()) == s1.getId());
	}

	@Test
	public void testDeleteSupervisor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSupervisor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSupervisorsAndIds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInfoAllSupervisors() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllInfoAllSupervisors() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserChecksSupervisor() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserChecksSupervisorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserChecksSupervisorName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSupervisorById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSupervisorByName() {
		fail("Not yet implemented");
	}

}
