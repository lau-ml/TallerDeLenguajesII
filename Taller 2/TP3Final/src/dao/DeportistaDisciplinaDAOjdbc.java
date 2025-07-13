package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeportistaDisciplinaDAOjdbc implements DeportistaDisciplinaDAO {

	// Devuelve la lista de ids de disciplina que tiene asociado un deportista

	public List<Integer> getIdDisciplina(int id_deportista) throws SQLException {
		Connection con = MiConnection.getCon();
		List<Integer> lista = new LinkedList<Integer>();
		PreparedStatement p_st = con.prepareStatement(
				"SELECT id_disciplina FROM deportista_en_disciplina where id_deportista = '" + id_deportista + "';");
		ResultSet resulp_st = p_st.executeQuery();
		while (resulp_st.next()) {
			int aux = resulp_st.getInt("id_disciplina");
			lista.add(aux);
		}
		return lista;
	}

	// Devuelve la lista de ids de disciplina que tiene asociado un deportista

	public void setUpdate(int id_deportista, int id_disciplina) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con
				.prepareStatement("INSERT INTO deportista_en_disciplina(id_deportista, id_disciplina) VALUES('"
						+ id_deportista + "','" + id_disciplina + "');");
		p_st.executeUpdate();
	}

	// Borrar todos los deportistas con id deportista recibida

	public void eliminarDeportista(int id_deportista) throws SQLException {
		Connection con = MiConnection.getCon();
		PreparedStatement p_st = con
				.prepareStatement("DELETE FROM deportista_en_disciplina WHERE id_deportista = " + id_deportista + " ;");
		p_st.executeUpdate();

	}
}
