package entregable3;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class GestorDeOlimpiadas extends JFrame {

	private static final long serialVersionUID = 1L;

	ImageIcon imagenConfiguracion = new ImageIcon(getClass().getResource("/images/Configuracion.png"));
	private JButton botonConfiguracion;

	private ImageIcon imagenDeportista = new ImageIcon(getClass().getResource("/images/Deportista.png"));
	private JButton botonDeportista;

	private ImageIcon imagenPais = new ImageIcon(getClass().getResource("/images/Pais.png"));
	private JButton botonPais;

	private ImageIcon imagenDisciplina = new ImageIcon(getClass().getResource("/images/Disciplina.png"));
	private JButton botonDisciplina;

	// Metodo para crear la grilla de botones en la interfaz principal

	public void crearGrillaBotones(Container panel) {
		GridLayout aux = new GridLayout(3, 3);

		int Hgap = 70;
		int Vgap = 30;
		aux.setHgap(Hgap);
		aux.setVgap(Vgap);

		panel.setLayout(aux);

		botonDeportista = new JButton("Deportista", imagenDeportista);
		botonDeportista.setHorizontalTextPosition(AbstractButton.CENTER);
		botonDeportista.setVerticalTextPosition(AbstractButton.BOTTOM);
		panel.add(botonDeportista);

		// Escalamos la imagen del pais para que se adapte al tamaño del boton

		Image imagen = imagenPais.getImage();
		Image nuevaImagen = imagen.getScaledInstance(250, 180, java.awt.Image.SCALE_AREA_AVERAGING);
		imagenPais = new ImageIcon(nuevaImagen);
		botonPais = new JButton("Pais", imagenPais);
		botonPais.setHorizontalTextPosition(AbstractButton.CENTER);
		botonPais.setVerticalTextPosition(AbstractButton.BOTTOM);
		panel.add(botonPais);

		botonDisciplina = new JButton("Disciplina", imagenDisciplina);
		botonDisciplina.setHorizontalTextPosition(AbstractButton.CENTER);
		botonDisciplina.setVerticalTextPosition(AbstractButton.BOTTOM);
		panel.add(botonDisciplina);

		JButton botonGenerico1 = new JButton("SIN DEFINIR");
		panel.add(botonGenerico1);
		JButton botonGenerico2 = new JButton("SIN DEFINIR");
		panel.add(botonGenerico2);
		JButton botonGenerico3 = new JButton("SIN DEFINIR");
		panel.add(botonGenerico3);
		JButton botonGenerico4 = new JButton("SIN DEFINIR");
		panel.add(botonGenerico4);
		JButton botonGenerico5 = new JButton("SIN DEFINIR");
		panel.add(botonGenerico5);
		JButton botonGenerico6 = new JButton("SIN DEFINIR");
		panel.add(botonGenerico6);

		// Implementacion de los botones

		botonDeportista.addMouseListener(new AdapterDeportista());
		botonPais.addMouseListener(new AdapterPais());

	}

	// Creamos el boton de configuración

	public void crearBotonConfiguracion(Container panel) {
		panel.setLayout(new FlowLayout());
		botonConfiguracion = new JButton(imagenConfiguracion);
		botonConfiguracion.setMaximumSize(new Dimension(50, 50));
		botonConfiguracion.setPreferredSize(new Dimension(50, 50));
		panel.add(botonConfiguracion);

		// Implementacion de los botones

		botonConfiguracion.addMouseListener(new AdapterConfiguracion());
	}

	public void init() {

		this.setLayout(new GridBagLayout());
		this.setTitle("Gestor de Olimpiadas");

		// 375*705 es el tamaño exacto de la aplicacion en el diagrama, usamos una
		// pantalla a escala (en particular 2.2)

		this.setSize(1551, 825);

		// Configuración de cada panel
		
		GridBagConstraints c = new GridBagConstraints();

		// panel1-->Grilla de Botones

		Container panel1 = new Container();
		this.crearGrillaBotones(panel1);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 10;
		c.gridwidth = 10;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(25, 55, 30, 0);
		c.weightx = 0.5;
		c.weighty = 1.0;
		c.ipadx = 150;
		c.ipady = 150;

		this.add(panel1, c);

		// panel2-->Boton de Configuración

		Container panel2 = new Container();
		this.crearBotonConfiguracion(panel2);
		c.gridx = 10;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.weightx = 0.1;
		c.weighty = 0.1;
		c.ipadx = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_END;

		this.add(panel2, c);

		this.setResizable(false);
		this.setVisible(true);

	}

	public class AdapterDeportista extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			try {
				GestorDeOlimpiadasDeportista deportistas = new GestorDeOlimpiadasDeportista();
				deportistas.setModal(true);
				deportistas.iniciar();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error de conexión ", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "No se ha conectado a la Base de Datos ", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	public class AdapterPais extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			try {
				GestorDeOlimpiadasPais pais = new GestorDeOlimpiadasPais();
				pais.setModal(true);
				pais.iniciar();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error de conexión ", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "No se ha conectado a la Base de Datos ", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public class AdapterConfiguracion extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			GestorDeOlimpiadasConfiguracion config = new GestorDeOlimpiadasConfiguracion();
			config.setModal(true);
			config.iniciar();
		}
	}

	public static void main(String[] args) {
		GestorDeOlimpiadas app = new GestorDeOlimpiadas();
		app.init();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
