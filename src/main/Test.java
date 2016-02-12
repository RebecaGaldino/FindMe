package main;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.PersonManipulateDB;

public class Test {
	public static void main(String[] args) throws ParseException {
		PersonManipulateDB mdb = new PersonManipulateDB();
		String inputStr = "11-11-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse("11-11-2012");
		mdb.insertPerson("202020", "083.738.794-98", "thayanne", inputDate );
		
		
	}
	
}
