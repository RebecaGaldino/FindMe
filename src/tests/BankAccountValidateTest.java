package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import findMe.domain.BankAccount;
import findMe.validate.validator.BankAccountValidate;
import findMe.validate.validator.NumberValidator;

public class BankAccountValidateTest {

	BankAccount b1;

	@Before
	public void setUp() throws Exception {
		 b1 = new BankAccount("212","31114", "242432423", "321", "nao gosto desse banco");
	}

	@Test
	public void testbankAccountValidate() {
		assertTrue(BankAccountValidate.validate(b1));
	}
	
	@Test
	public void testBankNumber(){
		assertTrue(NumberValidator.validate(b1.getAccountNumber()));
	}
	
	@Test
	public void testBankAgency(){
		assertTrue(NumberValidator.validate(b1.getAgency()));
	}
	
	@Test
	public void testBankType(){
		assertTrue(NumberValidator.validate(b1.getTypeAccount()));
	}

}
