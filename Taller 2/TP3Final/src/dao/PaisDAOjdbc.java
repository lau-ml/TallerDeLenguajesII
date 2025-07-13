package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import entregable3.*;

public class PaisDAOjdbc implements PaisDAO {

	// Devuelva la cantidad de filas en la tabla de pais

	public int getCantidad() throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT COUNT(*) FROM pais");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt(1);
	}

	// Devuelve una lista con todos los nombres de los paises

	public List<String> getPaises() throws SQLException {
		Connection con = MiConnection.getCon();
		List<String> lista = new LinkedList<String>();
		PreparedStatement p_st = con.prepareStatement("SELECT * FROM pais");
		ResultSet resulp_st = p_st.executeQuery();
		while (resulp_st.next()) {
			String aux = resulp_st.getString("nombre");
			lista.add(aux);
		}
		return lista;
	}

	// Devuelve una lista con todos los id + nombres de los paises ordenados por
	// orden alfabetico

	public List<InfoPais> getPaisesOrdenados() throws SQLException {
		Connection con = MiConnection.getCon();
		List<InfoPais> lista = new LinkedList<InfoPais>();
		PreparedStatement p_st = con.prepareStatement("SELECT * FROM pais ORDER BY nombre");
		ResultSet resulp_st = p_st.executeQuery();
		while (resulp_st.next()) {
			InfoPais aux = new InfoPais(resulp_st.getInt("id"), resulp_st.getString("nombre"));
			lista.add(aux);
		}
		return lista;
	}

	// Devuelve el nombre de un pais cuyo id se recibe por parametro

	public String getNombre(int id) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT nombre FROM pais where id = '" + id + "';");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getString("nombre");
	}

	// Devuelve el id de un pais cuyo nombre se recibe por parametro

	public int getId(Object nombre) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT id FROM pais where nombre = '" + nombre + "';");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt("id");
	}

	// Inserta un pais

	public void setPais(String nombre) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("INSERT INTO pais(nombre) VALUES('" + nombre + "');");
		p_st.executeUpdate();
	}

	// Devuelve el ultimo id de la tabla de pais

	public int getUltimoId() throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT max(id) FROM pais");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt(1);
	}

	// Actualizar nombre del pais

	public void actualizarNombre(String nombre, int id) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con
				.prepareStatement("UPDATE pais SET nombre = '" + nombre + "' WHERE id = '" + id + "';");
		p_st.executeUpdate();
	}

	// Borrar pais

	public void borrarPais(Object nombre) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("DELETE FROM pais WHERE nombre = '" + nombre + "';");
		p_st.executeUpdate();
	}
}
