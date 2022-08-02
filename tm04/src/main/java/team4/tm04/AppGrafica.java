package team4.tm04;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class AppGrafica {

	private JFrame frame;
	private JMenuBar barraMenu;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem nuevaPartidaMaquina;
	private JMenuItem nuevaPartidaJugador;
	private JMenuItem salir;
	private JMenuItem reglas;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JPanel panel_5;
	private JToggleButton tglbtnClr1S;
	private JToggleButton tglbtnClr2S;
	private JToggleButton tglbtnClr3S;
	private JToggleButton tglbtnClr4S;
	private JToggleButton tglbtnClr5S;
	private JToggleButton tglbtnClr6S;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGrafica window = new AppGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		frame.setJMenuBar(barraMenu);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(new SpringLayout());
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Colores disponibles: ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel, 40, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(null);
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 40, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, 36, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, -38, SpringLayout.EAST, panel_2);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JToggleButton tglbtnClr2 = new JToggleButton("");
		tglbtnClr2.setEnabled(false);
		tglbtnClr2.setBackground(Color.ORANGE);
		tglbtnClr2.setBorder(new LineBorder(Color.WHITE, 3));
		panel_4.add(tglbtnClr2);
		
		JToggleButton tglbtnClr3 = new JToggleButton("");
		tglbtnClr3.setEnabled(false);
		tglbtnClr3.setBackground(Color.GREEN);
		tglbtnClr3.setBorder(new LineBorder(Color.WHITE, 3));
		panel_4.add(tglbtnClr3);
		
		JToggleButton tglbtnClr4 = new JToggleButton("");
		tglbtnClr4.setEnabled(false);
		tglbtnClr4.setBackground(Color.BLUE);
		tglbtnClr4.setBorder(new LineBorder(Color.WHITE, 3));
		panel_4.add(tglbtnClr4);
		
		JToggleButton tglbtnClr5 = new JToggleButton("");
		tglbtnClr5.setEnabled(false);
		tglbtnClr5.setBackground(Color.MAGENTA);
		tglbtnClr5.setBorder(new LineBorder(Color.WHITE, 3));
		panel_4.add(tglbtnClr5);
		
		JToggleButton tglbtnClr6 = new JToggleButton("");
		tglbtnClr6.setEnabled(false);
		tglbtnClr6.setBackground(Color.YELLOW);
		tglbtnClr6.setBorder(new LineBorder(Color.WHITE, 3));
		panel_4.add(tglbtnClr6);
		
		lblNewLabel_1 = new JLabel("Combinación secreta: ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, panel_4);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		panel_2.add(lblNewLabel_1);
		
		panel_5 = new JPanel();
		panel_5.setVisible(false);
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_5, 36, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel_4);
		panel_5.setBorder(null);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		tglbtnClr1S = new JToggleButton("");
		tglbtnClr1S.setEnabled(false);
		tglbtnClr1S.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		tglbtnClr1S.setBackground(Color.RED);
		panel_5.add(tglbtnClr1S);
		
		tglbtnClr2S = new JToggleButton("");
		tglbtnClr2S.setEnabled(false);
		tglbtnClr2S.setBorder(new LineBorder(Color.WHITE, 3));
		tglbtnClr2S.setBackground(Color.ORANGE);
		panel_5.add(tglbtnClr2S);
		
		tglbtnClr3S = new JToggleButton("");
		tglbtnClr3S.setEnabled(false);
		tglbtnClr3S.setBorder(new LineBorder(Color.WHITE, 3));
		tglbtnClr3S.setBackground(Color.GREEN);
		panel_5.add(tglbtnClr3S);
		
		tglbtnClr4S = new JToggleButton("");
		tglbtnClr4S.setEnabled(false);
		tglbtnClr4S.setBorder(new LineBorder(Color.WHITE, 3));
		tglbtnClr4S.setBackground(Color.BLUE);
		panel_5.add(tglbtnClr4S);
		
		tglbtnClr5S = new JToggleButton("");
		tglbtnClr5S.setEnabled(false);
		tglbtnClr5S.setBorder(new LineBorder(Color.WHITE, 3));
		tglbtnClr5S.setBackground(Color.MAGENTA);
		panel_5.add(tglbtnClr5S);
		
		tglbtnClr6S = new JToggleButton("");
		tglbtnClr6S.setEnabled(false);
		tglbtnClr6S.setBorder(new LineBorder(Color.WHITE, 3));
		tglbtnClr6S.setBackground(Color.YELLOW);
		panel_5.add(tglbtnClr6S);
		
		JToggleButton tglbtnClr1 = new JToggleButton("");
		panel_2.add(tglbtnClr1);
		tglbtnClr1.setEnabled(false);
		tglbtnClr1.setBackground(Color.RED);
		tglbtnClr1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
	}
}
