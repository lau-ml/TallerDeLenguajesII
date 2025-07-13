package dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import tpEntregable2.*;

public class DisciplinaDAOjdbc implements DisciplinaDAO {

	@Override
	public void eliminar(Disciplina disciplina) {
		try {			
			Connection con= MiConnection.getCon();
			Statement st=con.createStatement();
			
			String sql="DELETE FROM DISCIPLINA WHERE NOMBRE='" + disciplina.getNombre() + "';";
			st.execute(sql);
			}catch (java.sql.SQLException e) {
				System.out.println("Error de SQL: " + e.getMessage());
			}
	}
		
	

	@Override
	public void agregar(Disciplina disciplina) {
		try {
			Connection con=MiConnection.getCon();
			Statement st= con.createStatement();
		String query = "INSERT INTO disciplina(nombre) VALUES('"+ disciplina.getNombre() +"');";
		st.executeUpdate(query);
		st.close();
		con.close();
		}
		catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }	
		
	}

	@Override
	public Disciplina encontrar(int id) {
		Disciplina dis = new Disciplina();		
		try{
			 Connection con = MiConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from Disciplina where id="+id);
			 
			 if (rs.next()==true) {
			 dis.setNombre(rs.getString(2));
				}
			 rs.close();
			 st.close();
			 con.close();
			 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
			 }
			 return dis;
			 }

		
	

	@Override
	public ListaGenerica<Disciplina> obtener() {
		ListaGenerica <Disciplina> lista=new ListaGenericaEnlazada<Disciplina>();
		try {
			Connection con = MiConnection.getCon();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM DISCIPLINA ORDER BY ID";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Disciplina dis = new Disciplina();
				dis.setNombre(rs.getString(2));
				lista.agregarFinal(dis);
			}
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return lista;
	}
	}


