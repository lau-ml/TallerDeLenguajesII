package dao.jdbc;

import prog3.listagenerica.ListaGenerica;
import tpEntregable2.*;

public interface DeportistaDAO {
	void eliminar(Deportista deportista);
	void agregar(Deportista deportista);
	Deportista encontrar(int id);
	ListaGenerica<Deportista> obtener();
}
