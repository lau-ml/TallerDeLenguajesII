package dao;

import java.sql.SQLException;
import java.util.*;

import entregable3.InfoDeportista;

public interface DeportistaDAO {

	// Devuelva la cantidad de filas en la tabla de deportista

	public int getCantidad() throws SQLException;

	// Devuelve una lista con el id,nombre,apellido e id_pais de cada deportista en
	// la BD

	public List<InfoDeportista> getDeportistas() throws SQLException;

	// Devuelve una lista de id de deportista con id_pais igual al recibido

	public List<Integer> getIdPais(int id_pais) throws SQLException;

	// Devuelve email del deportista con id recibido

	public String getEmail(int id) throws SQLException;

	// Devuelve telefono del deportista con id recibido

	public String getTelefono(int id) throws SQLException;

	// Inserta todos los valores en la tabla de deportista

	public void setDeportista(String apellido, String nombre, String email, String telefono, int id_pais)
			throws SQLException;

	// Devuelve el ultimo id de la tabla de deportista

	public int getUltimoId() throws SQLException;

	// Borrar el deportista con id recibida

	public void eliminarDeportista(int id) throws SQLException;

	// Actualizar info deportista

	public void actualizarInfo(int id, String nombre, String apellido, int id_pais) throws SQLException;

}
