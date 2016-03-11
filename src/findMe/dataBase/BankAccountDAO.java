package findMe.dataBase;

import java.sql.Connection;

public class BankAccountDAO {
	private Connection conn;
	
	public BankAccountDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	
}
