package dao;

import java.sql.*;
import java.util.*;

public interface DeportistaDisciplinaDAO {

	// Devuelve la lista de ids de disciplina que tiene asociado un deportista

	public List<Integer> getIdDisciplina(int id_deportista) throws SQLException;

	// Devuelve la lista de ids de disciplina que tiene asociado un deportista

	public void setUpdate(int id_deportista, int id_disciplina) throws SQLException;

	// Borrar todos los deportistas con id deportista recibida

	public void eliminarDeportista(int id_deportista) throws SQLException;

}
