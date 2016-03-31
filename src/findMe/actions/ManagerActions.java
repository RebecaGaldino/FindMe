package findMe.actions;

import findMe.customExceptions.CustomException;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Monitor;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.validate.validator.MonitorValidate;
import findMe.validate.validator.PersonValidate;

public class ManagerActions {
	
	
	public void ManagerActions(){
		
	}
	/**
	 * Register Monitor on dataBase
	 * @param monitor
	 */
	public void registerMonitor(Monitor monitor){
		try {
			
				MonitorDAO mdao = new MonitorDAO();
				mdao.insertMonitor(monitor);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Register Supervisor on dataBase
	 * @param supervisor
	 */
	public void registerSupervisor(Supervisor supervisor){
		try {
			
				SupervisorDAO sdao = new SupervisorDAO();
				sdao.insertSupervisor(supervisor);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Register School Subject on dataBase
	 * @param subject
	 */
	public void registerSubject(SchoolSubject subject){
		try {
			
				SchoolSubjectDAO sdao = new SchoolSubjectDAO();
				sdao.insertSchoolSubject(subject);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Delete monitor
	 * @param monitor
	 */
	public void deleteMonitor(Monitor monitor){
		MonitorDAO mdao = new MonitorDAO();
		mdao.deleteMonitor(monitor.getId());
		
	}
	/**
	 * Delete supervisor
	 * @param supervisor
	 */
	public void deleteSupervisor(Supervisor supervisor){
		SupervisorDAO sdao = new SupervisorDAO();
		sdao.deleteSupervisor(supervisor.getId());
	}
	/**
	 * Delete SchoolSubject
	 * @param schoolSubject
	 */
	public void deleteSchoolSubject(SchoolSubject schoolSubject) {
		SchoolSubjectDAO ssdao = new SchoolSubjectDAO();
		ssdao.deleteSchoolSubject(schoolSubject.getId());
	}

}
