package team4.tm04;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	
	private JPanel panel1T1;
	private JPanel panel2T1;
	private JPanel panel3T1;
	private JPanel panel4T1;
	private JPanel panel5T1;
	private JPanel panel6T1;
	private JPanel panel1T2;
	private JPanel panel2T2;
	private JPanel panel3T2;
	private JPanel panel4T2;
	private JPanel panel5T2;
	private JPanel panel6T2;
	private JPanel panel1T3;
	private JPanel panel2T3;
	private JPanel panel3T3;
	private JPanel panel4T3;
	private JPanel panel5T3;
	private JPanel panel6T3;
	private JButton btnCorregitTurno3;
	private JPanel panel1T4;
	private JPanel panel2T4;
	private JPanel panel3T4;
	private JPanel panel4T4;
	private JPanel panel5T4;
	private JPanel panel6T4;
	private JButton btnCorregitTurno4;
	private JButton btnCorregitTurno5;
	private JPanel panel1T5;
	private JPanel panel2T5;
	private JPanel panel3T5;
	private JPanel panel4T5;
	private JPanel panel5T5;
	private JPanel panel6T5;

	private JPanel panel_7;
	private JPanel panel6T1S;
	private JPanel panel5T1S;
	private JPanel panel4T1S;
	private JPanel panel3T1S;
	private JPanel panel2T1S;
	private JPanel panel1T1S;
	private JPanel panel_8;
	private JPanel panel1T2S;
	private JPanel panel2T2S;
	private JPanel panel3T2S;
	private JPanel panel4T2S;
	private JPanel panel5T2S;
	private JPanel panel6T2S;
	private JPanel panel_9;
	private JPanel panel1T3S;
	private JPanel panel2T3S;
	private JPanel panel3T3S;
	private JPanel panel4T3S;
	private JPanel panel5T3S;
	private JPanel panel6T3S;
	private JPanel panel_10;
	private JPanel panel1T4S;
	private JPanel panel2T4S;
	private JPanel panel3T4S;
	private JPanel panel4T4S;
	private JPanel panel5T4S;
	private JPanel panel6T4S;
	private JPanel panel_11;
	private JPanel panel1T5S;
	private JPanel panel2T5S;
	private JPanel panel3T5S;
	private JPanel panel4T5S;
	private JPanel panel5T5S;
	private JPanel panel6T5S;
	private JPanel panel_12;
	private JPanel panel1T6S;
	private JPanel panel2T6S;
	private JPanel panel3T6S;
	private JPanel panel4T6S;
	private JPanel panel5T6S;
	private JPanel panel6T6S;
	private JPanel panel1T6;
	private JPanel panel2T6;
	private JPanel panel3T6;
	private JPanel panel4T6;
	private JPanel panel5T6;
	private JPanel panel6T6;
	

	//panels trons
	private JPanel panel_turno1;
	private JPanel panel_turno2;
	private JPanel panel_turno6;
	private JPanel panel_turno3;
	private JPanel panel_turno4;
	private JPanel panel_turno5;
	
	private JLabel txtErrorT1;
	private JLabel txtErrorT2;
	private JLabel txtErrorT3;
	private JLabel txtErrorT4;
	private JLabel txtErrorT5;
	private JLabel txtErrorT6;
	 
	 
	 
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
					piezasGeneradas=Funciones.generarPiezas(coloresDisponibles,true);
					addBackground(piezasGeneradas);
					panel_turno1.setVisible(true);	
					activarDesactivar(false);
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
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno1, -363, SpringLayout.SOUTH, panel);
		panel_turno1.setVisible(false);
		panel_turno1.setVerifyInputWhenFocusTarget(false);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno1, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno1, -39, SpringLayout.EAST, panel);
		panel.add(panel_turno1);
		
		JButton btnCorregitTurno1 = new JButton("Corregir");
		btnCorregitTurno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta[0]=panel1T1.getBackground().getRGB();
				respuesta[1]=panel2T1.getBackground().getRGB();
				respuesta[2]=panel3T1.getBackground().getRGB();
				respuesta[3]=panel4T1.getBackground().getRGB();
				respuesta[4]=panel5T1.getBackground().getRGB();
				respuesta[5]=panel6T1.getBackground().getRGB();
				
				if(respuesta[0]==-1118482||respuesta[1]==-1118482||respuesta[2]==-1118482||respuesta[3]==-1118482||respuesta[4]==-1118482||respuesta[5]==-1118482) {
					txtErrorT1.setVisible(true);
				}else {
					piezasJUgador=Funciones.generarPiezas(respuesta, false);
					boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
					txtErrorT1.setVisible(false);
					btnCorregitTurno1.setVisible(false);
					
					if(!fin) {
						panel_turno2.setVisible(true);
					}else{
						 JOptionPane.showMessageDialog(new JFrame(), "Has ganado en 1 turnos.\nEnhorabuena!!");
						 panel_4.setVisible(true);
					}
					
					for (int i = 0; i < piezasJUgador.length; i++) {
						switch (i) {
						case 0:
							colorPista(panel1T1S, i);
							break;
						case 1:
							colorPista(panel2T1S, i);
							break;
						case 2:
							colorPista(panel3T1S, i);
							break;
						case 3:
							colorPista(panel4T1S, i);
							break;
						case 4:
							colorPista(panel5T1S, i);
							break;
						case 5:
							colorPista(panel6T1S, i);
							break;
	
						default:
							break;
						}
						
					}
				}
			}
		});
		
		panel1T1 = new JPanel();
		panel1T1.setBorder(new LineBorder(Color.BLACK, 2));
		panel1T1.setBackground(null);

		
		panel2T1 = new JPanel();
		panel2T1.setBorder(new LineBorder(Color.BLACK, 2));
		panel2T1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel3T1 = new JPanel();
		panel3T1.setBorder(new LineBorder(Color.BLACK, 2));
		panel3T1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel4T1 = new JPanel();
		panel4T1.setBorder(new LineBorder(Color.BLACK, 2));
		panel4T1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel5T1 = new JPanel();
		panel5T1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel5T1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel6T1 = new JPanel();
		panel6T1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel6T1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		txtErrorT1 = new JLabel("Error: hay algun color vacio");
		txtErrorT1.setVisible(false);
		txtErrorT1.setForeground(Color.RED);
		txtErrorT1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		panel_7 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_7, 6, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_7, 28, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_7, 39, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_7, 271, SpringLayout.WEST, panel_1);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1T1S = new JPanel();
		panel1T1S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel1T1S.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel1T1S);
		
		panel2T1S = new JPanel();
		panel2T1S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel2T1S.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel2T1S);
		
		panel3T1S = new JPanel();
		panel3T1S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel3T1S.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel3T1S);
		
		panel4T1S = new JPanel();
		panel4T1S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel4T1S.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel4T1S);
		
		panel5T1S = new JPanel();
		panel5T1S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel5T1S.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel5T1S);
		
		panel6T1S = new JPanel();
		panel6T1S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel6T1S.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel6T1S);
		
		GroupLayout gl_panel_turno1 = new GroupLayout(panel_turno1);
		gl_panel_turno1.setHorizontalGroup(
			gl_panel_turno1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_turno1.createSequentialGroup()
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCorregitTurno1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtErrorT1))
					.addContainerGap())
		);
		gl_panel_turno1.setVerticalGroup(
			gl_panel_turno1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel6T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCorregitTurno1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel1T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel5T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel4T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2T1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtErrorT1)
					.addContainerGap())
		);
		panel_turno1.setLayout(gl_panel_turno1);
		
		panel_turno2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno2, 6, SpringLayout.SOUTH, panel_turno1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno2, 0, SpringLayout.WEST, panel_turno1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno2, -297, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno2, -39, SpringLayout.EAST, panel);
		panel_turno2.setVisible(false);
		panel.add(panel_turno2);
		
		JButton btnCorregitTurno2 = new JButton("Corregir");
		btnCorregitTurno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta[0]=panel1T2.getBackground().getRGB();
				respuesta[1]=panel2T2.getBackground().getRGB();
				respuesta[2]=panel3T2.getBackground().getRGB();
				respuesta[3]=panel4T2.getBackground().getRGB();
				respuesta[4]=panel5T2.getBackground().getRGB();
				respuesta[5]=panel6T2.getBackground().getRGB();
				
				if(respuesta[0]==-1118482||respuesta[1]==-1118482||respuesta[2]==-1118482||respuesta[3]==-1118482||respuesta[4]==-1118482||respuesta[5]==-1118482) {
					txtErrorT2.setVisible(true);
				}else {
					piezasJUgador=Funciones.generarPiezas(respuesta, false);
					boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
					txtErrorT2.setVisible(false);
					btnCorregitTurno2.setVisible(false);
					
					if(!fin) {
						panel_turno3.setVisible(true);
					}else{
						 JOptionPane.showMessageDialog(new JFrame(), "Has ganado en 2 turnos.\nEnhorabuena!!");
						 panel_4.setVisible(true);
					}
					
					for (int i = 0; i < piezasJUgador.length; i++) {
						switch (i) {
						case 0:
							colorPista(panel1T2S, i);
							break;
						case 1:
							colorPista(panel2T2S, i);
							break;
						case 2:
							colorPista(panel3T2S, i);
							break;
						case 3:
							colorPista(panel4T2S, i);
							break;
						case 4:
							colorPista(panel5T2S, i);
							break;
						case 5:
							colorPista(panel6T2S, i);
							break;
	
						default:
							break;
						}
						
					}
				}
			}
		});
		
		panel1T2 = new JPanel();
		panel1T2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel1T2.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel2T2 = new JPanel();
		panel2T2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel2T2.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel3T2 = new JPanel();
		panel3T2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel3T2.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel4T2 = new JPanel();
		panel4T2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel4T2.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		
		panel5T2 = new JPanel();
		panel5T2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel6T2 = new JPanel();
		panel6T2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		txtErrorT2 = new JLabel("Error: hay algun color vacio");
		txtErrorT2.setVisible(false);
		txtErrorT2.setForeground(Color.RED);
		txtErrorT2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		panel_8 = new JPanel();
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1T2S = new JPanel();
		panel1T2S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel1T2S.setBackground(Color.LIGHT_GRAY);
		panel_8.add(panel1T2S);
		
		panel2T2S = new JPanel();
		panel2T2S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel2T2S.setBackground(Color.LIGHT_GRAY);
		panel_8.add(panel2T2S);
		
		panel3T2S = new JPanel();
		panel3T2S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel3T2S.setBackground(Color.LIGHT_GRAY);
		panel_8.add(panel3T2S);
		
		panel4T2S = new JPanel();
		panel4T2S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel4T2S.setBackground(Color.LIGHT_GRAY);
		panel_8.add(panel4T2S);
		
		panel5T2S = new JPanel();
		panel5T2S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel5T2S.setBackground(Color.LIGHT_GRAY);
		panel_8.add(panel5T2S);
		
		panel6T2S = new JPanel();
		panel6T2S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel6T2S.setBackground(Color.LIGHT_GRAY);
		panel_8.add(panel6T2S);
		GroupLayout gl_panel_turno2 = new GroupLayout(panel_turno2);
		gl_panel_turno2.setHorizontalGroup(
			gl_panel_turno2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_turno2.createSequentialGroup()
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCorregitTurno2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtErrorT2))
					.addContainerGap())
		);
		gl_panel_turno2.setVerticalGroup(
			gl_panel_turno2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_turno2.createSequentialGroup()
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_turno2.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel2T2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(panel3T2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(panel4T2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(panel5T2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(panel6T2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(panel1T2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCorregitTurno2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtErrorT2))
		);
		panel_turno2.setLayout(gl_panel_turno2);
		
		
		
		panel_turno6 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno6, 0, SpringLayout.WEST, panel_turno1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno6, -27, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno6, -39, SpringLayout.EAST, panel);
		panel_turno6.setVisible(false);
		panel.add(panel_turno6);
		
		JButton btnCorregitTurno6 = new JButton("Corregir");
		btnCorregitTurno6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta[0]=panel1T6.getBackground().getRGB();
				respuesta[1]=panel2T6.getBackground().getRGB();
				respuesta[2]=panel3T6.getBackground().getRGB();
				respuesta[3]=panel4T6.getBackground().getRGB();
				respuesta[4]=panel5T6.getBackground().getRGB();
				respuesta[5]=panel6T6.getBackground().getRGB();

				/*
				 * for (Integer integer : respuesta) { System.out.println(integer); }
				 */
				
				piezasJUgador=Funciones.generarPiezas(respuesta, false);
				boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
				System.out.println(fin);
				if(!fin) {
					panel_turno6.setVisible(true);
				}else{
					 JOptionPane.showMessageDialog(new JFrame(), "Has ganado en 6 turnos.\nEnhorabuena!!");
					 panel_4.setVisible(true);
				}
				
				for (int i = 0; i < piezasJUgador.length; i++) {
					switch (i) {
					case 0:
						colorPista(panel1T6S, i);
						break;
					case 1:
						colorPista(panel2T6S, i);
						break;
					case 2:
						colorPista(panel3T6S, i);
						break;
					case 3:
						colorPista(panel4T6S, i);
						break;
					case 4:
						colorPista(panel5T6S, i);
						break;
					case 5:
						colorPista(panel6T6S, i);
						break;

					default:
						break;
					}
					
				}
				
			}
		});
		
		panel1T6 = new JPanel();
		panel1T6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel2T6 = new JPanel();
		panel2T6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel3T6 = new JPanel();
		panel3T6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel4T6 = new JPanel();
		panel4T6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel5T6 = new JPanel();
		panel5T6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel6T6 = new JPanel();
		panel6T6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		txtErrorT6 = new JLabel("Error: hay algun color vacio");
		txtErrorT6.setVisible(false);
		txtErrorT6.setForeground(Color.RED);
		txtErrorT6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		panel_12 = new JPanel();
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1T6S = new JPanel();
		panel1T6S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel1T6S.setBackground(Color.LIGHT_GRAY);
		panel_12.add(panel1T6S);
		
		panel2T6S = new JPanel();
		panel2T6S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel2T6S.setBackground(Color.LIGHT_GRAY);
		panel_12.add(panel2T6S);
		
		panel3T6S = new JPanel();
		panel3T6S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel3T6S.setBackground(Color.LIGHT_GRAY);
		panel_12.add(panel3T6S);
		
		panel4T6S = new JPanel();
		panel4T6S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel4T6S.setBackground(Color.LIGHT_GRAY);
		panel_12.add(panel4T6S);
		
		panel5T6S = new JPanel();
		panel5T6S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel5T6S.setBackground(Color.LIGHT_GRAY);
		panel_12.add(panel5T6S);
		
		panel6T6S = new JPanel();
		panel6T6S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel6T6S.setBackground(Color.LIGHT_GRAY);
		panel_12.add(panel6T6S);
		GroupLayout gl_panel_turno6 = new GroupLayout(panel_turno6);
		gl_panel_turno6.setHorizontalGroup(
			gl_panel_turno6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_turno6.createSequentialGroup()
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
							.addGap(10)
							.addComponent(btnCorregitTurno6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtErrorT6))
					.addContainerGap())
		);
		gl_panel_turno6.setVerticalGroup(
			gl_panel_turno6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_turno6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_turno6.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCorregitTurno6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel6T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel5T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel4T6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_turno6.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel1T6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel2T6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel3T6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtErrorT6)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_turno6.setLayout(gl_panel_turno6);
		
		panel_turno3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno3, 6, SpringLayout.SOUTH, panel_turno2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno3, 0, SpringLayout.WEST, panel_turno1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno3, -231, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno3, -39, SpringLayout.EAST, panel);
		panel_turno3.setVisible(false);
		panel.add(panel_turno3);
		
		panel_turno4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno4, 6, SpringLayout.SOUTH, panel_turno3);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno4, 0, SpringLayout.WEST, panel_turno1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno4, -165, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno4, -39, SpringLayout.EAST, panel);
		panel_turno4.setVisible(false);
		SpringLayout sl_panel_turno3 = new SpringLayout();
		panel_turno3.setLayout(sl_panel_turno3);
		
		panel1T3 = new JPanel();
		panel1T3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel1T3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel1T3, 10, SpringLayout.WEST, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel1T3, -576, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel1T3);
		
		panel2T3 = new JPanel();
		panel2T3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel2T3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel2T3, 6, SpringLayout.EAST, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel2T3, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel2T3, -540, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel2T3);
		
		panel3T3 = new JPanel();
		panel3T3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel3T3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel3T3, 6, SpringLayout.EAST, panel2T3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel3T3, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel3T3, -504, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel3T3);
		
		panel4T3 = new JPanel();
		panel4T3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel4T3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel4T3, 6, SpringLayout.EAST, panel3T3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel4T3, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel4T3, -468, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel4T3);
		
		panel5T3 = new JPanel();
		panel5T3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel5T3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel5T3, 6, SpringLayout.EAST, panel4T3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel5T3, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel5T3, -432, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel5T3);
		
		panel6T3 = new JPanel();
		panel6T3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel6T3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel6T3, 6, SpringLayout.EAST, panel5T3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel6T3, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel6T3, -396, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel6T3);
		
		btnCorregitTurno3 = new JButton("Corregir");
		btnCorregitTurno3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta[0]=panel1T3.getBackground().getRGB();
				respuesta[1]=panel2T3.getBackground().getRGB();
				respuesta[2]=panel3T3.getBackground().getRGB();
				respuesta[3]=panel4T3.getBackground().getRGB();
				respuesta[4]=panel5T3.getBackground().getRGB();
				respuesta[5]=panel6T3.getBackground().getRGB();
				
				if(respuesta[0]==-1118482||respuesta[1]==-1118482||respuesta[2]==-1118482||respuesta[3]==-1118482||respuesta[4]==-1118482||respuesta[5]==-1118482) {
					txtErrorT3.setVisible(true);
				}else {
					piezasJUgador=Funciones.generarPiezas(respuesta, false);
					boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
					txtErrorT3.setVisible(false);
					btnCorregitTurno3.setVisible(false);
					
					if(!fin) {
						panel_turno4.setVisible(true);
					}else{
						 JOptionPane.showMessageDialog(new JFrame(), "Has ganado en 3 turnos.\nEnhorabuena!!");
						 panel_4.setVisible(true);
					}
					
					for (int i = 0; i < piezasJUgador.length; i++) {
						switch (i) {
						case 0:
							colorPista(panel1T3S, i);
							break;
						case 1:
							colorPista(panel2T3S, i);
							break;
						case 2:
							colorPista(panel3T3S, i);
							break;
						case 3:
							colorPista(panel4T3S, i);
							break;
						case 4:
							colorPista(panel5T3S, i);
							break;
						case 5:
							colorPista(panel6T3S, i);
							break;
	
						default:
							break;
						}
						
					}
				}
			}
		});
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, btnCorregitTurno3, 10, SpringLayout.NORTH, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, btnCorregitTurno3, 6, SpringLayout.EAST, panel6T3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, btnCorregitTurno3, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, btnCorregitTurno3, -290, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(btnCorregitTurno3);
		
		txtErrorT3 = new JLabel("Error: hay algun color vacio");
		txtErrorT3.setVisible(false);
		txtErrorT3.setForeground(Color.RED);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, txtErrorT3, 10, SpringLayout.WEST, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel1T3, -6, SpringLayout.NORTH, txtErrorT3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, txtErrorT3, 0, SpringLayout.SOUTH, panel_turno3);
		txtErrorT3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_turno3.add(txtErrorT3);
		
		panel_9 = new JPanel();
		sl_panel_turno3.putConstraint(SpringLayout.NORTH, panel_9, 0, SpringLayout.NORTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.WEST, panel_9, -251, SpringLayout.EAST, panel_turno3);
		sl_panel_turno3.putConstraint(SpringLayout.SOUTH, panel_9, 0, SpringLayout.SOUTH, panel1T3);
		sl_panel_turno3.putConstraint(SpringLayout.EAST, panel_9, -10, SpringLayout.EAST, panel_turno3);
		panel_turno3.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1T3S = new JPanel();
		panel1T3S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel1T3S.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel1T3S);
		
		panel2T3S = new JPanel();
		panel2T3S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel2T3S.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel2T3S);
		
		panel3T3S = new JPanel();
		panel3T3S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel3T3S.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel3T3S);
		
		panel4T3S = new JPanel();
		panel4T3S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel4T3S.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel4T3S);
		
		panel5T3S = new JPanel();
		panel5T3S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel5T3S.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel5T3S);
		
		panel6T3S = new JPanel();
		panel6T3S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel6T3S.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel6T3S);
		panel.add(panel_turno4);
		
		panel_turno5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno5, 6, SpringLayout.SOUTH, panel_turno4);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_turno5, -99, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_turno6, 6, SpringLayout.SOUTH, panel_turno5);
		sl_panel.putConstraint(SpringLayout.WEST, panel_turno5, 0, SpringLayout.WEST, panel_turno1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_turno5, -39, SpringLayout.EAST, panel);
		panel_turno5.setVisible(false);
		SpringLayout sl_panel_turno4 = new SpringLayout();
		panel_turno4.setLayout(sl_panel_turno4);
		
		panel1T4 = new JPanel();
		panel1T4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel1T4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel1T4, 10, SpringLayout.WEST, panel_turno4);
		panel_turno4.add(panel1T4);
		
		panel2T4 = new JPanel();
		panel2T4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel1T4, 0, SpringLayout.SOUTH, panel2T4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel1T4, -6, SpringLayout.WEST, panel2T4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel2T4, 46, SpringLayout.WEST, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel2T4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel2T4, -22, SpringLayout.SOUTH, panel_turno4);
		panel_turno4.add(panel2T4);
		
		panel3T4 = new JPanel();
		panel3T4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel3T4, 82, SpringLayout.WEST, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel2T4, -6, SpringLayout.WEST, panel3T4);
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel3T4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel3T4, -22, SpringLayout.SOUTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel3T4, -504, SpringLayout.EAST, panel_turno4);
		panel_turno4.add(panel3T4);
		
		panel4T4 = new JPanel();
		panel4T4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel4T4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel4T4, 6, SpringLayout.EAST, panel3T4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel4T4, -22, SpringLayout.SOUTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel4T4, -468, SpringLayout.EAST, panel_turno4);
		panel_turno4.add(panel4T4);
		
		panel5T4 = new JPanel();
		panel5T4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel5T4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel5T4, 6, SpringLayout.EAST, panel4T4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel5T4, -22, SpringLayout.SOUTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel5T4, -432, SpringLayout.EAST, panel_turno4);
		panel_turno4.add(panel5T4);
		
		panel6T4 = new JPanel();
		panel6T4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel6T4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel6T4, 6, SpringLayout.EAST, panel5T4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel6T4, -22, SpringLayout.SOUTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel6T4, -396, SpringLayout.EAST, panel_turno4);
		panel_turno4.add(panel6T4);
		
		btnCorregitTurno4 = new JButton("Corregir");
		btnCorregitTurno4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta[0]=panel1T4.getBackground().getRGB();
				respuesta[1]=panel2T4.getBackground().getRGB();
				respuesta[2]=panel3T4.getBackground().getRGB();
				respuesta[3]=panel4T4.getBackground().getRGB();
				respuesta[4]=panel5T4.getBackground().getRGB();
				respuesta[5]=panel6T4.getBackground().getRGB();
				
				if(respuesta[0]==-1118482||respuesta[1]==-1118482||respuesta[2]==-1118482||respuesta[3]==-1118482||respuesta[4]==-1118482||respuesta[5]==-1118482) {
					txtErrorT4.setVisible(true);
				}else {
					piezasJUgador=Funciones.generarPiezas(respuesta, false);
					boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
					txtErrorT4.setVisible(false);
					btnCorregitTurno4.setVisible(false);
					
					if(!fin) {
						panel_turno5.setVisible(true);
					}else{
						 JOptionPane.showMessageDialog(new JFrame(), "Has ganado en 4 turnos.\nEnhorabuena!!");
						 panel_4.setVisible(true);
					}
					
					for (int i = 0; i < piezasJUgador.length; i++) {
						switch (i) {
						case 0:
							colorPista(panel1T4S, i);
							break;
						case 1:
							colorPista(panel2T4S, i);
							break;
						case 2:
							colorPista(panel3T4S, i);
							break;
						case 3:
							colorPista(panel4T4S, i);
							break;
						case 4:
							colorPista(panel5T4S, i);
							break;
						case 5:
							colorPista(panel6T4S, i);
							break;
	
						default:
							break;
						}
						
					}
				}
			}
		});
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, btnCorregitTurno4, 10, SpringLayout.NORTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, btnCorregitTurno4, 6, SpringLayout.EAST, panel6T4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, btnCorregitTurno4, -22, SpringLayout.SOUTH, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, btnCorregitTurno4, -294, SpringLayout.EAST, panel_turno4);
		panel_turno4.add(btnCorregitTurno4);
		
		txtErrorT4 = new JLabel("Error: hay algun color vacio");
		txtErrorT4.setVisible(false);
		txtErrorT4.setForeground(Color.RED);
		txtErrorT4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, txtErrorT4, 6, SpringLayout.SOUTH, panel1T4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, txtErrorT4, 0, SpringLayout.WEST, panel1T4);
		panel_turno4.add(txtErrorT4);
		
		panel_10 = new JPanel();
		sl_panel_turno4.putConstraint(SpringLayout.NORTH, panel_10, 0, SpringLayout.NORTH, panel1T4);
		sl_panel_turno4.putConstraint(SpringLayout.WEST, panel_10, -252, SpringLayout.EAST, panel_turno4);
		sl_panel_turno4.putConstraint(SpringLayout.SOUTH, panel_10, 28, SpringLayout.NORTH, panel1T4);
		sl_panel_turno4.putConstraint(SpringLayout.EAST, panel_10, -10, SpringLayout.EAST, panel_turno4);
		panel_turno4.add(panel_10);
		panel_10.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1T4S = new JPanel();
		panel1T4S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel1T4S.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel1T4S);
		
		panel2T4S = new JPanel();
		panel2T4S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel2T4S.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel2T4S);
		
		panel3T4S = new JPanel();
		panel3T4S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel3T4S.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel3T4S);
		
		panel4T4S = new JPanel();
		panel4T4S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel4T4S.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel4T4S);
		
		panel5T4S = new JPanel();
		panel5T4S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel5T4S.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel5T4S);
		
		panel6T4S = new JPanel();
		panel6T4S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel6T4S.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel6T4S);
		panel.add(panel_turno5);
		SpringLayout sl_panel_turno5 = new SpringLayout();
		panel_turno5.setLayout(sl_panel_turno5);
		
		btnCorregitTurno5 = new JButton("Corregir");
		btnCorregitTurno5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta[0]=panel1T5.getBackground().getRGB();
				respuesta[1]=panel2T5.getBackground().getRGB();
				respuesta[2]=panel3T5.getBackground().getRGB();
				respuesta[3]=panel4T5.getBackground().getRGB();
				respuesta[4]=panel5T5.getBackground().getRGB();
				respuesta[5]=panel6T5.getBackground().getRGB();
				
				if(respuesta[0]==-1118482||respuesta[1]==-1118482||respuesta[2]==-1118482||respuesta[3]==-1118482||respuesta[4]==-1118482||respuesta[5]==-1118482) {
					txtErrorT5.setVisible(true);
				}else {
					piezasJUgador=Funciones.generarPiezas(respuesta, false);
					boolean fin=Funciones.comprobarPiezas(piezasJUgador, piezasGeneradas);
					txtErrorT5.setVisible(false);
					btnCorregitTurno5.setVisible(false);
					
					if(!fin) {
						panel_turno6.setVisible(true);
					}else{
						 JOptionPane.showMessageDialog(new JFrame(), "Has ganado en 5 turnos.\nEnhorabuena!!");
						 panel_4.setVisible(true);
					}
					
					for (int i = 0; i < piezasJUgador.length; i++) {
						switch (i) {
						case 0:
							colorPista(panel1T5S, i);
							break;
						case 1:
							colorPista(panel2T5S, i);
							break;
						case 2:
							colorPista(panel3T5S, i);
							break;
						case 3:
							colorPista(panel4T5S, i);
							break;
						case 4:
							colorPista(panel5T5S, i);
							break;
						case 5:
							
							colorPista(panel6T5S, i);
							break;
	
						default:
							break;
						}
						
					}
				}
			}
		});
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, btnCorregitTurno5, 10, SpringLayout.NORTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, btnCorregitTurno5, -21, SpringLayout.SOUTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.EAST, btnCorregitTurno5, -289, SpringLayout.EAST, panel_turno5);
		panel_turno5.add(btnCorregitTurno5);
		
		panel1T5 = new JPanel();
		panel1T5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel1T5, 10, SpringLayout.NORTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel1T5, 10, SpringLayout.WEST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel1T5, -21, SpringLayout.SOUTH, panel_turno5);
		panel_turno5.add(panel1T5);
		
		panel2T5 = new JPanel();
		panel2T5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel1T5, -6, SpringLayout.WEST, panel2T5);
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel2T5, 46, SpringLayout.WEST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel2T5, 10, SpringLayout.NORTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel2T5, -21, SpringLayout.SOUTH, panel_turno5);
		panel_turno5.add(panel2T5);
		
		panel3T5 = new JPanel();
		panel3T5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel2T5, -6, SpringLayout.WEST, panel3T5);
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel3T5, 83, SpringLayout.WEST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel3T5, -21, SpringLayout.SOUTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel3T5, 10, SpringLayout.NORTH, panel_turno5);
		panel_turno5.add(panel3T5);
		
		panel4T5 = new JPanel();
		panel4T5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel4T5, 120, SpringLayout.WEST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel3T5, -6, SpringLayout.WEST, panel4T5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel4T5, -21, SpringLayout.SOUTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel4T5, 10, SpringLayout.NORTH, panel_turno5);
		panel_turno5.add(panel4T5);
		
		panel5T5 = new JPanel();
		panel5T5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel5T5, 157, SpringLayout.WEST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel4T5, -6, SpringLayout.WEST, panel5T5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel5T5, -21, SpringLayout.SOUTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel5T5, 10, SpringLayout.NORTH, panel_turno5);
		panel_turno5.add(panel5T5);
		
		panel6T5 = new JPanel();
		sl_panel_turno5.putConstraint(SpringLayout.WEST, btnCorregitTurno5, 6, SpringLayout.EAST, panel6T5);
		panel6T5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel5T5, -6, SpringLayout.WEST, panel6T5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel6T5, -21, SpringLayout.SOUTH, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel6T5, 194, SpringLayout.WEST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel6T5, -391, SpringLayout.EAST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel6T5, 10, SpringLayout.NORTH, panel_turno5);
		panel_turno5.add(panel6T5);
		
		txtErrorT5 = new JLabel("Error: hay algun color vacio");
		txtErrorT5.setVisible(false);
		txtErrorT5.setForeground(Color.RED);
		txtErrorT5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sl_panel_turno5.putConstraint(SpringLayout.WEST, txtErrorT5, 0, SpringLayout.WEST, panel1T5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, txtErrorT5, 0, SpringLayout.SOUTH, panel_turno5);
		panel_turno5.add(txtErrorT5);
		
		panel_11 = new JPanel();
		sl_panel_turno5.putConstraint(SpringLayout.NORTH, panel_11, 0, SpringLayout.NORTH, btnCorregitTurno5);
		sl_panel_turno5.putConstraint(SpringLayout.WEST, panel_11, -252, SpringLayout.EAST, panel_turno5);
		sl_panel_turno5.putConstraint(SpringLayout.SOUTH, panel_11, 29, SpringLayout.NORTH, btnCorregitTurno5);
		sl_panel_turno5.putConstraint(SpringLayout.EAST, panel_11, -10, SpringLayout.EAST, panel_turno5);
		panel_turno5.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1T5S = new JPanel();
		panel1T5S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel1T5S.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel1T5S);
		
		panel2T5S = new JPanel();
		panel2T5S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel2T5S.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel2T5S);
		
		panel3T5S = new JPanel();
		panel3T5S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel3T5S.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel3T5S);
		
		panel4T5S = new JPanel();
		panel4T5S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel4T5S.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel4T5S);
		
		panel5T5S = new JPanel();
		panel5T5S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel5T5S.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel5T5S);
		
		panel6T5S = new JPanel();
		panel6T5S.setBorder(new LineBorder(UIManager.getColor("Button.background"), 3));
		panel6T5S.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel6T5S);
		frame.getContentPane().add(panel_1);
		
		//Si los botones estan activados, pulsaremos y se abrira una ventan de selector de color para asignarlo color a este
		//Todos los botones son iguales
		tglbtnClr1.addActionListener(e -> botonColor(tglbtnClr1));
		tglbtnClr2.addActionListener(e -> botonColor(tglbtnClr2));
		tglbtnClr3.addActionListener(e -> botonColor(tglbtnClr3));
		tglbtnClr4.addActionListener(e -> botonColor(tglbtnClr4));
		tglbtnClr5.addActionListener(e -> botonColor(tglbtnClr5));
		tglbtnClr6.addActionListener(e -> botonColor(tglbtnClr6));
		
		panel1T1.addMouseListener(mouseListener);
		panel2T1.addMouseListener(mouseListener);
		panel3T1.addMouseListener(mouseListener);
		panel4T1.addMouseListener(mouseListener);
		panel5T1.addMouseListener(mouseListener);
		panel6T1.addMouseListener(mouseListener);
		
		panel1T2.addMouseListener(mouseListener);
		panel2T2.addMouseListener(mouseListener);
		panel3T2.addMouseListener(mouseListener);
		panel4T2.addMouseListener(mouseListener);
		panel5T2.addMouseListener(mouseListener);
		panel6T2.addMouseListener(mouseListener);
		
		panel1T3.addMouseListener(mouseListener);
		panel2T3.addMouseListener(mouseListener);
		panel3T3.addMouseListener(mouseListener);
		panel4T3.addMouseListener(mouseListener);
		panel5T3.addMouseListener(mouseListener);
		panel6T3.addMouseListener(mouseListener);
		
		panel1T4.addMouseListener(mouseListener);
		panel2T4.addMouseListener(mouseListener);
		panel3T4.addMouseListener(mouseListener);
		panel4T4.addMouseListener(mouseListener);
		panel5T4.addMouseListener(mouseListener);
		panel6T4.addMouseListener(mouseListener);
		
		panel1T5.addMouseListener(mouseListener);
		panel2T5.addMouseListener(mouseListener);
		panel3T5.addMouseListener(mouseListener);
		panel4T5.addMouseListener(mouseListener);
		panel5T5.addMouseListener(mouseListener);
		panel6T5.addMouseListener(mouseListener);
		
		panel1T6.addMouseListener(mouseListener);
		panel2T6.addMouseListener(mouseListener);
		panel3T6.addMouseListener(mouseListener);
		panel4T6.addMouseListener(mouseListener);
		panel5T6.addMouseListener(mouseListener);
		panel6T6.addMouseListener(mouseListener);
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
            ((JPanel) e.getComponent()).setBackground(new Color(coloresDisponibles[pos]));
            if(e.getButton() == MouseEvent.BUTTON3) {
            	if(pos==0) {
        			pos=5;
        		}else {
        			pos--;
        		}
            }else if(e.getButton() == MouseEvent.BUTTON1){
            	pos++;
        		if(pos>5) {
        			pos=0;
        		}
            }
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
			if(color.getRGB()!=-1118482) {
				coloresRGB[i]=color.getRGB();
			}else {
				i--;
			}
			
			
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
	
	public static void colorPista (JPanel panel, int num) {
		
		System.out.println(piezasJUgador[num].getColor()+" - "+piezasJUgador[num].getEstado());
		
		if (piezasJUgador[num].getEstado() == 0) {
			panel.setBackground(Color.white);
		} else if(piezasJUgador[num].getEstado() == 1){
			panel.setBackground(Color.black);
		}
	}
}
