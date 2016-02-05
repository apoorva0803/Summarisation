package app;

import java.sql.SQLException;

import DAO.UserDao;

public class Main {

	public static void main(String args[]){
		UserDao ud = new UserDao();
		try {
			ud.preProcess();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
