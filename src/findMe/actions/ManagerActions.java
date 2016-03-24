package findMe.actions;

import findMe.dataBase.SupervisorDAO;
import findMe.domain.Monitor;
import findMe.domain.Supervisor;

public class ManagerActions {

	public void registerMonitor(Monitor monitor){
		
	}
	
	/*!!!!
	 * Receber como parâmetro as informações que são setadas na interface Name, id etc
	 * Validar essas informações com os validates 
	 * Inserir no banco de dados
	 */
	public void registerSupervisor(){
		
		SupervisorDAO sdao = new SupervisorDAO();
		
		sdao.insertSupervisor(null);
		
	}
	
	public void deleteMonitor(){
		
	}
	
	public void deleteSupervisor(){
		
	}

}
