package entregable3;

public class InfoDeportista {
	
	private int id;
	private String nombre;
	private String apellido;
	private int id_pais;

	public InfoDeportista(int id, String nombre, String apellido, int id_pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id_pais = id_pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombreApellido() {
		String aux = nombre+" "+apellido;
		return aux;
	}

}
