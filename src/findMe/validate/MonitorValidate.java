package findMe.validate;

import findMe.domain.Monitor;

public class MonitorValidate {
	public static boolean validate(Monitor monitor) throws CustomException{
		if(!IdValidate.validate(monitor.getRoomWork()))
			return false;
		return true;
		
	}
}
