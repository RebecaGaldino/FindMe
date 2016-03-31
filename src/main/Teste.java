package main;
import java.text.*;
import java.util.*;

import findMe.actions.ManagerActions;
import findMe.dataBase.ManagerDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.StudentDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.*;

public class Teste{
	public static void main(String[] args) throws ParseException {
		
		BankAccount ba = new BankAccount("7374", "242432423", "12", "nao gosto desse banco");
		
		//public Supervisor(String id, String cpf, String birth_dt, String name, String password, String sex, String rg, String email) {
		//}
		Supervisor s = new Supervisor("20122003011", "122.333.222-90", convertStringToSqlString("12/12/1222"), "Marcus Vinicius de farias Barbosa", "1231313", "Masculino", "1.232.234", "vinifarias.vf@gmail.com");
		SchoolSubject ss = new SchoolSubject("Informatica", "122");
		
			
		Monitor m = new Monitor("20141004003", "123.145.789-98", convertStringToSqlString("12/12/1222"), "Thayanne Luiza Victor Landim de Sousa", "52618241", "Feminino", "1.233.789", "Thayannevls@gmail.com", "Informatica", "2", ss,"Sala1", ba, s);
		
		//MonitorDAO mDAO = new MonitorDAO();
		//mDAO.insertMonitor(m);
		ManagerActions mac = new ManagerActions();
		SupervisorDAO sDAO = new SupervisorDAO();
		mac.registerMonitor(m);
		//sDAO.insertSupervisor(s);
		//m.registerSupervisor(s);
		
		System.out.println(s.getSex());
	}
	
	
	/**
	 * Convert a string (dd/mm/yyy) to sql string (yyyy-mm-dd)
	 * @param input
	 * @return
	 * @throws ParseException
	 * @author ViniFarias
	 */
	public static String convertStringToSqlString(String input) throws ParseException{
		Date dtJava;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dtJava = (java.util.Date)formatter.parse(input);
		
		java.sql.Date date = new java.sql.Date(dtJava.getTime());
		
		String dtSql = (String)date.toString();
		
		return dtSql;
	}
}