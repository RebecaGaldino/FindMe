package findMe.actions;

import DialogBox.AlertBox;
import findMe.customExceptions.CustomException;
import findMe.dataBase.ManagerDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Manager;
import findMe.domain.Monitor;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.validate.validator.MonitorValidate;
import findMe.validate.validator.PersonValidate;
/**
 * This class provides register and delete actions from manager
 * @author thayanneLuiza
 *
 */
public class ManagerActions {
	
	
	public void ManagerActions(){
		
	}
	/**
	 * Register Monitor using MonitorDao
	 * @param monitor
	 */
	public void registerMonitor(Monitor monitor){
		try {
			
				MonitorDAO mdao = new MonitorDAO();
				mdao.insertMonitor(monitor);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//AlertBox.error("Monitor Manager", e.getMessage() );
			e.printStackTrace();
		}
	}
	
	/**
	 * Register Supervisor using supervisorDAO
	 * @param supervisor
	 */
	public void registerSupervisor(Supervisor supervisor){
		try {
			
				SupervisorDAO sdao = new SupervisorDAO();
				sdao.insertSupervisor(supervisor);
			
			
		} catch (Exception e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	/**
	 * Register Subject using subjectDAO
	 * @param school
	 */
	public void registerSubject(SchoolSubject school){
		try {
			
				SchoolSubjectDAO sdao = new SchoolSubjectDAO();
				sdao.insertSchoolSubject(school);
			
			
		} catch (Exception e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	/**
	 * Register Manager using managerDAO
	 * @param manager
	 */
	public void registerManager(Manager manager){
		try {
			
				ManagerDAO mdao = new ManagerDAO();
				mdao.insertManager(manager);
			
			
		} catch (Exception e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}

	
	/**
	 * Delete Monitor using monitorDAO
	 * @param monitor
	 */
	public void deleteMonitor(Monitor monitor){
		MonitorDAO mdao = new MonitorDAO();
		mdao.deleteMonitor(monitor.getId());
		
	}
	/**
	 * Delete Supervisor using supervisorDAO
	 * @param supervisor
	 */
	public void deleteSupervisor(Supervisor supervisor){
		SupervisorDAO sdao = new SupervisorDAO();
		sdao.deleteSupervisor(supervisor.getId());
	}

	/**
	 * Delete Subject using schoolSubjectDAO
	 * @param schoolSubject
	 */
	public void deleteSchoolSubject(SchoolSubject schoolSubject) {
		SchoolSubjectDAO ssdao = new SchoolSubjectDAO();
		ssdao.deleteSchoolSubject(schoolSubject.getId());
	}
	/**
	 * Delete Manager using managerDAO
	 * @param manager
	 */
	public void deleteManager(Manager manager) {
		ManagerDAO mdao = new ManagerDAO();
		mdao.deleteManager(manager.getId());
	}
}
