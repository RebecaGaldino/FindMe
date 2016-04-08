package tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import findMe.actions.ManagerActions;
import findMe.actions.SupervisorActions;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
import findMe.validate.validator.SupervisorValidator;

public class SupervisorTest {
	
	
	Supervisor s1;
	Supervisor s2;
	ManagerActions mact;
	SupervisorActions sact;
	SupervisorDAO sdao;
		
	
	@Before
	public void setUp() throws Exception {
		s1 = new Supervisor("20141004012", "912.236.570-70", "02/03/1999", "Marcus Vinicius de Farias Barbosa", 
				"Aa#Ç~12", "Masculino", "4.123.133", "vinifarias@gmail.com");
		s2 = new Supervisor("20131002016", "18943687090", "02/06/1997", "Michelle Machado Tavares da Rocha", "Ba#k~23", "Feminino", "6.353.098", "michellemtr@gmail.com");
		mact = new ManagerActions();
		sact = new SupervisorActions();
		sdao = new SupervisorDAO();
	
	}

	@Test
	public void testInsertSupervisor() throws ParseException {
		try{
			if(SupervisorValidator.validate(s1)){
				String dt = s1.getBirth_dt();
				s1.setBirth_dt(Methods.convertStringToSqlString(dt));
				mact.registerSupervisor(s1);
				assertEquals(sdao.getIdPerson(s1.getCpf()), s1.getId());
			}
			else{
				assertTrue(false);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	
	}
	
	
	@Test
	public void testUpdateSupervisor() {
		Supervisor saux = sdao.getSupervisorById(s1.getId());
		saux.setName("Marcus Vinicius");
		
		sact.editSupervisor(saux);
		assertEquals(sdao.getIdPerson(s1.getCpf()), s1.getId());
	}
	
	
	@Test
	public void testDeleteSupervisor() {
		mact.deleteSupervisor(s1);
		assertFalse(sdao.getIdPerson(s1.getCpf()).equals(s1.getId()));
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

}
