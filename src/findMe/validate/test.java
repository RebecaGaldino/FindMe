package findMe.validate;

import findMe.customExceptions.CustomException;
import findMe.domain.Person;

public class test {
	public static void main(String[] args) throws CustomException{
		try{
		Person person = new Person("2014115", "08373879498", "02/02/2010", "Abathur", "Tl34gmsfct07@", 
				"Feminino", "3.481.967", "thayannevls@gmail.com");
		if(PersonValidate.validate(person))
			System.out.println("Acertou mizeravi");
		else
			System.out.println("eh cilada bino");
		}catch(CustomException e){
			e.printStackTrace();
		}
	}
}
