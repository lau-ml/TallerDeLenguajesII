package entregable3;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import dao.*;
import tablas.*;

public class GestorDeOlimpiadasPais extends JDialog {

	private static final long serialVersionUID = 1L;

	private static JTable tabla;

	private JButton botonNuevo = new JButton("+ NUEVO");
	private JButton botonVolver = new JButton("VOLVER");
	private static JButton botonEditar = new JButton("EDITAR");
	private static JButton botonEliminar = new JButton("ELIMINAR");
	private String[] titulos = { "Id", "Pais", "editar", "eliminar" };

	public void crearBotonesSuperiores(JPanel panel) {
		GridLayout layout = new GridLayout(1, 2);
		panel.setBorder(new EmptyBorder(50, 600, 0, 100));
		layout.setHgap(20);
		layout.setVgap(20);
		panel.setLayout(layout);
		panel.add(botonNuevo);
		panel.add(botonVolver);

		// Implementacion de los botones

		botonNuevo.addMouseListener(new AdapterNuevo());
		botonVolver.addMouseListener(new AdapterVolver());
	}

	public void crearTabla(JPanel panel) {
		tabla = new JTable();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(50, 200, 100, 100));
		panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Paises",
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

		// Cargar info de paises

		Object[][] datos;
		PaisDAO paisDAO = FactoryDAO.getPaisDAO();

		try {
			int cant = paisDAO.getCantidad();
			List<InfoPais> paises = new LinkedList<InfoPais>();
			paises = paisDAO.getPaisesOrdenados();
			Iterator<InfoPais> it = paises.iterator();

			datos = new Object[cant][4];

			int fila = 0;
			while (it.hasNext()) {
				InfoPais aux = it.next();
				datos[fila][0] = aux.getId();
				datos[fila][1] = aux.getNombre();
				datos[fila][2] = botonEditar;
				datos[fila][3] = botonEliminar;
				fila++;
			}
			tabla.setModel(new TablaModeloPais(datos, titulos));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder a la Base de Datos",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		
		}
	}

	public void iniciar() throws SQLException{
		BorderLayout layout = new BorderLayout();
		layout.setHgap(60);
		layout.setVgap(30);
		this.setLayout(layout);
		this.setTitle("Gestor de Olimpiadas-PAIS");

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
			GestorDeOlimpiadasNuevoPais pais = new GestorDeOlimpiadasNuevoPais();
			pais.setModal(true);
			pais.iniciar(0, 0);
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

							PaisDAO paisDAO = FactoryDAO.getPaisDAO();
							try {
								paisDAO.borrarPais(tabla.getValueAt(row, column - 2));
							} catch (SQLException evt) {
								int eleccion = JOptionPane.showOptionDialog(null,
										"Este pais contiene deportistas asociados.¿Desea borrar el pais y todos sus deportistas?",
										"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
										new Object[] { "Sí", "No" }, "Sí");
								if (eleccion != 1) {
									try {
										borrarDeportistasPais(paisDAO.getId(tabla.getValueAt(row, column - 2)));
										paisDAO.borrarPais(tabla.getValueAt(row, column - 2));
									} catch (SQLException evt2) {
										JOptionPane.showMessageDialog(null, "Se perdio la conexion con la Base de Datos",
												"Advertencia", JOptionPane.WARNING_MESSAGE);
									}
								}
							}
							actualizarTabla();
						}
					}
					if (boton.getText().equals("EDITAR")) {
						DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
						try {

							GestorDeOlimpiadasNuevoPais pais = new GestorDeOlimpiadasNuevoPais();
							pais.setModal(true);
							boolean listaVacia = deportistaDAO.getIdPais(((Integer) tabla.getValueAt(row, column - 2)))
									.isEmpty();
							int eleccion = 1;
							if (!listaVacia) {
								eleccion = JOptionPane.showOptionDialog(null,
										"Existen deportistas que serán alterados por la edición del país ¿Desea continuar?",
										"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
										new Object[] { "Continuar", "Cancelar" }, "Continuar");
							}
							if (eleccion != 1 || listaVacia) {
								pais.iniciar(1, (Integer) (tabla.getValueAt(row, column - 2)));
								actualizarTabla();
							}
						} catch (SQLException evt3) {
							JOptionPane.showMessageDialog(null, "Se perdio la conexion con la Base de Datos",
									"Advertencia", JOptionPane.WARNING_MESSAGE);

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

	public void borrarDeportistasPais(int id) throws SQLException {
		DeportistaDAO deportistaDAO = FactoryDAO.getDeportistaDAO();
		DeportistaDisciplinaDAO deportistaDisciplinaDAO = FactoryDAO.getDeportistaDisciplinaDAO();

		// En deportistasPais guarda las id de los deportistas de un pais

		List<Integer> deportistasPais = new LinkedList<Integer>();
		deportistasPais = deportistaDAO.getIdPais(id);

		// Elimina de deportista_en_disciplina y deportista todos los deportistas

		Iterator<Integer> it = deportistasPais.iterator();
		while (it.hasNext()) {
			int aux = it.next();
			deportistaDisciplinaDAO.eliminarDeportista(aux);
			deportistaDAO.eliminarDeportista(aux);
		}

	}

	public void actualizarTabla() {
		this.cargaTabla();
	}
}
