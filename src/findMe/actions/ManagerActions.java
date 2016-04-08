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

public class ManagerActions {
	
	
	public void ManagerActions(){
		
	}
	
	public void registerMonitor(Monitor monitor){
		try {
			
				MonitorDAO mdao = new MonitorDAO();
				mdao.insertMonitor(monitor);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	/*!!!!
	 * Receber como par�metro as informa��es que s�o setadas na interface Name, id etc
	 * Validar essas informa��es com os validates 
	 * Inserir no banco de dados
	 */
	public void registerSupervisor(Supervisor supervisor){
		try {
			
				SupervisorDAO sdao = new SupervisorDAO();
				sdao.insertSupervisor(supervisor);
			
			
		} catch (Exception e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	
	public void registerSubject(SchoolSubject school){
		try {
			
				SchoolSubjectDAO sdao = new SchoolSubjectDAO();
				sdao.insertSchoolSubject(school);
			
			
		} catch (Exception e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}
	
	public void registerManager(Manager manager){
		try {
			
				ManagerDAO mdao = new ManagerDAO();
				mdao.insertManager(manager);
			
			
		} catch (Exception e) {
			AlertBox.error("Monitor Manager", e.getMessage() );
		}
	}

	
	
	public void deleteMonitor(Monitor monitor){
		MonitorDAO mdao = new MonitorDAO();
		mdao.deleteMonitor(monitor.getId());
		
	}
	
	public void deleteSupervisor(Supervisor supervisor){
		SupervisorDAO sdao = new SupervisorDAO();
		sdao.deleteSupervisor(supervisor.getId());
	}

	public void deleteSchoolSubject(SchoolSubject schoolSubject) {
		SchoolSubjectDAO ssdao = new SchoolSubjectDAO();
		ssdao.deleteSchoolSubject(schoolSubject.getId());
	}

	public void deleteManager(Manager manager) {
		ManagerDAO mdao = new ManagerDAO();
		mdao.deleteManager(manager.getId());
	}
}
