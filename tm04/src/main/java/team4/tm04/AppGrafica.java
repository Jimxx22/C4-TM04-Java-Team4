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
import java.util.Iterator;
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
	private static boolean a=true;
	 
	 //panels trons
	 JPanel panel_turno1;
	 JPanel panel_turno2;
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
				activarDesactivar(false);
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
				panel_turno1.setVisible(true);	
				//activarDesactivar(true,1);
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
					activarDesactivar(false);
					//activarDesactivar(true,1);
					btnGen.setVisible(false);
					lblError.setVisible(false);
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
		
		JButton btnCorregitTurno1 = new JButton("Corregir");
		btnCorregitTurno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				respuesta[0]=tglbtnClr1Turno1.getBackground().getRGB();
//				respuesta[1]=tglbtnClr2Turno1.getBackground().getRGB();
//				respuesta[2]=tglbtnClr3Turno1.getBackground().getRGB();
//				respuesta[3]=tglbtnClr4Turno1.getBackground().getRGB();
//				respuesta[4]=tglbtnClr5Turno1.getBackground().getRGB();
//				respuesta[5]=tglbtnClr6Turno1.getBackground().getRGB();

				for (Integer integer : respuesta) {
					System.out.println(integer);
				}
				
				piezasJUgador=Funciones.generarPiezas(respuesta, false);
				boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
				
				if(!fin) {
					panel_turno2.setVisible(true);
				}
				
				for (int i = 0; i < piezasJUgador.length; i++) {
//					switch (i) {
//					case 0:
//						colorPista(tglbtnPista1Turno1, i);
//						break;
//					case 1:
//						colorPista(tglbtnPista2Turno1, i);
//						break;
//					case 2:
//						colorPista(tglbtnPista3Turno1, i);
//						break;
//					case 3:
//						colorPista(tglbtnPista4Turno1, i);
//						break;
//					case 4:
//						colorPista(tglbtnPista5Turno1, i);
//						break;
//					case 5:
//						colorPista(tglbtnPista6Turno1, i);
//						break;
//
//					default:
//						break;
//					}
					
				}
				
			}
		});
		
		panel1T1 = new JPanel();
		
		panel2T1 = new JPanel();
		
		panel3T1 = new JPanel();
		
		panel4T1 = new JPanel();
		
		panel5T1 = new JPanel();
		
		panel6T1 = new JPanel();
		
		panel6T1S = new JPanel();
		
		panel1T1S = new JPanel();
		
		panel1T6_9 = new JPanel();
		
		panel2T1S = new JPanel();
		
		panel4T1S = new JPanel();
		
		panel5T1S = new JPanel();
		
		GroupLayout gl_panel_turno1 = new GroupLayout(panel_turno1);
		gl_panel_turno1.setHorizontalGroup(
			gl_panel_turno1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel1T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel4T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel5T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel6T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnCorregitTurno1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel1T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel1T6_9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel4T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel5T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel6T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap()) 
		);
		gl_panel_turno1.setVerticalGroup(
			gl_panel_turno1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel1T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel6T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel5T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel4T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_turno1.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCorregitTurno1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel1T6_9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel2T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel4T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel5T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel6T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel1T1S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_turno1.setLayout(gl_panel_turno1);
		
		panel_turno2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno2, 6, SpringLayout.SOUTH, panel_turno1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno2, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno2, 0, SpringLayout.EAST, panel_turno1);
		panel_turno2.setVisible(false);
		panel.add(panel_turno2);
		
		JButton btnCorregitTurno2 = new JButton("Corregir");
		
		panel1T2 = new JPanel();
		
		panel2T2 = new JPanel();
		
		panel3T2 = new JPanel();
		
		panel4T2 = new JPanel();
		
		panel5T2 = new JPanel();
		
		panel6T2 = new JPanel();
		
		panel6T2S = new JPanel();
		
		panel5T2S = new JPanel();
		
		panel4T2S = new JPanel();
		
		panel3T2S = new JPanel();
		
		panel2T2S = new JPanel();
		
		panel1T2S = new JPanel();
		GroupLayout gl_panel_turno2 = new GroupLayout(panel_turno2);
		gl_panel_turno2.setHorizontalGroup(
			gl_panel_turno2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel1T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel4T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel5T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel6T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnCorregitTurno2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(panel1T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel4T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel5T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel6T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno2.setVerticalGroup(
			gl_panel_turno2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_turno2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel1T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel4T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel5T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel6T2S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel6T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel5T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel4T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel1T2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCorregitTurno2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_turno2.setLayout(gl_panel_turno2);
		
		
		
		panel_turno6 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno6, 180, SpringLayout.SOUTH, panel_turno2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno6, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno6, 0, SpringLayout.EAST, panel_turno1);
		panel_turno6.setVisible(false);
		panel.add(panel_turno6);
		
		JButton btnCorregitTurno6 = new JButton("Corregir");
		btnCorregitTurno6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				respuesta[0]=tglbtnClr1Turno1.getBackground().getRGB();
//				respuesta[1]=tglbtnClr2Turno1.getBackground().getRGB();
//				respuesta[2]=tglbtnClr3Turno1.getBackground().getRGB();
//				respuesta[3]=tglbtnClr4Turno1.getBackground().getRGB();
//				respuesta[4]=tglbtnClr5Turno1.getBackground().getRGB();
//				respuesta[5]=tglbtnClr6Turno1.getBackground().getRGB();

				for (Integer integer : respuesta) {
					System.out.println(integer);
				}
				
				piezasJUgador=Funciones.generarPiezas(respuesta, false);
				boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
				
				if(!fin) {
					panel_turno2.setVisible(true);
				}
				
				for (int i = 0; i < piezasJUgador.length; i++) {
//					switch (i) {
//					case 0:
//						colorPista(tglbtnPista1Turno1, i);
//						break;
//					case 1:
//						colorPista(tglbtnPista2Turno1, i);
//						break;
//					case 2:
//						colorPista(tglbtnPista3Turno1, i);
//						break;
//					case 3:
//						colorPista(tglbtnPista4Turno1, i);
//						break;
//					case 4:
//						colorPista(tglbtnPista5Turno1, i);
//						break;
//					case 5:
//						colorPista(tglbtnPista6Turno1, i);
//						break;
//
//					default:
//						break;
//					}
					
				}
				
			}
		});
		
		JPanel panel1T6 = new JPanel();
		
		JPanel panel2T6 = new JPanel();
		
		JPanel panel3T6 = new JPanel();
		
		JPanel panel4T6 = new JPanel();
		
		JPanel panel5T6 = new JPanel();
		
		JPanel panel6T6 = new JPanel();
		
		JPanel panel6T6S = new JPanel();
		
		JPanel panel5T6S = new JPanel();
		
		JPanel panel4T6S = new JPanel();
		
		JPanel panel3T6S = new JPanel();
		
		JPanel panel2T6S = new JPanel();
		
		JPanel panel1T6S = new JPanel();
		GroupLayout gl_panel_turno6 = new GroupLayout(panel_turno6);
		gl_panel_turno6.setHorizontalGroup(
			gl_panel_turno6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno6.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel1T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel4T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel5T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel6T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnCorregitTurno6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(panel1T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel4T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel5T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel6T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_turno6.setVerticalGroup(
			gl_panel_turno6.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_turno6.createSequentialGroup()
					.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_turno6.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel1T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_turno6.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel2T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_turno6.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel3T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_turno6.createSequentialGroup()
										.addContainerGap()
										.addComponent(panel4T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_turno6.createSequentialGroup()
											.addContainerGap()
											.addComponent(panel5T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel_turno6.createSequentialGroup()
												.addContainerGap()
												.addComponent(panel6T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_turno6.createSequentialGroup()
													.addContainerGap()
													.addComponent(panel5T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_panel_turno6.createSequentialGroup()
														.addContainerGap()
														.addComponent(panel4T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel_turno6.createSequentialGroup()
															.addContainerGap()
															.addComponent(panel3T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
															.addGroup(gl_panel_turno6.createSequentialGroup()
																.addContainerGap()
																.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING)
																	.addComponent(panel6T6S, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																	.addComponent(btnCorregitTurno6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
															.addGroup(gl_panel_turno6.createSequentialGroup()
																.addContainerGap()
																.addGroup(gl_panel_turno6.createParallelGroup(Alignment.LEADING, false)
																	.addComponent(panel1T6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																	.addComponent(panel2T6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))))))))))))
					.addContainerGap())
		);
		panel_turno6.setLayout(gl_panel_turno6);
		
		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_turno2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 58, SpringLayout.SOUTH, panel_turno2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 646, SpringLayout.WEST, panel);
		panel.add(panel_2);
		
		panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 11, SpringLayout.SOUTH, panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		panel1T1_1 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_1, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_1, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_1, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_1, 40, SpringLayout.WEST, panel_2);
		panel_2.add(panel1T1_1);
		
		panel1T1_2 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_2, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_2, 6, SpringLayout.EAST, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_2, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_2, 36, SpringLayout.EAST, panel1T1_1);
		panel_2.add(panel1T1_2);
		
		panel1T1_3 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_3, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_3, 6, SpringLayout.EAST, panel1T1_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_3, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_3, 36, SpringLayout.EAST, panel1T1_2);
		panel_2.add(panel1T1_3);
		
		panel1T1_4 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_4, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_4, 6, SpringLayout.EAST, panel1T1_3);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_4, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_4, 36, SpringLayout.EAST, panel1T1_3);
		panel_2.add(panel1T1_4);
		
		panel1T1_5 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_5, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_5, 6, SpringLayout.EAST, panel1T1_4);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_5, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_5, 36, SpringLayout.EAST, panel1T1_4);
		panel_2.add(panel1T1_5);
		
		panel1T1_6 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_6, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_6, 6, SpringLayout.EAST, panel1T1_5);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_6, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_6, 36, SpringLayout.EAST, panel1T1_5);
		panel_2.add(panel1T1_6);
		
		btnCorregitTurno2_1 = new JButton("Corregir");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnCorregitTurno2_1, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnCorregitTurno2_1, 30, SpringLayout.EAST, panel1T1_6);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnCorregitTurno2_1, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnCorregitTurno2_1, 130, SpringLayout.EAST, panel1T1_6);
		panel_2.add(btnCorregitTurno2_1);
		
		panel1T1_7 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_7, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_7, -40, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_7, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_7, -10, SpringLayout.EAST, panel_2);
		panel_2.add(panel1T1_7);
		
		panel1T1_8 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_8, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_8, -36, SpringLayout.WEST, panel1T1_7);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_8, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_8, -6, SpringLayout.WEST, panel1T1_7);
		panel_2.add(panel1T1_8);
		
		panel1T1_9 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_9, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_9, -36, SpringLayout.WEST, panel1T1_8);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_9, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_9, -6, SpringLayout.WEST, panel1T1_8);
		panel_2.add(panel1T1_9);
		
		panel1T1_10 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_10, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_10, -36, SpringLayout.WEST, panel1T1_9);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_10, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_10, -6, SpringLayout.WEST, panel1T1_9);
		panel_2.add(panel1T1_10);
		
		panel1T1_11 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_11, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_11, -36, SpringLayout.WEST, panel1T1_10);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_11, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_11, -6, SpringLayout.WEST, panel1T1_10);
		panel_2.add(panel1T1_11);
		
		panel1T1_12 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel1T1_12, 0, SpringLayout.NORTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel1T1_12, -36, SpringLayout.WEST, panel1T1_11);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel1T1_12, 0, SpringLayout.SOUTH, panel1T1_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel1T1_12, -6, SpringLayout.WEST, panel1T1_11);
		panel_2.add(panel1T1_12);
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel_turno1);
		panel.add(panel_5);
		
		panel_6 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, -6, SpringLayout.NORTH, panel_6);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		panel1T1_13 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T1_13, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T1_13, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T1_13, -10, SpringLayout.SOUTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T1_13, 40, SpringLayout.WEST, panel_5);
		panel_5.add(panel1T1_13);
		
		panel1T1_14 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T1_14, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T1_14, 6, SpringLayout.EAST, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T1_14, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T1_14, 36, SpringLayout.EAST, panel1T1_13);
		panel_5.add(panel1T1_14);
		
		panel1T1_15 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T1_15, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T1_15, 6, SpringLayout.EAST, panel1T1_14);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T1_15, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T1_15, 36, SpringLayout.EAST, panel1T1_14);
		panel_5.add(panel1T1_15);
		
		panel1T1_16 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T1_16, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T1_16, 6, SpringLayout.EAST, panel1T1_15);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T1_16, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T1_16, 36, SpringLayout.EAST, panel1T1_15);
		panel_5.add(panel1T1_16);
		
		panel1T1_17 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T1_17, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T1_17, 6, SpringLayout.EAST, panel1T1_16);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T1_17, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T1_17, 36, SpringLayout.EAST, panel1T1_16);
		panel_5.add(panel1T1_17);
		
		panel1T1_18 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T1_18, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T1_18, 6, SpringLayout.EAST, panel1T1_17);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T1_18, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T1_18, 36, SpringLayout.EAST, panel1T1_17);
		panel_5.add(panel1T1_18);
		
		btnCorregitTurno2_2 = new JButton("Corregir");
		sl_panel_5.putConstraint(SpringLayout.NORTH, btnCorregitTurno2_2, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, btnCorregitTurno2_2, 33, SpringLayout.EAST, panel1T1_18);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, btnCorregitTurno2_2, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, btnCorregitTurno2_2, 129, SpringLayout.EAST, panel1T1_18);
		panel_5.add(btnCorregitTurno2_2);
		
		panel1T6S_1 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T6S_1, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T6S_1, -40, SpringLayout.EAST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T6S_1, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T6S_1, -10, SpringLayout.EAST, panel_5);
		panel_5.add(panel1T6S_1);
		
		panel1T6S_2 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T6S_2, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T6S_2, -36, SpringLayout.WEST, panel1T6S_1);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T6S_2, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T6S_2, -6, SpringLayout.WEST, panel1T6S_1);
		panel_5.add(panel1T6S_2);
		
		panel1T6S_3 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T6S_3, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T6S_3, -36, SpringLayout.WEST, panel1T6S_2);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T6S_3, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T6S_3, -6, SpringLayout.WEST, panel1T6S_2);
		panel_5.add(panel1T6S_3);
		
		panel1T6S_4 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T6S_4, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T6S_4, -36, SpringLayout.WEST, panel1T6S_3);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T6S_4, -10, SpringLayout.SOUTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T6S_4, -6, SpringLayout.WEST, panel1T6S_3);
		panel_5.add(panel1T6S_4);
		
		panel1T6S_5 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T6S_5, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T6S_5, -36, SpringLayout.WEST, panel1T6S_4);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T6S_5, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T6S_5, -6, SpringLayout.WEST, panel1T6S_4);
		panel_5.add(panel1T6S_5);
		
		panel1T6S_6 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel1T6S_6, 0, SpringLayout.NORTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel1T6S_6, -36, SpringLayout.WEST, panel1T6S_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel1T6S_6, 0, SpringLayout.SOUTH, panel1T1_13);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel1T6S_6, -6, SpringLayout.WEST, panel1T6S_5);
		panel_5.add(panel1T6S_6);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6, 247, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6, -6, SpringLayout.NORTH, panel_turno6);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_6, 0, SpringLayout.EAST, panel_turno1);
		panel.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		btnCorregitTurno2_3 = new JButton("Corregir");
		sl_panel_6.putConstraint(SpringLayout.NORTH, btnCorregitTurno2_3, 10, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, btnCorregitTurno2_3, 251, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, btnCorregitTurno2_3, -5, SpringLayout.SOUTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, btnCorregitTurno2_3, 346, SpringLayout.WEST, panel_6);
		panel_6.add(btnCorregitTurno2_3);
		
		panel1T6S_7 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_7, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_7, 10, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_7, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_7, 41, SpringLayout.WEST, panel_6);
		panel_6.add(panel1T6S_7);
		
		panel1T6S_8 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_8, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_8, 5, SpringLayout.EAST, panel1T6S_7);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_8, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_8, 36, SpringLayout.EAST, panel1T6S_7);
		panel_6.add(panel1T6S_8);
		
		panel1T6S_9 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_9, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_9, 6, SpringLayout.EAST, panel1T6S_8);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_9, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_9, 37, SpringLayout.EAST, panel1T6S_8);
		panel_6.add(panel1T6S_9);
		
		panel1T6S_10 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_10, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_10, 6, SpringLayout.EAST, panel1T6S_9);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_10, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_10, 37, SpringLayout.EAST, panel1T6S_9);
		panel_6.add(panel1T6S_10);
		
		panel1T6S_11 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_11, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_11, 6, SpringLayout.EAST, panel1T6S_10);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_11, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_11, 37, SpringLayout.EAST, panel1T6S_10);
		panel_6.add(panel1T6S_11);
		
		panel1T6S_12 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_12, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_12, 6, SpringLayout.EAST, panel1T6S_11);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_12, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_12, 37, SpringLayout.EAST, panel1T6S_11);
		panel_6.add(panel1T6S_12);
		
		panel1T6S_13 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_13, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_13, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_13, -10, SpringLayout.EAST, panel_6);
		panel_6.add(panel1T6S_13);
		
		panel1T6S_14 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_14, 538, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_14, -47, SpringLayout.EAST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_13, 6, SpringLayout.EAST, panel1T6S_14);
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_14, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_14, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		panel_6.add(panel1T6S_14);
		
		panel1T6S_15 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_15, 501, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_15, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_15, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_15, -6, SpringLayout.WEST, panel1T6S_14);
		panel_6.add(panel1T6S_15);
		
		panel1T6S_16 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_16, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_16, -37, SpringLayout.WEST, panel1T6S_15);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_16, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_16, -6, SpringLayout.WEST, panel1T6S_15);
		panel_6.add(panel1T6S_16);
		
		panel1T6S_17 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_17, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_17, -37, SpringLayout.WEST, panel1T6S_16);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_17, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_17, -6, SpringLayout.WEST, panel1T6S_16);
		panel_6.add(panel1T6S_17);
		
		panel1T6S_18 = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panel1T6S_18, 0, SpringLayout.NORTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.WEST, panel1T6S_18, -37, SpringLayout.WEST, panel1T6S_17);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panel1T6S_18, 0, SpringLayout.SOUTH, btnCorregitTurno2_3);
		sl_panel_6.putConstraint(SpringLayout.EAST, panel1T6S_18, -6, SpringLayout.WEST, panel1T6S_17);
		panel_6.add(panel1T6S_18);
		frame.getContentPane().add(panel_1);
		
		//Si los botones estan activados, pulsaremos y se abrira una ventan de selector de color para asignarlo color a este
		//Todos los botones son iguales
		tglbtnClr1.addActionListener(e -> botonColor(tglbtnClr1));
		tglbtnClr2.addActionListener(e -> botonColor(tglbtnClr2));
		tglbtnClr3.addActionListener(e -> botonColor(tglbtnClr3));
		tglbtnClr4.addActionListener(e -> botonColor(tglbtnClr4));
		tglbtnClr5.addActionListener(e -> botonColor(tglbtnClr5));
		tglbtnClr6.addActionListener(e -> botonColor(tglbtnClr6));
	}
	
	static MouseListener mouseListener= new MouseListener() {

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
        	System.out.println("Botón clicado");
            if(e.getButton() == MouseEvent.BUTTON3) {
            	if(pos==0) {
        			pos=5;
        		}else {
        			pos--;
        		}
            	a=false;
            }else if(e.getButton() == MouseEvent.BUTTON1){
            	pos++;
        		if(pos>5) {
        			pos=0;
        		}
        		a=true;
            }else if(e.getButton() == MouseEvent.BUTTON2){}
            System.out.println(pos);
            ((JToggleButton) e.getComponent()).setBackground(new Color(coloresDisponibles[pos]));
        	((JToggleButton) e.getComponent()).setSelected(false);
//        	if (a) {
//				pos--;
//			}else {
//				pos++;
//			}
        }
    };
	private JPanel panel1T1;
	private JPanel panel2T1;
	private JPanel panel3T1;
	private JPanel panel4T1;
	private JPanel panel5T1;
	private JPanel panel6T1;
	private JPanel panel6T1S;
	private JPanel panel1T1S;
	private JPanel panel1T6_9;
	private JPanel panel2T1S;
	private JPanel panel4T1S;
	private JPanel panel5T1S;
	private JPanel panel1T2;
	private JPanel panel2T2;
	private JPanel panel3T2;
	private JPanel panel4T2;
	private JPanel panel5T2;
	private JPanel panel6T2;
	private JPanel panel6T2S;
	private JPanel panel5T2S;
	private JPanel panel4T2S;
	private JPanel panel3T2S;
	private JPanel panel2T2S;
	private JPanel panel1T2S;
	private JPanel panel_2;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel1T1_1;
	private JPanel panel1T1_2;
	private JPanel panel1T1_3;
	private JPanel panel1T1_4;
	private JPanel panel1T1_5;
	private JPanel panel1T1_6;
	private JButton btnCorregitTurno2_1;
	private JPanel panel1T1_7;
	private JPanel panel1T1_8;
	private JPanel panel1T1_9;
	private JPanel panel1T1_10;
	private JPanel panel1T1_11;
	private JPanel panel1T1_12;
	private JPanel panel1T1_13;
	private JPanel panel1T1_14;
	private JPanel panel1T1_15;
	private JPanel panel1T1_16;
	private JPanel panel1T1_17;
	private JPanel panel1T1_18;
	private JButton btnCorregitTurno2_2;
	private JButton btnCorregitTurno2_3;
	private JPanel panel1T6S_1;
	private JPanel panel1T6S_2;
	private JPanel panel1T6S_3;
	private JPanel panel1T6S_4;
	private JPanel panel1T6S_5;
	private JPanel panel1T6S_6;
	private JPanel panel1T6S_7;
	private JPanel panel1T6S_8;
	private JPanel panel1T6S_9;
	private JPanel panel1T6S_10;
	private JPanel panel1T6S_11;
	private JPanel panel1T6S_12;
	private JPanel panel1T6S_13;
	private JPanel panel1T6S_14;
	private JPanel panel1T6S_15;
	private JPanel panel1T6S_16;
	private JPanel panel1T6S_17;
	private JPanel panel1T6S_18;

    //Llama al mouseLIstener porque sino el boton aunque lo desactivaras seguia dejando canviar el color
    public static void botonColorJugador(JToggleButton button) {
    	button.addMouseListener(mouseListener);
	}
	
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
	
	public static void colorPista (JToggleButton boton, int num) {
		if (piezasJUgador[num].getEstado() == 0) {
			boton.setBackground(Color.white);
		} else if(piezasJUgador[num].getEstado() == 1){
			boton.setBackground(Color.black);
		}
	}
}
