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
	
	public void registerMonitor(Monitor monitor){
		try {
			
				MonitorDAO mdao = new MonitorDAO();
				mdao.insertMonitor(monitor);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
	
	public void registerSubject(SchoolSubject school){
		try {
			
				SchoolSubjectDAO sdao = new SchoolSubjectDAO();
				sdao.insertSchoolSubject(school);
			
			
		} catch (Exception e) {
			e.printStackTrace();
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

}
