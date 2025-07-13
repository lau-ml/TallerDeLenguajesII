package dao.jdbc;

import java.sql.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import tpEntregable2.Deportista;

public class DeportistaDAOjdbc implements DeportistaDAO {

	@Override
	public void eliminar(Deportista deportista) {
		try {			
			Connection con= MiConnection.getCon();
			Statement st=con.createStatement();
			String sql="DELETE FROM DEPORTISTA WHERE NOMBRES='" + deportista.getNombres() + "';";
			st.execute(sql);
			}catch (java.sql.SQLException e) {
				System.out.println("Error de SQL: " + e.getMessage());
			}
	}

	@Override
	public void agregar(Deportista dep) {

		try {
			Connection con = MiConnection.getCon();
			Statement st = con.createStatement();
			String query = "INSERT INTO deportista(apellidos, nombres, email, telefono) VALUES('" + dep.getApellidos()
					+ "','" + dep.getNombres() + "','" + dep.getEmail() + "','" + dep.getTelefono() + "');";
			st.executeUpdate(query);
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
	}

	@Override
	public Deportista encontrar(int id) {
		Deportista dep = new Deportista();		
		try{
			 Connection con = MiConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from Deportista where id="+id);
			 
			 if (rs.next()==true) {
			 dep.setApellidos(rs.getString(2));
				dep.setNombres(rs.getString(3));
				dep.setEmail(rs.getString(4));
				dep.setTelefono(rs.getString(5));
				}
			 rs.close();
			 st.close();
			 con.close();
			 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
			 }
			 return dep;
			 }

	@Override
	public ListaGenerica<Deportista> obtener() {
		ListaGenerica <Deportista> lista=new ListaGenericaEnlazada<Deportista>();
		try {
			Connection con = MiConnection.getCon();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM DEPORTISTA ORDER BY ID";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Deportista dep = new Deportista();
				dep.setApellidos(rs.getString(2));
				dep.setNombres(rs.getString(3));
				dep.setEmail(rs.getString(4));
				dep.setTelefono(rs.getString(5));
				lista.agregarFinal(dep);
			}
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return lista;
	}

}
