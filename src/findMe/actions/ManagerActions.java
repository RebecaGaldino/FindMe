package findMe.actions;

import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Monitor;
import findMe.domain.Supervisor;
import findMe.validate.CustomException;
import findMe.validate.MonitorValidate;
import findMe.validate.PersonValidate;

public class ManagerActions {

	public void registerMonitor(Monitor monitor){
		try {
			MonitorValidate.validate(monitor);
			MonitorDAO mdao = new MonitorDAO();
			mdao.insertMonitor(monitor);
		} catch (CustomException e) {
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
			if(PersonValidate.validate(supervisor) == null){
				SupervisorDAO sdao = new SupervisorDAO();
				sdao.insertSupervisor(supervisor);
			}
			else{
				
			}
			
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMonitor(){
		
	}
	
	public void deleteSupervisor(){
		
	}

}
