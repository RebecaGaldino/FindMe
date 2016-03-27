package main;
import java.text.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.ManagerDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.PersonDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.StudentDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.*;

public class TestR {
	public static void main(String[] args) throws ParseException {
		
		/**
		 * SchoolSubject and Manager tests
		 * @author Rebeca Galdino 
		 */
		/*---------------Subjects' names test--------------------------*/
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(SchoolSubject ss : s.getSubjectsnames()){
			System.out.println(ss.getName());
		}*/
		
		
		/*-------------- Subjects and supervisors test --------------- */
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(AuxiliarObject a : s.getSubjectsandSupervisors()){
			
			System.out.println(a.getA()+" "+a.getB());
		}		
		*/
		
		/*-------------- Subjects and monitors test --------------- */
		/*SchoolSubjectDAO s = new SchoolSubjectDAO();
		for(AuxiliarObject a : s.getMonitorsofasubject()){
			
			System.out.println(a.getA()+" "+a.getB());
		}*/
		
		
		/*-----------------Manager exposion of info test-------------*/
		/*ManagerDAO m = new ManagerDAO();
		for(Person p : m.getManagersInformations()){
			System.out.println(p.getName() + " " + p.getSex() + " " + p.getId() + " " + p.getCpf() + " " + p.getRg() + " " + p.getBirth_dt() + " "
		   + " " + p.getEmail() + " "+ p.getPassword() );
		}
		*/
	}
}