package findMe.actions;

import findMe.dataBase.SupervisorDAO;
import findMe.domain.Supervisor;
/**
 * This class provides Supervisor Actions using SupervisorDAO
 * @author thayanneLuiza
 *
 */
public class SupervisorActions {

	private SupervisorDAO sdao = new SupervisorDAO();
	
	
	/**
	 * Default Constructor
	 */
	public SupervisorActions() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 *Method that updates the information of a supervisor	 
	 * @param supervisor
	 */
	public void editSupervisor(Supervisor supervisor){
		
		sdao.updateSupervisor(supervisor);
	}

}