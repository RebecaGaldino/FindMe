package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import findMe.domain.Person;
import findMe.validate.validator.CpfValidator;
import findMe.validate.validator.DateValidator;
import findMe.validate.validator.EmailValidator;
import findMe.validate.validator.NumberValidator;
import findMe.validate.validator.PersonValidate;
import findMe.validate.validator.RgValidator;
import findMe.validate.validator.StringValidator;

public class PersonValidatorTest {

	Person p1;

	@Before
	public void setUp() throws Exception {
		p1 = new Person("20141003012", "912.236.570-70", "02/03/1999", "Marcus Vinicius de Farias Barbosa", 
				"Aa#Ç~12", "Masculino", "4.123.133", "vinifarias@gmail.com");
		
		
	}

	@Test
	public void testPersonValidator() {
		assertTrue(PersonValidate.validate(p1));
	}
	
	@Test
	public void testPersonName(){
		assertTrue(StringValidator.onlyLetters(p1.getName()));
	}
	
	@Test
	public void testPersonCpf(){
		assertTrue(CpfValidator.validate(p1.getCpf()));
	}
	
	@Test
	public void testPersonRg(){
		assertTrue(RgValidator.validate(p1.getRg()));
	}
	
	@Test
	public void testPersonBirth_dt(){
		assertTrue(DateValidator.validate(p1.getBirth_dt()));
	}
	
	@Test
	public void testPersonEmail(){
		assertTrue(EmailValidator.validate(p1.getEmail()));
	}
	
	@Test
	public void testPersonId(){
		assertTrue(NumberValidator.validate(p1.getId()));
	}
	
	@Test
	public void testPersonPassword(){
		assertTrue(StringValidator.password(p1.getPassword()));
	}

}
