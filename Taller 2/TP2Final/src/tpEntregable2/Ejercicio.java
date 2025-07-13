package tpEntregable2;

import java.sql.*;

import java.util.*;

public class Ejercicio {
	
	private static final String URL = "jdbc:mysql://localhost:3306/tokyo2021";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "1234";
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Desea agregar un deportista? Si la respuesta es si ingrese cualquier tecla salvo @, en caso contrario ingrese @");
		char codigo = scan.next().charAt(0);

		// Mientras no se elija el codigo @ se va a seguir ingresando información de
		// deportistas

		while (codigo != '@') {
			// Para absorber el /n del scan.next()
			scan.nextLine();

			Deportista dep = new Deportista();
			dep.cargarDeportista(scan);
			Connection con = null;
			try {
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement st = con.createStatement();
				PreparedStatement p_sent = con.prepareStatement("SELECT * FROM disciplina");
				PreparedStatement p_sent2 = con.prepareStatement("INSERT INTO atleta_en_disciplina(id_deportista, id_disciplina) VALUES(?,?);");
				
				String query = "INSERT INTO deportista(apellidos, nombres, email, telefono) VALUES('"
						+ dep.getApellidos() + "','" + dep.getNombres() + "','" + dep.getEmail() + "','"
						+ dep.getTelefono() + "');";
				

				ResultSet resul = p_sent.executeQuery();
				while (resul.next()) {
					System.out.println(resul.getInt("id") + " -- " + resul.getString("nombre"));
				}

				System.out.println(
						"Ingrese disciplinas a participar: (Finaliza al ingresar 0-Ejemplo: Si participa en Arqueria ingrese 1 0)");

				dep.cargarLista(scan);
				System.out.println("Información ingresada:");
				System.out.print(dep.toString());
				System.out.println(" y participa en las siguientes disciplinas: ");
				resul = p_sent.executeQuery();
				while (resul.next()) {
					if (dep.getDisciplinas().incluye(resul.getInt("id")))
						System.out.println(resul.getInt("id") + " -- " + resul.getString("nombre"));
				}

				System.out.println(
						"Si esta informacion es correcta y desea cargarla ingrese 1 .En caso contrario ingrese 0");
				int aux = scan.nextInt();
				// Para absorber el /n del scan.nextInt()
				scan.nextLine();
				if (aux == 1) {
					st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
					ResultSet keys = st.getGeneratedKeys();
					if (keys.next()) {
						dep.getDisciplinas().comenzar();
						int aux2=keys.getInt(1);
						while (!dep.getDisciplinas().fin()) {
							p_sent2.setInt(1, aux2);
							p_sent2.setInt(2, dep.getDisciplinas().proximo());
							p_sent2.executeUpdate();
						}
						
					}
					else {
						throw new SQLException("No se pudo crear el usuario");
					}
				}

				p_sent.close();
				st.close();
				con.close();
				// Se cierra la conexion luego de la carga de cada uno de los deportistas
				// individualmente
			} catch (SQLException e) {
				System.out.println("no se pudo conectar a la BD");
			}
			System.out.println(
					"Desea agregar otro deportista? Si la respuesta es si ingrese cualquier tecla salvo @, en caso contrario ingrese @");
			codigo = scan.next().charAt(0);
		}

		scan.close();
		System.out.println("Finalizo la carga de deportistas");
	}

}