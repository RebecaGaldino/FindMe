package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

import findMe.actions.ManagerActions;
import findMe.dataBase.ManagerDAO;
import findMe.domain.Manager;
import findMe.extraMethods.Methods;
import findMe.validate.validator.PersonValidate;



public class ManagerTest {
	
	Manager m1;
	Manager m2;
	ManagerDAO mdao;
	ManagerActions ma;

	@Before
	public void setUp() throws Exception {
		m1 = new Manager("00430", "189.436.845-67", "11/11/1985", "Pedro Marcos da Costa Silva", "#Gerenciador123","Masculino", "6.590.124", "padromcs@gmail.com");
		m2 = new Manager("12895", "123.435.665-65", "01/12/1973", "Maria do Anjos Ferreira", "Senha345~","Feminino", "7.689.432", "marianjos@outlook.com");
		mdao = new ManagerDAO();
		ma = new ManagerActions();
	}

	@Test
	public void testInsertManager() throws ParseException {
		try{
			if(PersonValidate.validate(m1)){
				String dt = m1.getBirth_dt();
				m1.setBirth_dt(Methods.convertStringToSqlString(dt));
				mdao.insertManager(m1);
				assertEquals(mdao.getIdPerson(m1.getCpf()), m1.getId());
			}	
			else{
				assertTrue(false);
			}
		} catch (Exception e){
			System.out.println(e.getMessage());	
			assertTrue(false);
		}
				
	}

	
	
	@Test
	public void testUpdateManager(){
		Manager maux = mdao.getManagerById(m1.getId());
		maux.setName("Joao Pedro da Costa Silva");
		mdao.updateManager(maux);
		assertEquals(mdao.getIdPerson(m1.getCpf()), m1.getId());
	}
	
	
	@Test
	public void testDeleteManager() {
		ma.deleteManager(m1);
		assertFalse(mdao.getIdPerson(m1.getCpf()) == m1.getId());
	}
}
