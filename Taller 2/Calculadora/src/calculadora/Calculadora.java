package calculadora;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class Calculadora extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private JList lista = new JList();
	 private DefaultListModel modelo = new DefaultListModel();
	 private JTextField texto= new JTextField(15);
	 private JButton boton0= new JButton("0");
	 private JButton boton1= new JButton("1");
	 private JButton boton2= new JButton("2");
	 private JButton boton3= new JButton("3");
	 private JButton boton4= new JButton("4");
	 private JButton boton5= new JButton("5");
	 private JButton boton6= new JButton("6");
	 private JButton boton7= new JButton("7");
	 private JButton boton8= new JButton("8");
	 private JButton boton9= new JButton("9");
	 private JButton botonMas= new JButton("+");
	 private JButton botonMenos= new JButton("-");
	 private JButton botonMul= new JButton("*");
	 private JButton botonDiv= new JButton("/");
	 private JButton botonMC= new JButton("MC");
	 private JButton botonMR= new JButton("MR");
	 private JButton botonMS= new JButton("MS");
	 private JButton botonMMas= new JButton("M+");
	 private JButton botonMM= new JButton("+/-");
	 private JButton botonRetroceso= new JButton("Retroceso");
	 private JButton botonCE= new JButton("CE");
	 private JButton botonC= new JButton("C");
	 private JButton botonM= new JButton("Ma");
	 private JButton botonIgual= new JButton("=");
	 private JButton boton1x= new JButton("1/x");
	 private JButton botonPorcentaje= new JButton("%");
	 private JButton botonRaiz= new JButton("sqrt");
	 private JButton botonComa= new JButton(",");
	 public Calculadora() {
		 super("Calculadora");
		 this.setLayout(null);
		 this.setSize(250, 250);
		 texto.setBounds(10,15,215,20);
		 boton1.setBounds(15,50,35,35);
		 boton1.setFont(new Font("tahoma",Font.BOLD,5));
		 add(texto);
		 ImageIcon foto=new ImageIcon("Argentina.gif");
		 add(boton1);
		
		 
		 this.setVisible(true);
	 }
	 public static void main(String[] args) {
		Calculadora calculadora= new Calculadora();
	}

}
