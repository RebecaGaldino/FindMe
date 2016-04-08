package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import findMe.actions.ManagerActions;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
import findMe.validate.validator.SupervisorValidator;

public class SchoolSubjectTest {
	
	SchoolSubject sb1;
	SchoolSubject sb2;
	ManagerActions mact;
	SchoolSubjectDAO ssdao;
	
	
	@Before
	public void setUp() throws Exception {
		sb1 = new SchoolSubject("Sociolgia", "200");
		sb2 = new SchoolSubject("Quimica", "876");
		mact = new ManagerActions();
		ssdao = new SchoolSubjectDAO();
	}

	@Test
	public void testInsertSchoolSubject() {
		mact.registerSubject(sb1);
		assertEquals(ssdao.getSchoolSubjectById(sb1.getId()).getId(), sb1.getId());
		//assertTrue(ssdao.getSchoolSubjectById(sb1.getId()).getId()== sb1.getId());
	}
	
	
	@Test
	public void testUpdateSchoolSubject() {
		
	
		SchoolSubject sbaux = ssdao.getSchoolSubjectById(sb1.getId());
		sbaux.setName("Filosofia");
		ssdao.updateSchoolSubject(sbaux);
		
		assertEquals(ssdao.getSchoolSubjectById(sbaux.getId()).getId(), sbaux.getId());
	}
	
	
	@Test
	public void testDeleteSchoolSubject() {
		ssdao.deleteSchoolSubject(sb1.getId());
		assertFalse(ssdao.getSchoolSubjectById(sb1.getId()).getId()== sb1.getId());
		//assertFalse(ssdao.getSchoolSubjectById(sb1.getId()).getId().equals(sb1.getId()));
		
		
	}

}
