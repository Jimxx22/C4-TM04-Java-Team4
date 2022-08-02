package team4.tm04;

public class Pieza {

	int color;
	String colorString;
	int estado;
	int posicion;
	
	
	public Pieza(int color) {
		this.color = color;
		this.estado = -1;
		comprovarColor();
	}


	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		comprovarColor();
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		if(estado==-1 || estado==0 || estado==1) {
			this.estado = estado;
		}
	}
	
	public String getColorString() {
		return colorString;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public void comprovarColor() {
		if(color==0) {
			colorString="Blanco";
		}else if(color==1){
			colorString="Negro";
		}else if(color==2){
			colorString="Rojo";
		}else if(color==3){
			colorString="Azul";
		}else if(color==4){
			colorString="Amarillo";
		}else if(color==5){
			colorString="Verde";
		}else {
			colorString="";
		}
	}

	public String toString() {
		return colorString;
	}
		
}
