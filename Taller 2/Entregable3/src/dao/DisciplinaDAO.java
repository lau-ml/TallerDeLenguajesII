package dao;

import java.sql.*;
import java.util.*;

public interface DisciplinaDAO {

	// Devuelve la cantidad de filas en la tabla de disciplina

	public int getCantidad() throws SQLException;

	// Devuelve una lista con todos los nombres de las disciplinas

	public List<String> getDisciplinas() throws SQLException;

	// Devuelve el nombre de una disciplina cuyo id se recibe por parametro

	public String getNombre(int id_disciplina) throws SQLException;

	// Devuelve el id de una disciplina cuyo nombre se recibe por parametro

	public int getId(String nombre) throws SQLException;

}
