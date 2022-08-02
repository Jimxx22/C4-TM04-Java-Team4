package team4.tm04;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class AppGrafica {

	protected JFrame frame;
	private JMenuBar barraMenu;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem nuevaPartidaMaquina;
	private JMenuItem nuevaPartidaJugador;
	private JMenuItem salir;
	private JMenuItem reglas;
	private JPanel panel;
	private JPanel panel_1;
	private Integer[] coloresDisponibles=new Integer[6];
	private JPanel panel_3;
	private static JToggleButton tglbtnClr1;
	private static JToggleButton tglbtnClr2;
	private static JToggleButton tglbtnClr3;
	private static JToggleButton tglbtnClr4;
	private static JToggleButton tglbtnClr5;
	private static JToggleButton tglbtnClr6;
	private JLabel lblColores;
	private JButton btnGen;
	private JLabel lblCombinacion;
	private JPanel panel_4;
	private static JToggleButton tglbtnClr1S;
	private static JToggleButton tglbtnClr2S;
	private static JToggleButton tglbtnClr3S;
	private static JToggleButton tglbtnClr4S;
	private static JToggleButton tglbtnClr5S;
	private static JToggleButton tglbtnClr6S;
	private JLabel lblError;
	static Pieza[] piezasGeneradas;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> piezasHistorial=new ArrayList<>();
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JToggleButton tglbtnClr1_1;
	private JToggleButton tglbtnClr2_1;
	private JToggleButton tglbtnClr3_1;
	private JToggleButton tglbtnClr4_1;
	private JToggleButton tglbtnClr5_1;
	private JToggleButton tglbtnClr6_1;
	private JPanel panel_5;
	private JToggleButton tglbtnClr1S_1;
	private JToggleButton tglbtnClr2S_1;
	private JToggleButton tglbtnClr3S_1;
	private JToggleButton tglbtnClr4S_1;
	private JToggleButton tglbtnClr5S_1;
	private JToggleButton tglbtnClr6S_1;
	private JButton btnNewButton;

	/**
	 * Create the application.
	 */
	public AppGrafica() {
		initialize();
	}
	
	/**
	 * Que falta:
	 * Hacer que el jugador seleccione las piezas para adivinar
	 * Que el programa mire en que coinciden las piezas mediante la clase Pieza y su estado
	 * Anadir las reglas
	 * Hacer que una vez a entrado un patron, le deje entrar otro y asi consecutivamente hasta que acierte el patron o hayan pasado 6 turnos
	 * Una vez pasen 6 turnos o no haya adivinado el patron, salta una ventana diciendo si ha gando o no, i si ha ganado con quantos intentos, i mostrando el patron ha adivinar
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menu superior
		barraMenu=new JMenuBar();
		barraMenu.setBackground(Color.WHITE);
		archivo=new JMenu("Archivo");
		ayuda=new JMenu("Ayuda");
		nuevaPartidaMaquina=new JMenuItem("Nueva partida VS Maquina");
		nuevaPartidaJugador=new JMenuItem("Nueva partida VS Jugador");
		salir=new JMenuItem("Salir");
		reglas=new JMenuItem("Reglas");
		
		barraMenu.add(archivo);
		barraMenu.add(ayuda);
		archivo.add(nuevaPartidaMaquina);
		archivo.add(nuevaPartidaJugador);
		archivo.add(salir);
		ayuda.add(reglas);
		
		//Cuando pulsamos Partida VS Maquina nose generara 6 colores aleatorios i los guaradara en una array, i estos se asignaran como background
		//Los botones se descativaran
		//generaremos las piezas con los colores que emos generado
		nuevaPartidaMaquina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				coloresDisponibles=generarColoresAleatorio();
				activarDesactivar(false);
				tglbtnClr1.setBackground(new Color(coloresDisponibles[0]));
				tglbtnClr2.setBackground(new Color(coloresDisponibles[1]));
				tglbtnClr3.setBackground(new Color(coloresDisponibles[2]));
				tglbtnClr4.setBackground(new Color(coloresDisponibles[3]));
				tglbtnClr5.setBackground(new Color(coloresDisponibles[4]));
				tglbtnClr6.setBackground(new Color(coloresDisponibles[5]));
				btnGen.setVisible(false);
				lblError.setVisible(false);
				piezasGeneradas=Funciones.generarPiezas(coloresDisponibles);
				addBackground(piezasGeneradas);
								
		}});
		
		//Cuando pulsamos Partida VS Persona nose tendemos los botones activados, i tendremos que ir pulsano 1 a 1 i seleccionar los colores que queremos nosotros 
		//Una vez hayamos seleccionado todos los colores, pulsaremos para que se genere el patron, y se descativaran los botones
		//generaremos las piezas con los colores que emos generado
		nuevaPartidaJugador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				activarDesactivar(true);
				btnGen.setVisible(true);
				lblError.setVisible(true);
		}});
		
		frame.setJMenuBar(barraMenu);
		
		panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 714, 439));
		panel.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 26, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 25, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 59, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 245, SpringLayout.WEST, panel);
		panel_2.setBorder(null);
		panel_2.setBackground(SystemColor.menu);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1_1 = new JToggleButton("");
		tglbtnClr1_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1_1.setBackground(Color.WHITE);
		panel_2.add(tglbtnClr1_1);
		
		tglbtnClr2_1 = new JToggleButton("");
		tglbtnClr2_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2_1.setBackground(Color.WHITE);
		panel_2.add(tglbtnClr2_1);
		
		tglbtnClr3_1 = new JToggleButton("");
		tglbtnClr3_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3_1.setBackground(Color.WHITE);
		panel_2.add(tglbtnClr3_1);
		
		tglbtnClr4_1 = new JToggleButton("");
		tglbtnClr4_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4_1.setBackground(Color.WHITE);
		panel_2.add(tglbtnClr4_1);
		
		tglbtnClr5_1 = new JToggleButton("");
		tglbtnClr5_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5_1.setBackground(Color.WHITE);
		panel_2.add(tglbtnClr5_1);
		
		tglbtnClr6_1 = new JToggleButton("");
		tglbtnClr6_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6_1.setBackground(Color.WHITE);
		panel_2.add(tglbtnClr6_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(new Rectangle(717, 0, 257, 439));
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 30, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -29, SpringLayout.EAST, panel_1);
		panel_3.setBorder(null);
		panel_3.setBackground(SystemColor.menu);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1 = new JToggleButton("");
		tglbtnClr1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr1);
		
		
		//Si los botones estan activados, pulsaremos y se abrira una ventan de selector de color para asignarlo color a este
		//Todos los botones son iguales
		tglbtnClr1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr1.setBackground(colorPicker());
				coloresDisponibles[0]=tglbtnClr1.getBackground().getRGB();
				tglbtnClr1.setSelected(false);	
		}});	
		
		tglbtnClr2 = new JToggleButton("");
		tglbtnClr2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr2);
		
		tglbtnClr2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr2.setBackground(colorPicker());
				coloresDisponibles[1]=tglbtnClr2.getBackground().getRGB();
				tglbtnClr2.setSelected(false);	
		}});
		
		tglbtnClr3 = new JToggleButton("");
		tglbtnClr3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr3);
		
		tglbtnClr3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr3.setBackground(colorPicker());
				coloresDisponibles[2]=tglbtnClr3.getBackground().getRGB();
				tglbtnClr3.setSelected(false);	
		}});
		
		tglbtnClr4 = new JToggleButton("");
		tglbtnClr4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr4);
		
		tglbtnClr4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr4.setBackground(colorPicker());
				coloresDisponibles[3]=tglbtnClr4.getBackground().getRGB();
				tglbtnClr4.setSelected(false);	
		}});
		
		tglbtnClr5 = new JToggleButton("");
		tglbtnClr5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr5);
		
		tglbtnClr5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr5.setBackground(colorPicker());
				coloresDisponibles[4]=tglbtnClr5.getBackground().getRGB();
				tglbtnClr5.setSelected(false);	
		}});
		
		tglbtnClr6 = new JToggleButton("");
		tglbtnClr6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr6);
		
		tglbtnClr6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr6.setBackground(colorPicker());
				coloresDisponibles[5]=tglbtnClr6.getBackground().getRGB();
				tglbtnClr6.setSelected(false);	
		}});
		
		lblColores = new JLabel("Colores disponibles: ");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblColores, 0, SpringLayout.WEST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblColores, -6, SpringLayout.NORTH, panel_3);
		panel_1.add(lblColores);
		
		btnGen = new JButton("Generar patrón");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, btnGen);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnGen, 69, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnGen, -29, SpringLayout.EAST, panel_1);
		panel_1.add(btnGen);
		
		//SI estemos jugando vs jugador este boton se muestra
		//Comprovara que los botnoes tienen un color seleccionado
		//Si estan todos seleccionados genrara el patron
		btnGen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				//
				if(coloresDisponibles[0]==null|| coloresDisponibles[1]==null || coloresDisponibles[2]==null || coloresDisponibles[3]==null || coloresDisponibles[4]==null || coloresDisponibles[5]==null) {
					lblError.setText("*Hay algun color sin seleccionar.");
				}else {
					lblError.setText("");
					piezasGeneradas=Funciones.generarPiezas(coloresDisponibles);
					addBackground(piezasGeneradas);
				}
		}});
		
		lblCombinacion = new JLabel("Combinación secreta: ");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblCombinacion, 0, SpringLayout.WEST, panel_3);
		panel_1.add(lblCombinacion);
		
		panel_4 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblCombinacion, -6, SpringLayout.NORTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 28, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, -29, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_4);
		panel_4.setVisible(false);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -258, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 148, SpringLayout.NORTH, panel_1);
		panel_4.setBorder(null);
		panel_4.setBackground(SystemColor.menu);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1S = new JToggleButton("");
		tglbtnClr1S.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1S.setEnabled(false);
		tglbtnClr1S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr1S);
		
		tglbtnClr2S = new JToggleButton("");
		tglbtnClr2S.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2S.setEnabled(false);
		tglbtnClr2S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr2S);
		
		tglbtnClr3S = new JToggleButton("");
		tglbtnClr3S.setBorder(new LineBorder(new Color(240, 240, 240), 3));
		tglbtnClr3S.setEnabled(false);
		tglbtnClr3S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr3S);
		
		tglbtnClr4S = new JToggleButton("");
		tglbtnClr4S.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4S.setEnabled(false);
		tglbtnClr4S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr4S);
		
		tglbtnClr5S = new JToggleButton("");
		tglbtnClr5S.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5S.setEnabled(false);
		tglbtnClr5S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr5S);
		
		tglbtnClr6S = new JToggleButton("");
		tglbtnClr6S.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6S.setEnabled(false);
		tglbtnClr6S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr6S);
		
		lblError = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.EAST, lblError, -29, SpringLayout.EAST, panel_1);
		lblError.setForeground(Color.RED);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblError, 6, SpringLayout.SOUTH, btnGen);
		lblError.setBackground(Color.WHITE);
		panel_1.add(lblError);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		
		panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 26, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, 0, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, -94, SpringLayout.EAST, panel);
		panel_5.setBorder(null);
		panel_5.setBackground(SystemColor.menu);
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1S_1 = new JToggleButton("");
		tglbtnClr1S_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1S_1.setEnabled(false);
		tglbtnClr1S_1.setBackground(Color.WHITE);
		panel_5.add(tglbtnClr1S_1);
		
		tglbtnClr2S_1 = new JToggleButton("");
		tglbtnClr2S_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2S_1.setEnabled(false);
		tglbtnClr2S_1.setBackground(Color.WHITE);
		panel_5.add(tglbtnClr2S_1);
		
		tglbtnClr3S_1 = new JToggleButton("");
		tglbtnClr3S_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3S_1.setEnabled(false);
		tglbtnClr3S_1.setBackground(Color.WHITE);
		panel_5.add(tglbtnClr3S_1);
		
		tglbtnClr4S_1 = new JToggleButton("");
		tglbtnClr4S_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4S_1.setEnabled(false);
		tglbtnClr4S_1.setBackground(Color.WHITE);
		panel_5.add(tglbtnClr4S_1);
		
		tglbtnClr5S_1 = new JToggleButton("");
		tglbtnClr5S_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5S_1.setEnabled(false);
		tglbtnClr5S_1.setBackground(Color.WHITE);
		panel_5.add(tglbtnClr5S_1);
		
		tglbtnClr6S_1 = new JToggleButton("");
		tglbtnClr6S_1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6S_1.setEnabled(false);
		tglbtnClr6S_1.setBackground(Color.WHITE);
		panel_5.add(tglbtnClr6S_1);
		
		btnNewButton = new JButton("Corregir");
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 55, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 26, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 29, SpringLayout.EAST, panel_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -380, SpringLayout.SOUTH, panel);
		panel.add(btnNewButton);
		frame.getContentPane().add(panel_1);
		
	}
	
	//funcion para que abra ventana se selector de color
	public static Color colorPicker() {
		
		JPanel contentPane= new JPanel();
		contentPane.setVisible(true);
		Color color=JColorChooser.showDialog(contentPane, "Elige un color", Color.BLACK);
		
		return color;
	}
	
	//Generacion de colores aleatorios RGB
	public static Integer[] generarColoresAleatorio() {
		Integer[] colores= new Integer[3];
		Integer[] coloresRGB= new Integer[6];
		Color color;
		for(int i=0;i<coloresRGB.length;i++) {
			colores[0]=(int)Math.floor(Math.random() * 255);
			colores[1]=(int)Math.floor(Math.random() * 255);
			colores[2]=(int)Math.floor(Math.random() * 255);
			color=new Color(colores[0], colores[1], colores[2]);
			coloresRGB[i]=color.getRGB();
		}
		return coloresRGB;
	}
	
	//Activar y desactivar los botones 
	public static void activarDesactivar(boolean estado) {
		tglbtnClr1.setEnabled(estado);
		tglbtnClr2.setEnabled(estado);
		tglbtnClr3.setEnabled(estado);
		tglbtnClr4.setEnabled(estado);
		tglbtnClr5.setEnabled(estado);
		tglbtnClr6.setEnabled(estado);
	}
	
	//anadir el background a los botones secretos
	public static void addBackground(Pieza[] colores) {
		tglbtnClr1S.setBackground(new Color(colores[0].getColor()));
		tglbtnClr2S.setBackground(new Color(colores[1].getColor()));
		tglbtnClr3S.setBackground(new Color(colores[2].getColor()));
		tglbtnClr4S.setBackground(new Color(colores[3].getColor()));
		tglbtnClr5S.setBackground(new Color(colores[4].getColor()));
		tglbtnClr6S.setBackground(new Color(colores[5].getColor()));
	}
}
