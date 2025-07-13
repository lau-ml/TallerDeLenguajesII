package entregable3;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import dao.*;
import exceptions.*;

public class GestorDeOlimpiadasNuevoDeportista extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField nombreText = new JTextField();
	private JTextField apellidoText = new JTextField();
	private JTextField emailText = new JTextField();
	private JTextField telefonoText = new JTextField();
	private JComboBox<String> paisBox;
	private JComboBox<String> disciplinaBox;
	private JLabel nombreEtiq = new JLabel("Nombre", SwingConstants.RIGHT);
	private JLabel apellidoEtiq = new JLabel("Apellido", SwingConstants.RIGHT);
	private JLabel emailEtiq = new JLabel("Email", SwingConstants.RIGHT);
	private JLabel telefonoEtiq = new JLabel("Telefono", SwingConstants.RIGHT);
	private JLabel paisEtiq = new JLabel("País", SwingConstants.RIGHT);
	private JLabel disciplinaEtiq = new JLabel("Disciplina", SwingConstants.RIGHT);
	private JTextField error = new JTextField(40);
	private JButton botonGuardar = new JButton("GUARDAR");
	private int id;
	private JLabel email;
	private JLabel telefono;

	public void crearGrillaCampos(JPanel panel, int opcion) throws SQLException {
		GridLayout layout = new GridLayout(6, 2);
		layout.setHgap(20);
		layout.setVgap(20);

		panel.setBorder(new EmptyBorder(0, 0, 0, 230));
		panel.setLayout(layout);

		panel.add(nombreEtiq);
		nombreText.setHorizontalAlignment(JTextField.LEFT);
		nombreText.setEditable(true);
		panel.add(nombreText);

		panel.add(apellidoEtiq);
		apellidoText.setHorizontalAlignment(JTextField.LEFT);
		apellidoText.setEditable(true);
		panel.add(apellidoText);

		panel.add(emailEtiq);
		DeportistaDAO deportistaDAO;
		if (opcion == 0) {
			emailText.setHorizontalAlignment(JTextField.LEFT);
			emailText.setEditable(true);
			panel.add(emailText);
			panel.add(telefonoEtiq);
			telefonoText.setHorizontalAlignment(JTextField.LEFT);
			telefonoText.setEditable(true);
			panel.add(telefonoText);
		} else {
			deportistaDAO = FactoryDAO.getDeportistaDAO();
			email = new JLabel(deportistaDAO.getEmail(id), SwingConstants.CENTER);
			panel.add(email);
			panel.add(telefonoEtiq);
			telefono = new JLabel(deportistaDAO.getTelefono(id), SwingConstants.CENTER);
			panel.add(telefono);
		}

		// Ahora obtenemos información de la base de Datos

		String[] paises;
		String[] disciplinas;

		DisciplinaDAO disciplinaDAO = FactoryDAO.getDisciplinaDAO();
		PaisDAO paisDAO = FactoryDAO.getPaisDAO();

		panel.add(paisEtiq);
		int cant = paisDAO.getCantidad();
		paises = new String[cant];

		List<String> lista1 = new LinkedList<String>();
		lista1 = paisDAO.getPaises();

		Iterator<String> it1 = lista1.iterator();
		int i = 0;
		while (it1.hasNext()) {
			paises[i] = it1.next();
			i++;
		}

		paisBox = new JComboBox<String>(paises);

		cant = disciplinaDAO.getCantidad();
		disciplinas = new String[cant];

		List<String> lista2 = new LinkedList<String>();
		lista2 = disciplinaDAO.getDisciplinas();

		Iterator<String> it2 = lista2.iterator();
		i = 0;
		while (it2.hasNext()) {
			disciplinas[i] = it2.next();
			i++;
		}

		disciplinaBox = new JComboBox<String>(disciplinas);

		panel.add(paisBox);
		panel.add(disciplinaEtiq);
		panel.add(disciplinaBox);

	}

	public void mensajeError(JPanel panel) {
		panel.setBorder(new EmptyBorder(30, 0, 0, 0));
		error.setHorizontalAlignment(JTextField.CENTER);
		error.setEditable(false);
		panel.add(error);
	}

	public void guardar(JPanel panel, int opcion) {
		panel.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel.add(botonGuardar);

		// Implementacion del boton
		if (opcion == 0)
			botonGuardar.addMouseListener(new AdapterGuardar());
		else
			botonGuardar.addMouseListener(new AdapterEditar());
	}

	public void iniciar(int id_deportista, int opcion) throws SQLException {
		if (opcion == 1)
			id = id_deportista;
		BorderLayout layout = new BorderLayout();
		layout.setHgap(0);
		layout.setVgap(40);
		this.setLayout(layout);
		if (opcion == 1) {
			this.setTitle("Gestor de olimpiadas -EDITAR DEPORTISTA");
		} else {
			this.setTitle("Gestor de olimpiadas -NUEVO DEPORTISTA");
		}
		this.setSize(700, 500);
		JPanel panel = new JPanel();
		this.crearGrillaCampos(panel, opcion);
		this.add(panel, BorderLayout.CENTER);
		JPanel panel2 = new JPanel();
		this.mensajeError(panel2);
		this.add(panel2, BorderLayout.NORTH);
		JPanel panel3 = new JPanel();
		this.guardar(panel3, opcion);
		this.add(panel3, BorderLayout.SOUTH);
		this.setResizable(false);
		this.setVisible(true);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public class AdapterGuardar extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			Color rojo = new Color(255, 191, 170);
			String nombre = nombreText.getText();
			String apellido = apellidoText.getText();
			String email = emailText.getText();
			String telefono = telefonoText.getText();
			String pais = (String) paisBox.getSelectedItem();
			String disciplina = (String) disciplinaBox.getSelectedItem();

			// Chequeo de campos obligatorios completos

			error.setBackground(rojo);

			if (nombre.isBlank() || apellido.isBlank() || email.isBlank() || telefono.isBlank()) {
				error.setText("No se han completado todos los campos!!");
			} else
				try {
					validador(nombre, apellido, email, telefono);
					String nombreNoEspacio = eliminarEspacios(nombre);
					String apellidoNoEspacio = eliminarEspacios(apellido);
					String emailNoEspacio = eliminarEspacios(email);

					DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
					DeportistaDisciplinaDAO deportistaDisciplinaDAO = FactoryDAO.getDeportistaDisciplinaDAO();
					DisciplinaDAO disciplinaDAO = FactoryDAO.getDisciplinaDAO();
					PaisDAO paisDAO = FactoryDAO.getPaisDAO();
					try {
						int id_pais = paisDAO.getId(pais);
						deportistaDAO.setDeportista(apellidoNoEspacio, nombreNoEspacio, emailNoEspacio, telefono,
								id_pais);
						int id_deportista = deportistaDAO.getUltimoId();
						int id_disciplina = disciplinaDAO.getId(disciplina);
						deportistaDisciplinaDAO.setUpdate(id_deportista, id_disciplina);
						actualizarTabla();

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,
								"No se pueden guardan los datos ya que se ha cerrado la conexion con la Base de Datos",
								"Advertencia", JOptionPane.INFORMATION_MESSAGE);
					}

					dispose();
				} catch (NombreException e) {
					error.setText("Por favor ingresar solo letras para el nombre: " + e.getCampo());
				} catch (ApellidoException e) {
					error.setText("Por favor ingresar solo letras para el apellido: " + e.getCampo());
				} catch (EmailException e) {
					error.setText(
							"Por favor asegurarse que el email: " + e.getCampo() + " sea correcto (no contiene @)");
				} catch (TelefonoException e) {
					error.setText("Por favor ingresar solo numeros para el telefono: " + e.getCampo());
				}
		}

	}

	public void validador(String nombre, String apellido, String email, String telefono)
			throws NombreException, ApellidoException, EmailException, TelefonoException {
		if (!soloLetras(nombre)) {
			throw new NombreException(nombre);
		} else if (!soloLetras(apellido)) {
			throw new ApellidoException(apellido);
		} else if (!contieneArroba(email)) {
			throw new EmailException(email);
		} else if (!soloNumeros(telefono)) {
			throw new TelefonoException(telefono);
		}
	}

	// Suponemos que la idea del editar es poder cambiar los campos
    // Nombre-Apellido-Pais-Disciplina por lo que los campos de
    // email y telefono quedan ineditables
    public class AdapterEditar extends MouseAdapter {
        public void mouseClicked(MouseEvent arg0) {
            Color rojo = new Color(255, 191, 170);
            String nombre = nombreText.getText();
            String apellido = apellidoText.getText();
            String pais = (String) paisBox.getSelectedItem();
            String disciplina = (String) disciplinaBox.getSelectedItem();

            // Chequeo de campos obligatorios completos

            if (nombre.isBlank() || apellido.isBlank()) {
                error.setBackground(rojo);
                error.setText("No se han completado todos los campos!!");
            } else
                try {
                    validador2(nombre, apellido);
                    String nombreNoEspacio = eliminarEspacios(nombre);
                    String apellidoNoEspacio = eliminarEspacios(apellido);

                    DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
                    DeportistaDisciplinaDAO deportistaDisciplinaDAO = FactoryDAO.getDeportistaDisciplinaDAO();
                    DisciplinaDAO disciplinaDAO = FactoryDAO.getDisciplinaDAO();
                    PaisDAO paisDAO = FactoryDAO.getPaisDAO();
                    
                    try {
                        int id_pais = paisDAO.getId(pais);
                        deportistaDAO.actualizarInfo(id, nombreNoEspacio, apellidoNoEspacio, id_pais);
                        int id_disciplina = disciplinaDAO.getId(disciplina);
                        int opcion = JOptionPane.showOptionDialog(null,
"¿Desea agregar a la lista de disciplinas o eliminar la lista y reemplazarla por la seleccionada?",
                                "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                new Object[] { "Agregar", "Reemplazar" }, "Agregar");

                        if (opcion == 1) {
                            deportistaDisciplinaDAO.eliminarDeportista(id);
                        }
                        if (!deportistaDisciplinaDAO.getIdDisciplina(id).contains(id_disciplina))
                        {deportistaDisciplinaDAO.setUpdate(id, id_disciplina);
                        }
                       
                        actualizarTabla();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,
                                "No se pueden guardan los datos ya que se ha cerrado la conexion con la Base de Datos",
                                "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    }

                    dispose();
                } catch (NombreException e) {
                    error.setText("Por favor ingresar solo letras para el nombre: " + e.getCampo());
                } catch (ApellidoException e) {
                    error.setText("Por favor ingresar solo letras para el apellido: " + e.getCampo());
                }
        }

    }

    public void validador2(String nombre, String apellido) throws NombreException, ApellidoException {
        if (!soloLetras(nombre)) {
            throw new NombreException(nombre);
        } else if (!soloLetras(apellido)) {
            throw new ApellidoException(apellido);
        }
    }
	// Metodos utilizados para la comprobacion de condiciones de carga

	public boolean soloLetras(String palabra) {
		int i;
		for (i = 0; i < palabra.length(); i++) {
			char c = palabra.charAt(i);

			// Si c es una letra o un espacio no se ejecuta return false

			if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
				return false;

			}
		}
		return true;
	}

	public boolean soloNumeros(String palabra) {
		int i;
		for (i = 0; i < palabra.length(); i++) {
			char c = palabra.charAt(i);

			// Si c es un numero no se ejecuta return false

			if (!((c >= '0' && c <= '9'))) {
				return false;

			}
		}
		return true;
	}

	public boolean contieneArroba(String palabra) {
		int i;
		for (i = 0; i < palabra.length(); i++) {
			char c = palabra.charAt(i);

			if (c == '@') {
				return true;

			}
		}
		return false;
	}

	public String eliminarEspacios(String palabra) {
		int i;
		String aux = "";
		for (i = 0; i < palabra.length(); i++) {
			char c = palabra.charAt(i);

			if (!(c == ' ')) {
				aux = aux + c;
			}
		}
		return aux;
	}

	public void actualizarTabla() {
		GestorDeOlimpiadasDeportista gestor = new GestorDeOlimpiadasDeportista();
		gestor.actualizarTabla();
	}
}