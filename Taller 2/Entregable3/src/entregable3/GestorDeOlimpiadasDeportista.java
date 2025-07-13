package entregable3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import dao.*;
import tablas.*;

public class GestorDeOlimpiadasDeportista extends JDialog {

	private static final long serialVersionUID = 1L;

	private static JTable tabla;
	// ids es una estructura adicional que utilizamos para almacenar temporalmente
	// los id de los deportistas en la tabla para poder, en caso de querer hacerlo,
	// editar al deportista
	private static int[] ids;
	private JButton botonNuevo = new JButton("+ NUEVO");
	private JButton botonExportarCSV = new JButton("EXPORTAR CSV");
	private JButton botonVolver = new JButton("VOLVER");
	private static JButton botonEditar = new JButton("EDITAR");
	private static JButton botonEliminar = new JButton("ELIMINAR");
	private String[] titulos = { "Nombre y Apellido", "Pais", "Disciplina", "editar", "eliminar" };

	public void crearBotonesSuperiores(JPanel panel) {
		GridLayout layout = new GridLayout(1, 3);
		panel.setBorder(new EmptyBorder(50, 300, 0, 100));
		layout.setHgap(20);
		layout.setVgap(20);
		panel.setLayout(layout);
		panel.add(botonNuevo);
		panel.add(botonExportarCSV);
		panel.add(botonVolver);

		// Implementacion de los botones

		botonNuevo.addMouseListener(new AdapterNuevo());
		botonVolver.addMouseListener(new AdapterVolver());
		botonExportarCSV.addMouseListener(new AdapterExportar());
	}

	public void crearTabla(JPanel panel) throws SQLException {
		tabla = new JTable();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(50, 200, 100, 100));
		panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Deportistas",
				TitledBorder.CENTER, TitledBorder.TOP));

		TableCellRenderer tableRenderer;
		tableRenderer = tabla.getDefaultRenderer(JButton.class);
		tabla.setDefaultRenderer(JButton.class, new RenderizacionBotones(tableRenderer));
		tabla.setTableHeader(null);
		this.cargaTabla();

		// Implementacion de los botones

		tabla.addMouseListener(new AdapterTabla());

	}

	public void cargaTabla() {

		// Cargar info de deportistas

		Object[][] datos;
		DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
		DeportistaDisciplinaDAO deportistaDisciplinaDAO = FactoryDAO.getDeportistaDisciplinaDAO();
		DisciplinaDAO disciplinaDAO = FactoryDAO.getDisciplinaDAO();
		PaisDAO paisDAO = FactoryDAO.getPaisDAO();

		try {
			int cant = deportistaDAO.getCantidad();
			// Armamos una lista ya que el deportista puede participar en varias disciplinas
			List<Integer> disciplinas = new LinkedList<Integer>();
			List<InfoDeportista> deportistas = new LinkedList<InfoDeportista>();
			deportistas = deportistaDAO.getDeportistas();
			Iterator<InfoDeportista> it = deportistas.iterator();

			datos = new Object[cant][5];
			ids = new int[cant];

			int fila = 0;
			while (it.hasNext()) {
				InfoDeportista aux = it.next();
				ids[fila] = aux.getId();
				datos[fila][0] = aux.getNombre() + " " + aux.getApellido();
				datos[fila][1] = paisDAO.getNombre(aux.getId_pais());
				disciplinas = deportistaDisciplinaDAO.getIdDisciplina(aux.getId());
				datos[fila][2] = disciplinaDAO.getNombre(disciplinas.get(0));
				datos[fila][3] = botonEditar;
				datos[fila][4] = botonEliminar;
				fila++;
			}
			tabla.setModel(new TablaModeloDeportista(datos, titulos));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder a la Base de Datos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	public void iniciar() throws SQLException {
		BorderLayout layout = new BorderLayout();
		layout.setHgap(60);
		layout.setVgap(30);
		this.setLayout(layout);
		this.setTitle("Gestor de Olimpiadas-DEPORTISTA");

		// 375*705 es el tamaño exacto de la aplicacion en el diagrama, usamos una
		// pantalla a escala (en particular 2.2)
		this.setSize(1551, 825);

		// panel1-->Botones Superiores

		JPanel panel1 = new JPanel();
		this.crearBotonesSuperiores(panel1);
		this.add(panel1, BorderLayout.NORTH);

		// panel1-->Tabla
		JPanel panel2 = new JPanel();
		this.crearTabla(panel2);
		this.add(panel2, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public class AdapterNuevo extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			try {
				GestorDeOlimpiadasNuevoDeportista deportista = new GestorDeOlimpiadasNuevoDeportista();
				deportista.setModal(true);
				deportista.iniciar(0, 0);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Se ha perdido conexion con la Base de Datos, no se puede agregar nuevo deportista ",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public class AdapterTabla extends MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent e) {

			int column = tabla.getColumnModel().getColumnIndexAtX(e.getX());
			int row = e.getY() / tabla.getRowHeight();
			if (row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
				Object value = tabla.getValueAt(row, column);
				if (value instanceof JButton) {
					((JButton) value).doClick();
					JButton boton = (JButton) value;

					if (boton.getText().equals("ELIMINAR")) {
						int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que desea borrar la línea?",
								"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
								new Object[] { "Sí", "No" }, "Sí");

						if (opcion != 1) {

							DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
							try {
								borrarDisciplinasDeportista(ids[tabla.getSelectedRow()]);
								deportistaDAO.eliminarDeportista(ids[tabla.getSelectedRow()]);

							} catch (SQLException evt) {
								JOptionPane.showMessageDialog(null, "Se ha perdido la conexion con la Base de Datos ", "Error",
										JOptionPane.WARNING_MESSAGE);
							}
							actualizarTabla();
						}
					}
					if (boton.getText().equals("EDITAR")) {
						GestorDeOlimpiadasNuevoDeportista deportista = new GestorDeOlimpiadasNuevoDeportista();
						deportista.setModal(true);
						try {
							deportista.iniciar(ids[tabla.getSelectedRow()], 1);
						} catch (SQLException evt) {
							JOptionPane.showMessageDialog(null, "Se ha perdido la conexion con la Base de Datos ", "Error",
									JOptionPane.WARNING_MESSAGE);
						}

					}
				}
			}
		}
	}

	public class AdapterVolver extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			dispose();
		}
	}

	public class AdapterExportar extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			exportarCSV();
		}
	}

	public void exportarCSV() {
		try {
			JFileChooser file = new JFileChooser();
			int eleccion = file.showOpenDialog(botonExportarCSV);
			if (eleccion == JFileChooser.APPROVE_OPTION) {
				File archivo = file.getSelectedFile();
				if (archivo != null) {
					FileWriter csvWriter = new FileWriter(archivo + ".csv");

					csvWriter.append("Nombre y Apellido");
					csvWriter.append(",");
					csvWriter.append("Pais");
					csvWriter.append(",");
					csvWriter.append("Disciplina");
					csvWriter.append('\n');

					DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
					DeportistaDisciplinaDAO deportistaDisciplinaDAO = FactoryDAO.getDeportistaDisciplinaDAO();
					DisciplinaDAO disciplinaDAO = FactoryDAO.getDisciplinaDAO();
					PaisDAO paisDAO = FactoryDAO.getPaisDAO();

					try {
						// Armamos una lista ya que el deportista puede participar en varias disciplinas
						List<Integer> disciplinas = new LinkedList<Integer>();
						List<InfoDeportista> deportistas = new LinkedList<InfoDeportista>();
						deportistas = deportistaDAO.getDeportistas();
						Iterator<InfoDeportista> it = deportistas.iterator();

						while (it.hasNext()) {
							InfoDeportista aux = it.next();
							csvWriter.append(aux.getNombre() + " " + aux.getApellido());
							csvWriter.append(",");
							csvWriter.append(paisDAO.getNombre(aux.getId_pais()));
							csvWriter.append(",");
							disciplinas = deportistaDisciplinaDAO.getIdDisciplina(aux.getId());
							csvWriter.append(disciplinaDAO.getNombre(disciplinas.get(0)));
							int i;
							for (i = 1; i < disciplinas.size(); i++) {
								csvWriter.append("-" + disciplinaDAO.getNombre(disciplinas.get(i)));
							}

							csvWriter.append('\n');
						}

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Se ha cerrado la conexión con la Base de Datos",
								"Advertencia", JOptionPane.WARNING_MESSAGE);
					}

					csvWriter.close();
					JOptionPane.showMessageDialog(null, "El archivo se ha guardado exitosamente", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void borrarDisciplinasDeportista(int id) throws SQLException {
		DeportistaDisciplinaDAO deportistaDisciplinaDAO = FactoryDAO.getDeportistaDisciplinaDAO();

		// Elimina de deportista_en_disciplina el deportista

		deportistaDisciplinaDAO.eliminarDeportista(id);

	}
	
	public void actualizarTabla() {
		this.cargaTabla();
	}
}
