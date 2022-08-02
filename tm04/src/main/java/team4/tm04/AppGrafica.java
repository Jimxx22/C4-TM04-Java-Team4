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

	/**
	 * Create the application.
	 */
	public AppGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menu superior
		barraMenu=new JMenuBar();
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
		
		nuevaPartidaJugador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				activarDesactivar(true);
				btnGen.setVisible(true);
				lblError.setVisible(true);
		}});
		
		frame.setJMenuBar(barraMenu);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		frame.getContentPane().add(panel);
		panel.setLayout(new SpringLayout());
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -276, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -29, SpringLayout.EAST, panel_1);
		panel_3.setBorder(null);
		panel_3.setBackground(SystemColor.menu);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1 = new JToggleButton("");
		tglbtnClr1.setBorder(new LineBorder(Color.BLACK, 2));
		tglbtnClr1.setBackground(Color.WHITE);
		panel_3.add(tglbtnClr1);
		
		tglbtnClr1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				tglbtnClr1.setBackground(colorPicker());
				coloresDisponibles[0]=tglbtnClr1.getBackground().getRGB();
				tglbtnClr1.setSelected(false);	
		}});	
		
		tglbtnClr2 = new JToggleButton("");
		tglbtnClr2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		tglbtnClr3.setBorder(new LineBorder(Color.BLACK, 2));
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
		tglbtnClr4.setBorder(new LineBorder(Color.BLACK, 2));
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
		tglbtnClr5.setBorder(new LineBorder(Color.BLACK, 2));
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
		tglbtnClr6.setBorder(new LineBorder(Color.BLACK, 2));
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, lblColores);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblColores, 27, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, lblColores);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblColores, 10, SpringLayout.NORTH, panel_1);
		panel_1.add(lblColores);
		
		btnGen = new JButton("Generar patrón");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnGen, 6, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnGen, 0, SpringLayout.EAST, panel_3);
		panel_1.add(btnGen);
		
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblCombinacion, 65, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblCombinacion, 0, SpringLayout.WEST, panel_3);
		panel_1.add(lblCombinacion);
		
		panel_4 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, lblCombinacion);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -158, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, -29, SpringLayout.EAST, panel_1);
		panel_4.setBorder(null);
		panel_4.setBackground(SystemColor.menu);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1S = new JToggleButton("");
		tglbtnClr1S.setEnabled(false);
		tglbtnClr1S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr1S);
		
		tglbtnClr2S = new JToggleButton("");
		tglbtnClr2S.setEnabled(false);
		tglbtnClr2S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr2S);
		
		tglbtnClr3S = new JToggleButton("");
		tglbtnClr3S.setEnabled(false);
		tglbtnClr3S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr3S);
		
		tglbtnClr4S = new JToggleButton("");
		tglbtnClr4S.setEnabled(false);
		tglbtnClr4S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr4S);
		
		tglbtnClr5S = new JToggleButton("");
		tglbtnClr5S.setEnabled(false);
		tglbtnClr5S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr5S);
		
		tglbtnClr6S = new JToggleButton("");
		tglbtnClr6S.setEnabled(false);
		tglbtnClr6S.setBackground(Color.WHITE);
		panel_4.add(tglbtnClr6S);
		
		lblError = new JLabel();
		lblError.setForeground(Color.RED);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblError, 6, SpringLayout.SOUTH, btnGen);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblError, 0, SpringLayout.EAST, panel_3);
		lblError.setBackground(Color.WHITE);
		panel_1.add(lblError);
		
	}
	
	public static Color colorPicker() {
		
		JPanel contentPane= new JPanel();
		contentPane.setVisible(true);
		Color color=JColorChooser.showDialog(contentPane, "Elige un color", Color.BLACK);
		
		return color;
	}
	
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
	
	public static void activarDesactivar(boolean estado) {
		tglbtnClr1.setEnabled(estado);
		tglbtnClr2.setEnabled(estado);
		tglbtnClr3.setEnabled(estado);
		tglbtnClr4.setEnabled(estado);
		tglbtnClr5.setEnabled(estado);
		tglbtnClr6.setEnabled(estado);
	}
	
	public static void addBackground(Pieza[] colores) {
		tglbtnClr1S.setBackground(new Color(colores[0].getColor()));
		tglbtnClr2S.setBackground(new Color(colores[1].getColor()));
		tglbtnClr3S.setBackground(new Color(colores[2].getColor()));
		tglbtnClr4S.setBackground(new Color(colores[3].getColor()));
		tglbtnClr5S.setBackground(new Color(colores[4].getColor()));
		tglbtnClr6S.setBackground(new Color(colores[5].getColor()));
	}
}
