package team4.tm04;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private static Integer[] coloresDisponibles=new Integer[6];
	private static Integer[] respuesta=new Integer[6];
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
	static Pieza[] piezasJUgador;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> piezasHistorial=new ArrayList<>();
	private static int pos=0;

	//turno 1
	private static JToggleButton tglbtnClr1Turno1;
	private static JToggleButton tglbtnClr2Turno1;
	private static JToggleButton tglbtnClr3Turno1;
	private static JToggleButton tglbtnClr4Turno1;
	private static JToggleButton tglbtnClr5Turno1;
	private static JToggleButton tglbtnClr6Turno1;
	private static JToggleButton tglbtnPista1Turno1;
	private static JToggleButton tglbtnPista2Turno1;
	private static JToggleButton tglbtnPista3Turno1;
	private static JToggleButton tglbtnPista4Turno1;
	private static JToggleButton tglbtnPista5Turno1;
	private static JToggleButton tglbtnPista6Turno1;
		
	//turno2
	private static JToggleButton tglbtnClr1Turno2;
	private static JToggleButton tglbtnClr2Turno2;
	private static JToggleButton tglbtnClr3Turno2;
	private static JToggleButton tglbtnClr4Turno2;
	private static JToggleButton tglbtnClr5Turno2;
	private static JToggleButton tglbtnClr6Turno2;
	private static JToggleButton tglbtnPista1Turno2;
	private static JToggleButton tglbtnPista2Turno2;
	private static JToggleButton tglbtnPista3Turno2;
	private static JToggleButton tglbtnPista4Turno2;
	private static JToggleButton tglbtnPista5Turno2;
	private static JToggleButton tglbtnPista6Turno2;
	
	//turno3
	private static JToggleButton tglbtnClr1Turno3;
	private static JToggleButton tglbtnClr2Turno3;
	private static JToggleButton tglbtnClr3Turno3;
	private static JToggleButton tglbtnClr4Turno3;
	private static JToggleButton tglbtnClr5Turno3;
	private static JToggleButton tglbtnClr6Turno3;
	private static JToggleButton tglbtnPista1Turno3;
	private static JToggleButton tglbtnPista2Turno3;
	private static JToggleButton tglbtnPista3Turno3;
	private static JToggleButton tglbtnPista4Turno3;
	private static JToggleButton tglbtnPista5Turno3;
	private static JToggleButton tglbtnPista6Turno3;
	
	//tunro4
	private static JToggleButton tglbtnClr1Turno4;
	private static JToggleButton tglbtnClr2Turno4;
	private static JToggleButton tglbtnClr3Turno4;
	private static JToggleButton tglbtnClr4Turno4;
	private static JToggleButton tglbtnClr5Turno4;
	private static JToggleButton tglbtnClr6Turno4;
	private static JToggleButton tglbtnPista1Turno4;
	private static JToggleButton tglbtnPista2Turno4;
	private static JToggleButton tglbtnPista3Turno4;
	private static JToggleButton tglbtnPista4Turno4;
	private static JToggleButton tglbtnPista5Turno4;
	private static JToggleButton tglbtnPista6Turno4;
	
	//turno5
	private static JToggleButton tglbtnClr1Turno5;
	private static JToggleButton tglbtnClr2Turno5;
	private static JToggleButton tglbtnClr3Turno5;
	private static JToggleButton tglbtnClr4Turno5;
	private static JToggleButton tglbtnClr5Turno5;
	private static JToggleButton tglbtnClr6Turno5;
	private static JToggleButton tglbtnPista1Turno5;
	private static JToggleButton tglbtnPista2Turno5;
	private static JToggleButton tglbtnPista3Turno5;
	private static JToggleButton tglbtnPista4Turno5;
	private static JToggleButton tglbtnPista5Turno5;
	private static JToggleButton tglbtnPista6Turno5;
	
	//turno6
	 private static JToggleButton tglbtnClr1Turno6;
	 private static JToggleButton tglbtnClr2Turno6;
	 private static JToggleButton tglbtnClr3Turno6;
	 private static JToggleButton tglbtnClr4Turno6;
	 private static JToggleButton tglbtnClr5Turno6;
	 private static JToggleButton tglbtnClr6Turno6;
	 private static JToggleButton tglbtnPista1Turno6;
	 private static JToggleButton tglbtnPista2Turno6;
	 private static JToggleButton tglbtnPista3Turno6;
	 private static JToggleButton tglbtnPista4Turno6;
	 private static JToggleButton tglbtnPista5Turno6;
	 private static JToggleButton tglbtnPista6Turno6;
	 
	 //panels trons
	 JPanel panel_turno1;
	 JPanel panel_turno2;
	 JPanel panel_turno3;
	 JPanel panel_turno4;
	 JPanel panel_turno5;
	 JPanel panel_turno6;

	 
	 
	 
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
				activarDesactivar(false,0);
				tglbtnClr1.setBackground(new Color(coloresDisponibles[0]));
				tglbtnClr2.setBackground(new Color(coloresDisponibles[1]));
				tglbtnClr3.setBackground(new Color(coloresDisponibles[2]));
				tglbtnClr4.setBackground(new Color(coloresDisponibles[3]));
				tglbtnClr5.setBackground(new Color(coloresDisponibles[4]));
				tglbtnClr6.setBackground(new Color(coloresDisponibles[5]));
				btnGen.setVisible(false);
				lblError.setVisible(false);
				piezasGeneradas=Funciones.generarPiezas(coloresDisponibles,true);
				addBackground(piezasGeneradas);
				activarDesactivar(true, 1);
				panel_turno1.setVisible(true);				
		}});
		
		//Cuando pulsamos Partida VS Persona nose tendemos los botones activados, i tendremos que ir pulsano 1 a 1 i seleccionar los colores que queremos nosotros 
		//Una vez hayamos seleccionado todos los colores, pulsaremos para que se genere el patron, y se descativaran los botones
		//generaremos las piezas con los colores que emos generado
		nuevaPartidaJugador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				activarDesactivar(true,0);
				btnGen.setVisible(true);
				lblError.setVisible(true);
		}});
		
		frame.setJMenuBar(barraMenu);
		
		panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 685, 439));
		panel.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(new Rectangle(684, 0, 300, 439));
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
		
		
		tglbtnClr2 = new JToggleButton("");
		tglbtnClr2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr2);
		
		tglbtnClr3 = new JToggleButton("");
		tglbtnClr3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr3);
		
		tglbtnClr4 = new JToggleButton("");
		tglbtnClr4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr4);
		
		tglbtnClr5 = new JToggleButton("");
		tglbtnClr5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr5);
		
		tglbtnClr6 = new JToggleButton("");
		tglbtnClr6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr6);
		
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
					piezasGeneradas=Funciones.generarPiezas(coloresDisponibles,true);
					addBackground(piezasGeneradas);
					panel_turno1.setVisible(true);		
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
			
		panel_turno1 = new JPanel();
		panel_turno1.setVisible(false);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno1, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno1, -377, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno1, -39, SpringLayout.EAST, panel);
		panel.add(panel_turno1);
		
		JPanel panel_2_turno1 = new JPanel();
		panel_2_turno1.setBorder(null);
		panel_2_turno1.setBackground(SystemColor.menu);
		panel_2_turno1.setLayout(new GridLayout(1, 0, 0, 0));
			
		tglbtnClr1Turno1 = new JToggleButton("");
		tglbtnClr1Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1Turno1.setBackground(Color.WHITE);
		panel_2_turno1.add(tglbtnClr1Turno1);
		
		tglbtnClr2Turno1 = new JToggleButton("");
		tglbtnClr2Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2Turno1.setBackground(Color.WHITE);
		panel_2_turno1.add(tglbtnClr2Turno1);
		
		tglbtnClr3Turno1 = new JToggleButton("");
		tglbtnClr3Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3Turno1.setBackground(Color.WHITE);
		panel_2_turno1.add(tglbtnClr3Turno1);
		
		tglbtnClr4Turno1 = new JToggleButton("");
		tglbtnClr4Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4Turno1.setBackground(Color.WHITE);
		panel_2_turno1.add(tglbtnClr4Turno1);
		
		tglbtnClr5Turno1 = new JToggleButton("");
		tglbtnClr5Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5Turno1.setBackground(Color.WHITE);
		panel_2_turno1.add(tglbtnClr5Turno1);
		
		tglbtnClr6Turno1 = new JToggleButton("");
		tglbtnClr6Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6Turno1.setBackground(Color.WHITE);
		panel_2_turno1.add(tglbtnClr6Turno1);
		
		JButton btnCorregitTurno1 = new JButton("Corregir");
		btnCorregitTurno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				piezasJUgador=Funciones.generarPiezas(respuesta, false);
				boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
			}
		});
		
		JPanel panel_5_turno1 = new JPanel();
		panel_5_turno1.setBorder(null);
		panel_5_turno1.setBackground(SystemColor.menu);
		panel_5_turno1.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		/*
		 *
		 * private static JToggleButton tglbtnPista1Turno1
		 */
		
		tglbtnPista1Turno1 = new JToggleButton("");
		tglbtnPista1Turno1.setEnabled(false);
		tglbtnPista1Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista1Turno1.setBackground(Color.WHITE);
		panel_5_turno1.add(tglbtnPista1Turno1);
		
		tglbtnPista2Turno1 = new JToggleButton("");
		tglbtnPista2Turno1.setEnabled(false);
		tglbtnPista2Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista2Turno1.setBackground(Color.WHITE);
		panel_5_turno1.add(tglbtnPista2Turno1);
		
		tglbtnPista3Turno1 = new JToggleButton("");
		tglbtnPista3Turno1.setEnabled(false);
		tglbtnPista3Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista3Turno1.setBackground(Color.WHITE);
		panel_5_turno1.add(tglbtnPista3Turno1);
		
		tglbtnPista4Turno1 = new JToggleButton("");
		tglbtnPista4Turno1.setEnabled(false);
		tglbtnPista4Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista4Turno1.setBackground(Color.WHITE);
		panel_5_turno1.add(tglbtnPista4Turno1);
		
		tglbtnPista5Turno1 = new JToggleButton("");
		tglbtnPista5Turno1.setEnabled(false);
		tglbtnPista5Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista5Turno1.setBackground(Color.WHITE);
		panel_5_turno1.add(tglbtnPista5Turno1);
		
		tglbtnPista6Turno1 = new JToggleButton("");
		tglbtnPista6Turno1.setEnabled(false);
		tglbtnPista6Turno1.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista6Turno1.setBackground(Color.WHITE);
		panel_5_turno1.add(tglbtnPista6Turno1);
		
		GroupLayout gl_panel_turno1 = new GroupLayout(panel_turno1);
		gl_panel_turno1.setHorizontalGroup(
			gl_panel_turno1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2_turno1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCorregitTurno1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(panel_5_turno1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno1.setVerticalGroup(
			gl_panel_turno1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorregitTurno1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_turno1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_turno1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_turno1.setLayout(gl_panel_turno1);
		
		panel_turno2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno2, 6, SpringLayout.SOUTH, panel_turno1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno2, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno2, 0, SpringLayout.EAST, panel_turno1);
		panel_turno2.setVisible(false);
		panel.add(panel_turno2);
		
		JPanel panel_2_turno2 = new JPanel();
		panel_2_turno2.setBorder(null);
		panel_2_turno2.setBackground(SystemColor.menu);
		panel_2_turno2.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1Turno2 = new JToggleButton("");
		tglbtnClr1Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1Turno2.setBackground(Color.WHITE);
		panel_2_turno2.add(tglbtnClr1Turno2);
		
		tglbtnClr2Turno2 = new JToggleButton("");
		tglbtnClr2Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2Turno2.setBackground(Color.WHITE);
		panel_2_turno2.add(tglbtnClr2Turno2);
		
		tglbtnClr3Turno2 = new JToggleButton("");
		tglbtnClr3Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3Turno2.setBackground(Color.WHITE);
		panel_2_turno2.add(tglbtnClr3Turno2);
		
		tglbtnClr4Turno2 = new JToggleButton("");
		tglbtnClr4Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4Turno2.setBackground(Color.WHITE);
		panel_2_turno2.add(tglbtnClr4Turno2);
		
		tglbtnClr5Turno2 = new JToggleButton("");
		tglbtnClr5Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5Turno2.setBackground(Color.WHITE);
		panel_2_turno2.add(tglbtnClr5Turno2);
		
		tglbtnClr6Turno2 = new JToggleButton("");
		tglbtnClr6Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6Turno2.setBackground(Color.WHITE);
		panel_2_turno2.add(tglbtnClr6Turno2);
		
		JButton btnCorregitTurno2 = new JButton("Corregir");
		
		JPanel panel_5_turno2 = new JPanel();
		panel_5_turno2.setBorder(null);
		panel_5_turno2.setBackground(SystemColor.menu);
		panel_5_turno2.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnPista1Turno2 = new JToggleButton("");
		tglbtnPista1Turno2.setEnabled(false);
		tglbtnPista1Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista1Turno2.setBackground(Color.WHITE);
		panel_5_turno2.add(tglbtnPista1Turno2);
		
		tglbtnPista2Turno2 = new JToggleButton("");
		tglbtnPista2Turno2.setEnabled(false);
		tglbtnPista2Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista2Turno2.setBackground(Color.WHITE);
		panel_5_turno2.add(tglbtnPista2Turno2);
		
		tglbtnPista3Turno2 = new JToggleButton("");
		tglbtnPista3Turno2.setEnabled(false);
		tglbtnPista3Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista3Turno2.setBackground(Color.WHITE);
		panel_5_turno2.add(tglbtnPista3Turno2);
		
		tglbtnPista4Turno2 = new JToggleButton("");
		tglbtnPista4Turno2.setEnabled(false);
		tglbtnPista4Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista4Turno2.setBackground(Color.WHITE);
		panel_5_turno2.add(tglbtnPista4Turno2);
		
		tglbtnPista5Turno2 = new JToggleButton("");
		tglbtnPista5Turno2.setEnabled(false);
		tglbtnPista5Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista5Turno2.setBackground(Color.WHITE);
		panel_5_turno2.add(tglbtnPista5Turno2);
		
		tglbtnPista6Turno2 = new JToggleButton("");
		tglbtnPista6Turno2.setEnabled(false);
		tglbtnPista6Turno2.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista6Turno2.setBackground(Color.WHITE);
		panel_5_turno2.add(tglbtnPista6Turno2);
		GroupLayout gl_panel_turno2 = new GroupLayout(panel_turno2);
		gl_panel_turno2.setHorizontalGroup(
			gl_panel_turno2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2_turno2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCorregitTurno2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(panel_5_turno2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno2.setVerticalGroup(
			gl_panel_turno2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panel_turno2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorregitTurno2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_turno2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_turno2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_turno2.setLayout(gl_panel_turno2);
		
		panel_turno3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno3, 6, SpringLayout.SOUTH, panel_turno2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno3, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno3, -39, SpringLayout.EAST, panel);
		panel_turno3.setVisible(false);
		panel.add(panel_turno3);
		
		JPanel panel_2_turno3 = new JPanel();
		panel_2_turno3.setBorder(null);
		panel_2_turno3.setBackground(SystemColor.menu);
		panel_2_turno3.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1Turno3 = new JToggleButton("");
		tglbtnClr1Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1Turno3.setBackground(Color.WHITE);
		panel_2_turno3.add(tglbtnClr1Turno3);
		
		tglbtnClr2Turno3 = new JToggleButton("");
		tglbtnClr2Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2Turno3.setBackground(Color.WHITE);
		panel_2_turno3.add(tglbtnClr2Turno3);
		
		tglbtnClr3Turno3 = new JToggleButton("");
		tglbtnClr3Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3Turno3.setBackground(Color.WHITE);
		panel_2_turno3.add(tglbtnClr3Turno3);
		
		tglbtnClr4Turno3 = new JToggleButton("");
		tglbtnClr4Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4Turno3.setBackground(Color.WHITE);
		panel_2_turno3.add(tglbtnClr4Turno3);
		
		tglbtnClr5Turno3 = new JToggleButton("");
		tglbtnClr5Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5Turno3.setBackground(Color.WHITE);
		panel_2_turno3.add(tglbtnClr5Turno3);
		
		tglbtnClr6Turno3 = new JToggleButton("");
		tglbtnClr6Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6Turno3.setBackground(Color.WHITE);
		panel_2_turno3.add(tglbtnClr6Turno3);
		
		JButton btnCorregitTurno3 = new JButton("Corregir");
		
		JPanel panel_5_turno3 = new JPanel();
		panel_5_turno3.setBorder(null);
		panel_5_turno3.setBackground(SystemColor.menu);
		panel_5_turno3.setLayout(new GridLayout(1, 0, 0, 0));
		

		
		tglbtnPista1Turno3 = new JToggleButton("");
		tglbtnPista1Turno3.setEnabled(false);
		tglbtnPista1Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista1Turno3.setBackground(Color.WHITE);
		panel_5_turno3.add(tglbtnPista1Turno3);
		
		tglbtnPista2Turno3 = new JToggleButton("");
		tglbtnPista2Turno3.setEnabled(false);
		tglbtnPista2Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista2Turno3.setBackground(Color.WHITE);
		panel_5_turno3.add(tglbtnPista2Turno3);
		
		tglbtnPista3Turno3 = new JToggleButton("");
		tglbtnPista3Turno3.setEnabled(false);
		tglbtnPista3Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista3Turno3.setBackground(Color.WHITE);
		panel_5_turno3.add(tglbtnPista3Turno3);
		
		tglbtnPista4Turno3 = new JToggleButton("");
		tglbtnPista4Turno3.setEnabled(false);
		tglbtnPista4Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista4Turno3.setBackground(Color.WHITE);
		panel_5_turno3.add(tglbtnPista4Turno3);
		
		tglbtnPista5Turno3 = new JToggleButton("");
		tglbtnPista5Turno3.setEnabled(false);
		tglbtnPista5Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista5Turno3.setBackground(Color.WHITE);
		panel_5_turno3.add(tglbtnPista5Turno3);
		
		tglbtnPista6Turno3 = new JToggleButton("");
		tglbtnPista6Turno3.setEnabled(false);
		tglbtnPista6Turno3.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista6Turno3.setBackground(Color.WHITE);
		panel_5_turno3.add(tglbtnPista6Turno3);
		GroupLayout gl_panel_turno3 = new GroupLayout(panel_turno3);
		gl_panel_turno3.setHorizontalGroup(
			gl_panel_turno3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2_turno3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCorregitTurno3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(panel_5_turno3, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno3.setVerticalGroup(
			gl_panel_turno3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panel_turno3.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorregitTurno3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_turno3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_turno3, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_turno3.setLayout(gl_panel_turno3);
		
		panel_turno4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno4, 6, SpringLayout.SOUTH, panel_turno3);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno4, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno4, 0, SpringLayout.EAST, panel_turno1);
		panel_turno4.setVisible(false);
		panel.add(panel_turno4);
		
		JPanel panel_2_turno4 = new JPanel();
		panel_2_turno4.setBorder(null);
		panel_2_turno4.setBackground(SystemColor.menu);
		panel_2_turno4.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1Turno4 = new JToggleButton("");
		tglbtnClr1Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1Turno4.setBackground(Color.WHITE);
		panel_2_turno4.add(tglbtnClr1Turno4);
		
		tglbtnClr2Turno4 = new JToggleButton("");
		tglbtnClr2Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2Turno4.setBackground(Color.WHITE);
		panel_2_turno4.add(tglbtnClr2Turno4);
		
		tglbtnClr3Turno4 = new JToggleButton("");
		tglbtnClr3Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3Turno4.setBackground(Color.WHITE);
		panel_2_turno4.add(tglbtnClr3Turno4);
		
		tglbtnClr4Turno4 = new JToggleButton("");
		tglbtnClr4Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4Turno4.setBackground(Color.WHITE);
		panel_2_turno4.add(tglbtnClr4Turno4);
		
		tglbtnClr5Turno4 = new JToggleButton("");
		tglbtnClr5Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5Turno4.setBackground(Color.WHITE);
		panel_2_turno4.add(tglbtnClr5Turno4);
		
		tglbtnClr6Turno4 = new JToggleButton("");
		tglbtnClr6Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6Turno4.setBackground(Color.WHITE);
		panel_2_turno4.add(tglbtnClr6Turno4);
		
		JButton btnCorregitTurno4 = new JButton("Corregir");
		
		JPanel panel_5_turno4 = new JPanel();
		panel_5_turno4.setBorder(null);
		panel_5_turno4.setBackground(SystemColor.menu);
		panel_5_turno4.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnPista1Turno4 = new JToggleButton("");
		tglbtnPista1Turno4.setEnabled(false);
		tglbtnPista1Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista1Turno4.setBackground(Color.WHITE);
		panel_5_turno4.add(tglbtnPista1Turno4);
		
		tglbtnPista2Turno4 = new JToggleButton("");
		tglbtnPista2Turno4.setEnabled(false);
		tglbtnPista2Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista2Turno4.setBackground(Color.WHITE);
		panel_5_turno4.add(tglbtnPista2Turno4);
		
		tglbtnPista3Turno4 = new JToggleButton("");
		tglbtnPista3Turno4.setEnabled(false);
		tglbtnPista3Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista3Turno4.setBackground(Color.WHITE);
		panel_5_turno4.add(tglbtnPista3Turno4);
		
		tglbtnPista4Turno4 = new JToggleButton("");
		tglbtnPista4Turno4.setEnabled(false);
		tglbtnPista4Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista4Turno4.setBackground(Color.WHITE);
		panel_5_turno4.add(tglbtnPista4Turno4);
		
		tglbtnPista5Turno4 = new JToggleButton("");
		tglbtnPista5Turno4.setEnabled(false);
		tglbtnPista5Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista5Turno4.setBackground(Color.WHITE);
		panel_5_turno4.add(tglbtnPista5Turno4);
		
		tglbtnPista6Turno4 = new JToggleButton("");
		tglbtnPista6Turno4.setEnabled(false);
		tglbtnPista6Turno4.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista6Turno4.setBackground(Color.WHITE);
		panel_5_turno4.add(tglbtnPista6Turno4);
		GroupLayout gl_panel_turno4 = new GroupLayout(panel_turno4);
		gl_panel_turno4.setHorizontalGroup(
			gl_panel_turno4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2_turno4, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCorregitTurno4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(panel_5_turno4, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno4.setVerticalGroup(
			gl_panel_turno4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panel_turno4.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorregitTurno4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_turno4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_turno4, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_turno4.setLayout(gl_panel_turno4);
		
		panel_turno5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno5, 6, SpringLayout.SOUTH, panel_turno4);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno5, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno5, 0, SpringLayout.EAST, panel_turno1);
		panel_turno5.setVisible(false);
		panel.add(panel_turno5);
		
		JPanel panel_2_turno5 = new JPanel();
		panel_2_turno5.setBorder(null);
		panel_2_turno5.setBackground(SystemColor.menu);
		panel_2_turno5.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1Turno5 = new JToggleButton("");
		tglbtnClr1Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1Turno5.setBackground(Color.WHITE);
		panel_2_turno5.add(tglbtnClr1Turno5);
		
		tglbtnClr2Turno5 = new JToggleButton("");
		tglbtnClr2Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2Turno5.setBackground(Color.WHITE);
		panel_2_turno5.add(tglbtnClr2Turno5);
		
		tglbtnClr3Turno5 = new JToggleButton("");
		tglbtnClr3Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3Turno5.setBackground(Color.WHITE);
		panel_2_turno5.add(tglbtnClr3Turno5);
		
		tglbtnClr4Turno5 = new JToggleButton("");
		tglbtnClr4Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4Turno5.setBackground(Color.WHITE);
		panel_2_turno5.add(tglbtnClr4Turno5);
		
		tglbtnClr5Turno5 = new JToggleButton("");
		tglbtnClr5Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5Turno5.setBackground(Color.WHITE);
		panel_2_turno5.add(tglbtnClr5Turno5);
		
		tglbtnClr6Turno5 = new JToggleButton("");
		tglbtnClr6Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6Turno5.setBackground(Color.WHITE);
		panel_2_turno5.add(tglbtnClr6Turno5);
		
		JButton btnCorregitTurno5 = new JButton("Corregir");
		
		JPanel panel_5_turno5 = new JPanel();
		panel_5_turno5.setBorder(null);
		panel_5_turno5.setBackground(SystemColor.menu);
		panel_5_turno5.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnPista1Turno5 = new JToggleButton("");
		tglbtnPista1Turno5.setEnabled(false);
		tglbtnPista1Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista1Turno5.setBackground(Color.WHITE);
		panel_5_turno5.add(tglbtnPista1Turno5);
		
		tglbtnPista2Turno5 = new JToggleButton("");
		tglbtnPista2Turno5.setEnabled(false);
		tglbtnPista2Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista2Turno5.setBackground(Color.WHITE);
		panel_5_turno5.add(tglbtnPista2Turno5);
		
		tglbtnPista3Turno5 = new JToggleButton("");
		tglbtnPista3Turno5.setEnabled(false);
		tglbtnPista3Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista3Turno5.setBackground(Color.WHITE);
		panel_5_turno5.add(tglbtnPista3Turno5);
		
		tglbtnPista4Turno5 = new JToggleButton("");
		tglbtnPista4Turno5.setEnabled(false);
		tglbtnPista4Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista4Turno5.setBackground(Color.WHITE);
		panel_5_turno5.add(tglbtnPista4Turno5);
		
		tglbtnPista5Turno5 = new JToggleButton("");
		tglbtnPista5Turno5.setEnabled(false);
		tglbtnPista5Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista5Turno5.setBackground(Color.WHITE);
		panel_5_turno5.add(tglbtnPista5Turno5);
		
		tglbtnPista6Turno5 = new JToggleButton("");
		tglbtnPista6Turno5.setEnabled(false);
		tglbtnPista6Turno5.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista6Turno5.setBackground(Color.WHITE);
		panel_5_turno5.add(tglbtnPista6Turno5);
		GroupLayout gl_panel_turno5 = new GroupLayout(panel_turno5);
		gl_panel_turno5.setHorizontalGroup(
			gl_panel_turno5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno5.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2_turno5, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCorregitTurno5, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(panel_5_turno5, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno5.setVerticalGroup(
			gl_panel_turno5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panel_turno5.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno5.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorregitTurno5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_turno5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_turno5, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_turno5.setLayout(gl_panel_turno5);
		
		panel_turno6 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno6, 6, SpringLayout.SOUTH, panel_turno5);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno6, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno6, 0, SpringLayout.EAST, panel_turno1);
		panel_turno6.setVisible(false);
		panel.add(panel_turno6);
		
		JPanel panel_2_turno6 = new JPanel();
		panel_2_turno6.setBorder(null);
		panel_2_turno6.setBackground(SystemColor.menu);
		panel_2_turno6.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1Turno6 = new JToggleButton("");
		tglbtnClr1Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr1Turno6.setBackground(Color.WHITE);
		panel_2_turno6.add(tglbtnClr1Turno6);
		
		tglbtnClr2Turno6 = new JToggleButton("");
		tglbtnClr2Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr2Turno6.setBackground(Color.WHITE);
		panel_2_turno6.add(tglbtnClr2Turno6);
		
		tglbtnClr3Turno6 = new JToggleButton("");
		tglbtnClr3Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr3Turno6.setBackground(Color.WHITE);
		panel_2_turno6.add(tglbtnClr3Turno6);
		
		tglbtnClr4Turno6 = new JToggleButton("");
		tglbtnClr4Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr4Turno6.setBackground(Color.WHITE);
		panel_2_turno6.add(tglbtnClr4Turno6);
		
		tglbtnClr5Turno6 = new JToggleButton("");
		tglbtnClr5Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr5Turno6.setBackground(Color.WHITE);
		panel_2_turno6.add(tglbtnClr5Turno6);
		
		tglbtnClr6Turno6 = new JToggleButton("");
		tglbtnClr6Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnClr6Turno6.setBackground(Color.WHITE);
		panel_2_turno6.add(tglbtnClr6Turno6);
		
		JButton btnCorregitTurno6 = new JButton("Corregir");
		
		JPanel panel_5_turno6 = new JPanel();
		panel_5_turno6.setBorder(null);
		panel_5_turno6.setBackground(SystemColor.menu);
		panel_5_turno6.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnPista1Turno6 = new JToggleButton("");
		tglbtnPista1Turno6.setEnabled(false);
		tglbtnPista1Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista1Turno6.setBackground(Color.WHITE);
		panel_5_turno6.add(tglbtnPista1Turno6);
		
		tglbtnPista2Turno6 = new JToggleButton("");
		tglbtnPista2Turno6.setEnabled(false);
		tglbtnPista2Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista2Turno6.setBackground(Color.WHITE);
		panel_5_turno6.add(tglbtnPista2Turno6);
		
		tglbtnPista3Turno6 = new JToggleButton("");
		tglbtnPista3Turno6.setEnabled(false);
		tglbtnPista3Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista3Turno6.setBackground(Color.WHITE);
		panel_5_turno6.add(tglbtnPista3Turno6);
		
		tglbtnPista4Turno6 = new JToggleButton("");
		tglbtnPista4Turno6.setEnabled(false);
		tglbtnPista4Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista4Turno6.setBackground(Color.WHITE);
		panel_5_turno6.add(tglbtnPista4Turno6);
		
		tglbtnPista5Turno6 = new JToggleButton("");
		tglbtnPista5Turno6.setEnabled(false);
		tglbtnPista5Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista5Turno6.setBackground(Color.WHITE);
		panel_5_turno6.add(tglbtnPista5Turno6);
		
		tglbtnPista6Turno6 = new JToggleButton("");
		tglbtnPista6Turno6.setEnabled(false);
		tglbtnPista6Turno6.setBorder(new LineBorder(UIManager.getColor("ComboBox.buttonBackground"), 3));
		tglbtnPista6Turno6.setBackground(Color.WHITE);
		panel_5_turno6.add(tglbtnPista6Turno6);
		GroupLayout gl_panel_turno6 = new GroupLayout(panel_turno6);
		gl_panel_turno6.setHorizontalGroup(
			gl_panel_turno6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno6.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2_turno6, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCorregitTurno6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(panel_5_turno6, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno6.setVerticalGroup(
			gl_panel_turno6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panel_turno6.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno6.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorregitTurno6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_turno6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_turno6, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_turno6.setLayout(gl_panel_turno6);
		frame.getContentPane().add(panel_1);
		
		//Si los botones estan activados, pulsaremos y se abrira una ventan de selector de color para asignarlo color a este
		//Todos los botones son iguales
		tglbtnClr1.addActionListener(e -> botonColor(tglbtnClr1));
		tglbtnClr2.addActionListener(e -> botonColor(tglbtnClr2));
		tglbtnClr3.addActionListener(e -> botonColor(tglbtnClr3));
		tglbtnClr4.addActionListener(e -> botonColor(tglbtnClr4));
		tglbtnClr5.addActionListener(e -> botonColor(tglbtnClr5));
		tglbtnClr6.addActionListener(e -> botonColor(tglbtnClr6));
		
		tglbtnClr1Turno1.addMouseListener(mouseListener);
		tglbtnClr2Turno1.addMouseListener(mouseListener);
		tglbtnClr3Turno1.addMouseListener(mouseListener);
		tglbtnClr4Turno1.addMouseListener(mouseListener);
		tglbtnClr5Turno1.addMouseListener(mouseListener);
		tglbtnClr6Turno1.addMouseListener(mouseListener);
		
		tglbtnClr1Turno2.addMouseListener(mouseListener);
		tglbtnClr2Turno2.addMouseListener(mouseListener);
		tglbtnClr3Turno2.addMouseListener(mouseListener);
		tglbtnClr4Turno2.addMouseListener(mouseListener);
		tglbtnClr5Turno2.addMouseListener(mouseListener);
		tglbtnClr6Turno2.addMouseListener(mouseListener);
		
		tglbtnClr1Turno3.addMouseListener(mouseListener);
		tglbtnClr2Turno3.addMouseListener(mouseListener);
		tglbtnClr3Turno3.addMouseListener(mouseListener);
		tglbtnClr4Turno3.addMouseListener(mouseListener);
		tglbtnClr5Turno3.addMouseListener(mouseListener);
		tglbtnClr6Turno3.addMouseListener(mouseListener);
		
		tglbtnClr1Turno4.addMouseListener(mouseListener);
		tglbtnClr2Turno4.addMouseListener(mouseListener);
		tglbtnClr3Turno4.addMouseListener(mouseListener);
		tglbtnClr4Turno4.addMouseListener(mouseListener);
		tglbtnClr5Turno4.addMouseListener(mouseListener);
		tglbtnClr6Turno4.addMouseListener(mouseListener);
		
		tglbtnClr1Turno5.addMouseListener(mouseListener);
		tglbtnClr2Turno5.addMouseListener(mouseListener);
		tglbtnClr3Turno5.addMouseListener(mouseListener);
		tglbtnClr4Turno5.addMouseListener(mouseListener);
		tglbtnClr5Turno5.addMouseListener(mouseListener);
		tglbtnClr6Turno5.addMouseListener(mouseListener);
		
		tglbtnClr1Turno5.addMouseListener(mouseListener);
		tglbtnClr2Turno5.addMouseListener(mouseListener);
		tglbtnClr3Turno5.addMouseListener(mouseListener);
		tglbtnClr4Turno5.addMouseListener(mouseListener);
		tglbtnClr5Turno5.addMouseListener(mouseListener);
		tglbtnClr6Turno5.addMouseListener(mouseListener);
		
	}
	
	MouseListener mouseListener= new MouseListener() {

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == e.BUTTON3) {
            	pos--;
        		if(pos==0) {
        			pos=5;
        		}
        		
            }else if(e.getButton() == e.BUTTON1){
            	pos++;
        		if(pos>=6) {
        			pos=0;
        		}
            }else if(e.getButton() == e.BUTTON2){}
            System.out.println(pos);
            ((JToggleButton) e.getComponent()).setBackground(new Color(coloresDisponibles[pos]));
        	((JToggleButton) e.getComponent()).setSelected(false);	
        }
    };

	
	public static void botonColor(JToggleButton button) {
		button.setBackground(colorPicker());
		coloresDisponibles[pos]=button.getBackground().getRGB();
		button.setSelected(false);	
		pos++;
		if(pos==6) {
			pos=0;
		}
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
	public static void activarDesactivar(boolean estado, int torn) {
		
		switch (torn) {
		case 0:
			tglbtnClr1.setEnabled(estado);
			tglbtnClr2.setEnabled(estado);
			tglbtnClr3.setEnabled(estado);
			tglbtnClr4.setEnabled(estado);
			tglbtnClr5.setEnabled(estado);
			tglbtnClr6.setEnabled(estado);
			break;
		case 1:
			tglbtnClr1Turno1.setEnabled(estado);
			tglbtnClr2Turno1.setEnabled(estado);
			tglbtnClr3Turno1.setEnabled(estado);
			tglbtnClr4Turno1.setEnabled(estado);
			tglbtnClr5Turno1.setEnabled(estado);
			tglbtnClr6Turno1.setEnabled(estado);
			break;
		case 2:
			tglbtnClr1Turno2.setEnabled(estado);
			tglbtnClr2Turno2.setEnabled(estado);
			tglbtnClr3Turno2.setEnabled(estado);
			tglbtnClr4Turno2.setEnabled(estado);
			tglbtnClr5Turno2.setEnabled(estado);
			tglbtnClr6Turno2.setEnabled(estado);
			break;
		case 3:
			tglbtnClr1Turno3.setEnabled(estado);
			tglbtnClr2Turno3.setEnabled(estado);
			tglbtnClr3Turno3.setEnabled(estado);
			tglbtnClr4Turno3.setEnabled(estado);
			tglbtnClr5Turno3.setEnabled(estado);
			tglbtnClr6Turno3.setEnabled(estado);
			break;
		case 4:
			tglbtnClr1Turno4.setEnabled(estado);
			tglbtnClr2Turno4.setEnabled(estado);
			tglbtnClr3Turno4.setEnabled(estado);
			tglbtnClr4Turno4.setEnabled(estado);
			tglbtnClr5Turno4.setEnabled(estado);
			tglbtnClr6Turno4.setEnabled(estado);
			break;
		case 5:
			tglbtnClr1Turno5.setEnabled(estado);
			tglbtnClr2Turno5.setEnabled(estado);
			tglbtnClr3Turno5.setEnabled(estado);
			tglbtnClr4Turno5.setEnabled(estado);
			tglbtnClr5Turno5.setEnabled(estado);
			tglbtnClr6Turno5.setEnabled(estado);
			break;
		case 6:
			tglbtnClr1Turno6.setEnabled(estado);
			tglbtnClr2Turno6.setEnabled(estado);
			tglbtnClr3Turno6.setEnabled(estado);
			tglbtnClr4Turno6.setEnabled(estado);
			tglbtnClr5Turno6.setEnabled(estado);
			tglbtnClr6Turno6.setEnabled(estado);
			break;

		default:
			break;
		}
		
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
