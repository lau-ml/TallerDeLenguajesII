package baseJuegos;

import java.sql.*;

import java.util.*;
//import javax.sql.*;


public class BaseJuegos {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Desea agregar un deportista? Si la respuesta es si ingrese cualquier tecla salvo @, en caso contrario ingrese @");
		char codigo = scan.next().charAt(0);
		while (codigo != '@') {
			scan.nextLine();
			Deportista dep = new Deportista();
			dep.cargarDeportista(scan);
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokyo2021", "root", "BOCAjuniors836");
				Statement st = con.createStatement();

				String query = "INSERT INTO deportista(apellidos, nombres, email, telefono) VALUES('"
						+ dep.getApellidos() + "','" + dep.getNombres() + "','" + dep.getEmail() + "','"
						+ dep.getTelefono() + "');";
				ResultSet resul = st.executeQuery("SELECT * FROM disciplina");
				while (resul.next()) {
					System.out.println(resul.getInt("id") + " -- " + resul.getString("nombre"));
				}
				System.out.println(
						"Ingrese disciplinas a participar: (Finaliza al ingresar 0-Ejemplo: Si participa en Arqueria ingrese 1 0)");
				dep.cargarLista(scan);
				System.out.println("Información ingresada:");
				System.out.print(dep.toString());
				System.out.println(" y participa en las siguientes disciplinas: ");
				resul = st.executeQuery("SELECT * FROM disciplina");
				while (resul.next()) {
					if (dep.getDisciplinas().incluye(resul.getInt("id")))
						System.out.println(resul.getInt("id") + " -- " + resul.getString("nombre"));
				}
				System.out.println(
						"Si esta informacion es correcta y desea cargarla ingrese 1 .En caso contrario ingrese 0");
				int aux = scan.nextInt();
				scan.nextLine();
				if (aux == 1) {
					st.executeUpdate(query);
					resul = st.executeQuery("SELECT * FROM deportista ORDER BY id DESC LIMIT 1");
					int aux2 = 0;
					if (resul.next()) {
						aux2 = resul.getInt("id");
					}
					dep.getDisciplinas().comenzar();
					System.out.println("Se leyo la ultima linea, tiene id" + aux2);
					while (!dep.getDisciplinas().fin()) {
						String query2 = "INSERT INTO atleta_en_disciplina(id_deportista, id_disciplina) VALUES(" + aux2
								+ "," + dep.getDisciplinas().proximo() + ");";
						st.executeUpdate(query2);
					}

				}
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("no se pudo conectar a la BD");
			}
			System.out.println("Desea agregar otro deportista? Si la respuesta es si ingrese cualquier tecla salvo @, en caso contrario ingrese @");
			codigo = scan.next().charAt(0);
		}
		scan.close();
		System.out.println("Finalizo la carga de deportistas");
	}

}