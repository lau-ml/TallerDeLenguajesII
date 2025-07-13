package entregable3;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.LinkedList;
import java.util.List;

import dao.*;
import exceptions.*;

public class GestorDeOlimpiadasNuevoPais extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField nombreText = new JTextField();
	private JLabel nombreEtiq = new JLabel("Nombre", SwingConstants.RIGHT);
	private JTextField error = new JTextField(40);
	private JButton botonGuardar = new JButton("GUARDAR");
	private static int opcion;
	private static int id;

	public void crearGrillaCampos(JPanel panel) {
		GridLayout layout = new GridLayout(1, 2);
		layout.setHgap(20);
		layout.setVgap(20);
		panel.setBorder(new EmptyBorder(100, 0, 100, 230));
		panel.setLayout(layout);
		panel.add(nombreEtiq);
		panel.add(nombreText);
	}

	public void mensajeError(JPanel panel) {
		panel.setBorder(new EmptyBorder(30, 0, 0, 0));
		error.setHorizontalAlignment(JTextField.CENTER);
		error.setEditable(false);
		panel.add(error);
	}

	public void guardar(JPanel panel) {
		panel.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel.add(botonGuardar);

		// Implementacion de los botones
		botonGuardar.addMouseListener(new AdapterGuardar());
	}

	public void iniciar(int opcionE, int idE) {
		opcion = opcionE;
		if (opcion == 1)
			id = idE;
		BorderLayout layout = new BorderLayout();
		layout.setHgap(0);
		layout.setVgap(40);
		this.setLayout(layout);
		if (opcion == 1) {
			this.setTitle("Gestor de olimpiadas -EDITAR PAIS");
		} else {
			this.setTitle("Gestor de olimpiadas -NUEVO PAIS");
		}
		this.setSize(700, 500);
		JPanel panel = new JPanel();
		this.crearGrillaCampos(panel);
		this.add(panel, BorderLayout.CENTER);
		JPanel panel2 = new JPanel();
		this.mensajeError(panel2);
		this.add(panel2, BorderLayout.NORTH);

		JPanel panel3 = new JPanel();
		this.guardar(panel3);
		this.add(panel3, BorderLayout.SOUTH);
		this.setResizable(false);
		this.setVisible(true);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public class AdapterGuardar extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			Color rojo = new Color(255, 191, 170);
			String nombre = nombreText.getText();

			// Chequeo de campos obligatorios completos

			error.setBackground(rojo);

			if (nombre.isBlank()) {
				error.setText("No se han completado todos los campos!!");
			} else {
				try {
					validador(nombre);
					accesoGuardar(nombre);
				} catch (PaisRepetidoException e) {
					e.getError();
				} catch (NombreException e) {
					error.setText("Por favor ingresar solo letras para el nombre: " + e.getCampo());
				}

			}

		}
	}

	public void validador(String nombre) throws NombreException {
		if (!soloLetras(nombre)) {
			throw new NombreException(nombre);
		}
	}

	public void accesoGuardar(String nombre) throws PaisRepetidoException {
		String nombreNoEspacio = eliminarEspacios(nombre);
		PaisDAO paisDAO = FactoryDAO.getPaisDAO();
		try {
			List<String> paises = new LinkedList<String>();
			paises = paisDAO.getPaises();

			if (paises.contains(nombreNoEspacio)) {
				if (opcion ==1 && nombreNoEspacio.equals(paisDAO.getNombre(id))) {
					dispose();
				} else {
					throw new PaisRepetidoException();
				}
			} else {
				if (opcion == 0) {
					paisDAO.setPais(nombreNoEspacio);
					actualizarTabla();
				} else {
					paisDAO.actualizarNombre(nombreNoEspacio, id);
				}
				dispose();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"No se pueden guardan los datos ya que se ha cerrado la conexion con la Base de Datos",
					"Advertencia", JOptionPane.INFORMATION_MESSAGE);
		}
	}

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
		GestorDeOlimpiadasPais gestor = new GestorDeOlimpiadasPais();
		gestor.actualizarTabla();
	}
}