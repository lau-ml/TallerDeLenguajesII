package dao;

import java.sql.*;
import java.util.*;

import entregable3.*;

public interface PaisDAO {

	// Devuelva la cantidad de filas en la tabla de pais

	public int getCantidad() throws SQLException;

	// Devuelve una lista con todos los nombres de los paises

	public List<String> getPaises() throws SQLException;

	// Devuelve una lista con id y nombre de los paises ordenados por orden
	// alfabetico

	public List<InfoPais> getPaisesOrdenados() throws SQLException;

	// Devuelve el nombre de un pais cuyo id se recibe por parametro

	public String getNombre(int id) throws SQLException;

	// Devuelve el id de un pais cuyo nombre se recibe por parametro

	public int getId(Object nombre) throws SQLException;

	// Inserta un pais

	public void setPais(String nombre) throws SQLException;

	// Devuelve el ultimo id de la tabla de pais

	public int getUltimoId() throws SQLException;

	// Actualizar nombre del pais

	public void actualizarNombre(String nombre, int id) throws SQLException;

	// Borrar pais

	public void borrarPais(Object nombre) throws SQLException;

}
