package dao.jdbc;

import java.sql.*;
public class MiConnection {
 private static Connection con = null;
	private static final String URL = "jdbc:mysql://localhost:3306/tokyo2021";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "xx";
 static {
 try {
	 
	 con = DriverManager.getConnection(URL, USER, PASSWORD);
 } catch (java.sql.SQLException e) {
 System.out.println("Error de SQL: "+e.getMessage());
 }
 }
public static Connection getCon() {
	return con;
 }
}
