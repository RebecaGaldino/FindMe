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
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		
		BankAccount ba = new BankAccount("4433", "242432423", "12", "nao gosto desse banco");
		
		//public Supervisor(String id, String cpf, String birth_dt, String name, String password, String sex, String rg, String email) {
		//}
		/*Supervisor s = new Supervisor("534534522", "122.333.222-90", convertStringToSqlString("12/12/1222"), "Marcus Vinicius de farias Barbosa", "1231313", "Masculino", "1.232.234", "vinifarias.vf@gmail.com");
		SchoolSubject ss = new SchoolSubject("Informatica", "122");
		
			
		Monitor m = new Monitor("24222343", "123.145.789-98", convertStringToSqlString("12/03/2000"), "Thayanne Luiza Victor Landim de Sousa", "52618241", "Feminino", "1.233.789", "Thayannevls@gmail.com", "Informatica", "2", ss,"Sala1", ba, s);
		
		//MonitorDAO mDAO = new MonitorDAO();
		//mDAO.insertMonitor(m);
		ManagerActions mac = new ManagerActions();
		SupervisorDAO sDAO = new SupervisorDAO();
		mac.registerMonitor(m);
		//sDAO.insertSupervisor(s);
		//mac.registerSupervisor(s);
		//System.out.println(s.getSex());*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String hora = "13:30";
		Date d = sdf.parse(hora);
		System.out.println(d);
		/*int hours = d.getHours();
		int minut = d.getMinutes();
		String time = hours+":"+minut;
		System.out.println(time);*/
	}
	
	
	/**
	 * Convert a string (dd/mm/yyyy) to sql string (yyyy-mm-dd)
	 * @param input
	 * @return
	 * @throws ParseException
	 * @author ViniFarias
	 */
	public static String convertStringToSqlString(String input) throws ParseException{
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {

		    String reformattedStr = myFormat.format(fromUser.parse(input));
		    return reformattedStr;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return null;
	    
		/* Date dtJava;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dtJava = (java.util.Date)formatter.parse(input);
		
		java.sql.Date date = new java.sql.Date(dtJava.getTime());
		
		String dtSql = (String)date.toString();
		
		return dtSql;*/
	}
}