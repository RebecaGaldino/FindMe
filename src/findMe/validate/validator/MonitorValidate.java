package findMe.validate.validator;

import findMe.customExceptions.CustomException;
import findMe.domain.Monitor;

public class MonitorValidate {
	public static void validate(Monitor monitor) throws CustomException{
		PersonValidate.validate(monitor);
		if(!IdValidate.validate(monitor.getRoomWork()){
			
		}
		if(!GradeValidate.validate(monitor.getGrade())){
			 
		}
		
		
		
	}
}
