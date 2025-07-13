package dao;

public class FactoryDAO {
	public static DeportistaDAO getDeportistaDAO() {
		return new DeportistaDAOjdbc();
	}
	
	public static DeportistaDisciplinaDAO getDeportistaDisciplinaDAO() {
		return new DeportistaDisciplinaDAOjdbc();
	}
	
	public static DisciplinaDAO getDisciplinaDAO() {
		return new DisciplinaDAOjdbc();
	}
	
	public static PaisDAO getPaisDAO() {
		return new PaisDAOjdbc();
	}
}