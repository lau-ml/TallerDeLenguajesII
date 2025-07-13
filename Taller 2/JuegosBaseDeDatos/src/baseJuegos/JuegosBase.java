package baseJuegos;

import javax.sql.*;
import java.sql.*;

public class JuegosBase {
	
public static void main(String[] args) {
	
	 Connection con=null;
	 try {
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tokio2021","Lautaro","BOCAjuniors836");
	 System.out.println("Se pudo conectar a la BD");
	 Statement st = con.createStatement();
	 st.close();
	 con.close();	 
	 
	 } catch (SQLException e) {
	 System.out.println("no se pudo conectar a la BD");
	 }

}
}