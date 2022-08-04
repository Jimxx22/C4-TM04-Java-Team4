package team4.tm04;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Funciones {

	static Pieza[] piezasGeneradas;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> piezasHistorial=new ArrayList<>();
	
	/*public static void main(String[] args) {;
		menu();
	}*/
	
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
	
	//Funcion que solo funciona por terminal si es para entrar los colores 
	//se tendria que adaptar a grafico
	public static Pieza[] entrarPiezas() {
		
		Pieza[] piezas= new Pieza[5];
		int color;
		System.out.println("Colores validos: ");
		System.out.println("[0-Blanco, 1-Negro, 2-Rojo, 3-Azul, 4-Amarillo, 5-Verde]");
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println("Introduce el numero del color posicion "+i+":");
				sc.nextLine();
				color=recogerNumero(sc);
				piezas[i]=new Pieza(color);
				piezas[i].setPosicion(i);
			} catch (InputMismatchException e) {
				System.out.println("No se ha podido reconocer la entrada del numero");
				i--;
			}	
		}
		return piezas;
		
	}
	
	public static String mostrarPiezas(Pieza[] piezas ) {
		String piezasS="";
		for(int i=0;i<piezas.length;i++) {
			piezasS+=i+":"+piezas[i].toString()+" ";
		}
		return piezasS;
	}
	
	//Funcion que solo funciona por terminal es para cambiar el estado de estas 
	//se tendria que adaptar a grafico
	public static String estadoPiezas(Pieza[] piezas) {
		
		String estadoTodo="";
		
		for(int i=0;i<piezas.length;i++) {
			if(piezas[i].getEstado()==-1) {
				estadoTodo+=i+":- ";
			}else if(piezas[i].getEstado()==0){
				estadoTodo+=i+":* ";
			}else if(piezas[i].getEstado()==1){
				estadoTodo+=i+":0 ";
			}
		}
		return estadoTodo;
	}
	
	public static void jugar() {
		Pieza[] piezas;
		boolean fin;
		for(int i=0;i<12;i++) {
			
			piezas=entrarPiezas();
			fin=comprobarPiezas(piezas, piezasGeneradas);
			
			piezasHistorial.add(mostrarPiezas(piezas)+"     "+estadoPiezas(piezas));
			historial();
			if(fin) {
				i=12;
				System.out.println("Patron Base: "+mostrarPiezas(piezasGeneradas));
			}
		}
		
	}

	public static void historial() {
		System.out.println("HISTORIAL: ");
		for(int i=0;i<piezasHistorial.size();i++) {
			System.out.println("Turno "+i+": "+piezasHistorial.get(i));
		}
		System.out.println();
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
		
		if(cont==5) {
			fin=true;
		}
		return fin;
	}
	
	public static void jugarVsMaquina() {
		//piezasGeneradas=generarPiezasAleatorio();
		jugar();
	}
	
	public static void jugarVsJugador() {
		piezasGeneradas=entrarPiezas();
		jugar();
	}
	
	public static void menu() {
		
		String res;
		
		while(true) {
			System.out.println("Bienvenido a Mastermind.");
			System.out.println("Indica que quieres hacer: ");
			System.out.println("1- Jugar vs Maquina");
			System.out.println("2- Jugar vs Jugador");
			System.out.println("3- Reglas");
			System.out.println("0- Salir");
			res=sc.next();
			
			switch (res) {
			case "1":
				jugarVsMaquina();
				break;
			case "2":
				jugarVsJugador();
				break;
			case "3":
				reglas();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				sc.nextLine();
				System.out.println("Error: la opcion indicada no existe");
				break;
			}
		}
	}
	
	public static void reglas() {
		sc.nextLine();
		System.out.println("Explicacion del juego: ");
		System.out.println("El programa generara un patron de colores aleatorios, y tu tendras que adivinar-lo en 12 turnos.");
		System.out.println("Tu introduciaras un patron de colores, y el programa retornara lo siguiente: - - - - -.");
		System.out.println("Esto lo que significa es que ningun color que has introducido tu esta en el patron.");
		System.out.println("Si el programa retorna esto: - - * - 0.");
		System.out.println("Esto significa que el color introdicido en la posicion 3 esta en el patron, pero no esta bien colocado en este.");
		System.out.println("Y tambien significa que el color de la posicion 5 esta en el patron y bien colocado en este.");
		System.out.println("Entonces:\n -: El color no esta en el patron.");
		System.out.println("*: El color esta en el patron, pero no esta bien colocado en este.");
		System.out.println("0: El color esta en el patron y bien colocado en este.");
		System.out.println("Vamos a comenjar el juego.");
		System.out.println("\nPulsa culaquier tecla para volver al menu.");
		sc.nextLine();
	}
	
	//Recoger entrada de numero por teclado
	public static int recogerNumero (Scanner sc) throws  InputMismatchException {
		int num = sc.nextInt();
		return num;
	}

}
