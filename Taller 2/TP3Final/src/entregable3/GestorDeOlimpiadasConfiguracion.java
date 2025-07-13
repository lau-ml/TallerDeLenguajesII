package entregable3;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;

import dao.MiConnection;

public class GestorDeOlimpiadasConfiguracion extends JDialog {

	private static final long serialVersionUID = 1L;

	private JButton botonVolver = new JButton("VOLVER");

	private JTextField usuarioBD = new JTextField("", 25);
	private JLabel usuario = new JLabel("USUARIO BD");

	private JPasswordField passwordBD = new JPasswordField("", 25);
	private JLabel password = new JLabel("PASSWORD BD");

	public void crearTabla(JPanel panel) {
		GridLayout layout = new GridLayout(2, 2);
		panel.setBorder(new EmptyBorder(15, 40, 15, 40));
		layout.setHgap(20);
		layout.setVgap(20);
		panel.setLayout(layout);
		usuario.setHorizontalAlignment(JLabel.RIGHT);
		usuarioBD.setHorizontalAlignment(JTextField.LEFT);
		usuarioBD.setEditable(true);
		password.setHorizontalAlignment(JLabel.RIGHT);
		passwordBD.setHorizontalAlignment(JPasswordField.LEFT);
		passwordBD.setEchoChar('*');
		passwordBD.setEditable(true);

		panel.add(usuario);
		panel.add(usuarioBD);
		panel.add(password);
		panel.add(passwordBD);
	}

	public void crearBotonVolver(Container panel) {
		panel.setLayout(new FlowLayout());
		panel.add(botonVolver);

		// Implementacion del boton

		botonVolver.addMouseListener(new AdapterVolver());
	}

	public class AdapterVolver extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {

			String usuario = usuarioBD.getText();
			String password = String.valueOf(passwordBD.getPassword());

			MiConnection.setCon(usuario, password);
			MiConnection.setCon(usuario, password);

			dispose();
		}

	}

	public void iniciar() {

		this.setLayout(new GridLayout(2, 1));
		this.setTitle("Gestor de Olimpiadas - CONFIGURACION");
		this.setSize(445, 230);

		// panel1-->Tabla para completar
		JPanel panel1 = new JPanel();
		this.crearTabla(panel1);
		this.add(panel1);

		// panel2-->Boton de Volver

		Container panel2 = new Container();
		this.crearBotonVolver(panel2);
		this.add(panel2);

		this.setResizable(false);
		this.setVisible(true);

	}
}