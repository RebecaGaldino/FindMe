package main;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.dataBase.ManipulateDB;

public class Test {
	public static void main(String[] args) throws ParseException {
		ManipulateDB mdb = new ManipulateDB();
		String inputStr = "11-11-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse("11-11-2012");
		mdb.insert("202020", "083.738.794-98", "thayanne", inputDate );
	}
	
}
