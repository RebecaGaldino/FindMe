package findMe.actions;

import findMe.dataBase.SupervisorDAO;
import findMe.domain.Supervisor;

public class SupervisorActions {

	private SupervisorDAO sdao = new SupervisorDAO();
	
	public SupervisorActions() {
		// TODO Auto-generated constructor stub
	}
	
	public void editSupervisor(Supervisor supervisor){
		
		sdao.updateSupervisor(supervisor);
	}

}
