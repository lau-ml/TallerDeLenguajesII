package base;
import java.sql.*;
public class BaseJuegos {

	public static void main(String[] args) {
		 Connection con=null;
		 try {
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tokio2021");
		 Statement st = con.createStatement();
		 . . .
		 st.close();
		 con.close();
		 } catch (ClassNotFoundException e) {
		 System.out.println(“no se encontró el driver”);
		 } catch (SQLException e) {
		 System.out.println(“no se pudo conectar a la BD”);
		 }

	}

}
