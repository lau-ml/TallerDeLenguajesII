package dao.jdbc;

import prog3.listagenerica.*;
import tpEntregable2.*;

public interface DisciplinaDAO {
void eliminar(Disciplina disciplina);
void agregar(Disciplina disciplina);
Disciplina encontrar(int id);
ListaGenerica<Disciplina> obtener();
}
