package dao;

import java.sql.*;
import java.util.*;

public class DisciplinaDAOjdbc implements DisciplinaDAO {

	// Devuelve la cantidad de filas en la tabla de disciplina

	public int getCantidad() throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con.prepareStatement("SELECT COUNT(*) FROM disciplina");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt(1);
	}

	// Devuelve una lista con todos los nombres de las disciplinas

	public List<String> getDisciplinas() throws SQLException {
		Connection con = MiConnection.getCon();
		List<String> lista = new LinkedList<String>();
		PreparedStatement p_st = con.prepareStatement("SELECT * FROM disciplina");
		ResultSet resulp_st = p_st.executeQuery();
		while (resulp_st.next()) {
			String aux = resulp_st.getString("nombre");
			lista.add(aux);
		}
		return lista;
	}

	// Devuelve el nombre de una disciplina cuyo id se recibe por parametro

	public String getNombre(int id_disciplina) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con
				.prepareStatement("SELECT nombre FROM disciplina where id = '" + id_disciplina + "';");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getString("nombre");
	}

	// Devuelve el id de una disciplina cuyo nombre se recibe por parametro

	public int getId(String nombre) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con
				.prepareStatement("SELECT id FROM disciplina where nombre = '" + nombre + "';");
		ResultSet resulp_st = p_st.executeQuery();
		resulp_st.next();
		return resulp_st.getInt("id");
	}

}
