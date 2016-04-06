package findMe.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.Supervisor;

public class BankAccountDAO {
	private Connection conn;
	
	/*------------------------Connection method-----------------*/
	public BankAccountDAO() {
		conn = DBConnection.getConnection();
		if(conn != null)
			System.out.println("Connection established");
		else System.out.println("Error in DB connection");
		
	}
	
	/*------------------------INSERT----------------------------*/
	public void insertBankAccount(Monitor monitor) {
		String sql = "insert into bankaccount(id, numberaccount, agency, typeaccount, notes) values(?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, monitor.getBankAccount().getId());
			st.setString(2, monitor.getBankAccount().getAccountNumber());
			st.setString(3, monitor.getBankAccount().getAgency());
			st.setString(4, monitor.getBankAccount().getTypeAccount());
			st.setString(5, monitor.getBankAccount().getNotes());
			
			
			
			st.execute();
			st.close();
			System.out.println("Bank Account Cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------DELETE----------------------------*/
	public void deleteBankAccount(String id) {
		String sql = "delete from bankaccount where id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, id);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void updateBankAccount(BankAccount ba) {
		String sql = "update bankaccount set numberaccount = ?, agency = ?, typeaccount = ?, notes = ? where bankaccount.id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, ba.getAccountNumber());
			st.setString(2, ba.getAgency());
			st.setString(3, ba.getTypeAccount());
			st.setString(4, ba.getNotes());
			st.setString(5, ba.getId());
			
			st.execute();
			st.close();
			System.out.println("Bank Account atualizado com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
