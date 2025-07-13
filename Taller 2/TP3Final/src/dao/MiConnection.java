package dao;

import java.sql.*;

public class MiConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/tokyo2021_e3";

	private static Connection con = null;

	private static void createCon(String usr, String pswd) {
		try {
			con = DriverManager.getConnection(URL, usr, pswd);
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
	}

	public static void setCon(String usr, String pswd) {
		if (con == null) {
			createCon (usr,pswd);
		}
	}
	
	public static Connection getCon() {
		return con;
	}
}