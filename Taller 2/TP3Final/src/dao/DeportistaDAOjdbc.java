package dao;

import java.sql.*;
import java.util.*;
import entregable3.*;

public class DeportistaDAOjdbc implements DeportistaDAO {

	// Devuelva la cantidad de filas en la tabla de deportista

	public int getCantidad() throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT COUNT(*) FROM deportista");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt(1);
	}

	// Devuelve una lista con el id,nombre,apellido e id_pais de cada deportista en
	// la BD

	public List<InfoDeportista> getDeportistas() throws SQLException {
		Connection con = MiConnection.getCon();
		List<InfoDeportista> lista = new LinkedList<InfoDeportista>();
		PreparedStatement p_st = con.prepareStatement("SELECT * FROM deportista");
		ResultSet resulp_st = p_st.executeQuery();
		while (resulp_st.next()) {
			InfoDeportista aux = new InfoDeportista(resulp_st.getInt("id"), resulp_st.getString("nombres"),
					resulp_st.getString("apellidos"), resulp_st.getInt("id_pais"));
			lista.add(aux);
		}
		return lista;
	}

	// Devuelve una lista de id de deportista con id_pais igual al recibido

	public List<Integer> getIdPais(int id_pais) throws SQLException {
		Connection con = MiConnection.getCon();
		List<Integer> lista = new LinkedList<Integer>();
		PreparedStatement p_st = con.prepareStatement("SELECT id FROM deportista WHERE id_pais = " + id_pais + ";");
		ResultSet resulp_st = p_st.executeQuery();
		while (resulp_st.next()) {
			lista.add(resulp_st.getInt("id"));
		}
		return lista;
	}

	// Devuelve email del deportista con id recibido

	public String getEmail(int id) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT email FROM deportista WHERE id = " + id + " ;");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getString("email");
	}

	// Devuelve telefono del deportista con id recibido

	public String getTelefono(int id) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT telefono FROM deportista WHERE id = " + id + " ;");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getString("telefono");
	}

	// Inserta todos los valores en la tabla de deportista

	public void setDeportista(String apellido, String nombre, String email, String telefono, int id_pais)
			throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con
				.prepareStatement("INSERT INTO deportista(apellidos, nombres, email, telefono, id_pais) VALUES('"
						+ apellido + "','" + nombre + "','" + email + "','" + telefono + "','" + id_pais + "');");
		p_st.executeUpdate();
	}

	// Devuelve el ultimo id de la tabla de deportista

	public int getUltimoId() throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT max(id) FROM deportista");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt(1);
	}

	// Borrar el deportista con id recibida

	public void eliminarDeportista(int id) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("DELETE FROM deportista WHERE id = " + id + " ;");
		p_st.executeUpdate();

	}

	// Actualizar info deportista

	public void actualizarInfo(int id, String nombre, String apellido, int id_pais) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("UPDATE deportista SET nombres = '" + nombre + "',apellidos = '"
				+ apellido + "',id_pais = " + id_pais + " WHERE id = '" + id + "';");
		p_st.executeUpdate();
	}

}