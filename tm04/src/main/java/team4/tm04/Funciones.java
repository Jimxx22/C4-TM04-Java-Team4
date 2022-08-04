package team4.tm04;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Funciones {
	//Genera las piezas con los colores aleatorios es decir, genera el patron aleatorio
	public static Pieza[] generarPiezas(Integer[] colores, boolean mezclar) {
		Pieza[] piezas= new Pieza[6];
		Integer[] coloresM= Arrays.copyOf(colores, colores.length);;
		
		int temp, random;
	    for (int i = 0; i < coloresM.length; i++){ 	
	    	if(mezclar) {
		        random=(int)Math.floor(Math.random() * coloresM.length);
		        if(random!=i) {
		        	coloresM[i]=coloresM[random];
		        }else {
		        	i--;
		        }  
	    	}
	    }
		
		for(int i=0;i<piezas.length;i++) {

			piezas[i]=new Pieza(coloresM[i]);
			piezas[i].setPosicion(i);
		}
		return piezas;
	}
	
	public static boolean comprobarPiezas(Pieza[] piezasUsuario, Pieza[] piezasGeneradas) {
		
		boolean fin=false;
		int cont=0;
		boolean ok1=false;
		for(int i=0; i<piezasUsuario.length;i++) {
			ok1=false;
			for(int j=0;j<piezasGeneradas.length;j++) {
				
				if(piezasUsuario[i].getColor() == piezasGeneradas[j].getColor() && piezasUsuario[i].getPosicion() == piezasGeneradas[j].getPosicion()) {
					piezasUsuario[i].setEstado(1);
					cont++;
					ok1=true;
				}else if(piezasUsuario[i].getColor() == piezasGeneradas[j].getColor() && piezasUsuario[i].getPosicion() != piezasGeneradas[j].getPosicion() && !ok1) {
					piezasUsuario[i].setEstado(0);
				}
			}
		}
		
		if(cont==6) {
			fin=true;
		}
		return fin;
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
	
	//funcion para que abra ventana se selector de color
	public static Color colorPicker() {
		
		JPanel contentPane= new JPanel();
		contentPane.setVisible(true);
		Color color=JColorChooser.showDialog(contentPane, "Elige un color", Color.BLACK);
		if(color==null) {
			color=Color.LIGHT_GRAY;
		}
		return color;
	}
	
	public static void botonColor(JToggleButton button) {
		int pos=AppGrafica.pos;
		
		button.setBackground(Funciones.colorPicker());
		AppGrafica.coloresDisponibles[pos]=button.getBackground().getRGB();
		button.setSelected(false);	
		pos++;
		if(pos==6) {
			pos=0;
		}
	}
	
	public static void colorPista (JPanel panel, int num) {		
		Pieza[] piezasJugador = AppGrafica.piezasJUgador;
		if (piezasJugador[num].getEstado() == 0) {
			panel.setBackground(Color.white);
		} else if(piezasJugador[num].getEstado() == 1){
			panel.setBackground(Color.black);
		}
	}

}
