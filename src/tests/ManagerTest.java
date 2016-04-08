package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

import findMe.actions.ManagerActions;
import findMe.dataBase.ManagerDAO;
import findMe.domain.Manager;
import findMe.domain.Person;
import findMe.extraMethods.Methods;
import findMe.validate.validator.PersonValidate;


/**
 * 
 * @author RebecaGaldino
 *
 */
public class ManagerTest {
	
	Manager m1;
	Manager m2;
	ManagerDAO mdao;

	@Before
	public void setUp() throws Exception {
		m1 = new Manager("00430", "189.436.845-67", "11/11/1985", "Pedro Marcos da Costa Silva", "#gerenciador123", "Masculino", "6.590.124", "padromcs@gmail.com");
		m2 = new Manager("12895", "123.435.665-65", "01/12/1973", "Maria do Anjos Ferreira", "senha345~", "Feminino", "7.689.432", "marianjos@outlook.com");
		mdao = new ManagerDAO();

	}

	@Test
	public void testInsertManager() throws ParseException {
		try{
			if(PersonValidate.validate(m1)){
				m1.setBirth_dt(Methods.convertStringToSqlString(m1.getBirth_dt()));
				mdao.insertManager(m1);
				assertEquals(mdao.getIdPerson(m1.getCpf()), m1.getId());
			}	
		} catch (Exception e){
			System.out.println(e.getMessage());	
			assertTrue(false);
		}
				
	}

	@Test
	public void testDeleteManager() {
		mdao.deleteManager(m1.getId());
		assertEquals(mdao.getIdPerson(m1.getCpf()), " ");
	}

	@Test
	public void testGetManagersInformations() {
		try{
			mdao.insertManager(m2);
			List<Person> list = new ArrayList<>();
			list = mdao.getManagersInformations();
			assertEquals(list.get(4), m1);
		} catch (Exception e){
			e.getMessage();
		}
	}

	@Test
	public void testUserChecksManager() {
		fail("Not yet implemented");
	}


}
