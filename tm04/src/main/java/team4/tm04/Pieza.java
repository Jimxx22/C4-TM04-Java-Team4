package team4.tm04;

public class Pieza {

	int color;
	int estado;
	int posicion;
	
	
	public Pieza(int color) {
		this.color = color;
		this.estado = -1;
	}


	public int getColor() {
		return color;
	}

	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		if(estado==-1 || estado==0 || estado==1) {
			this.estado = estado;
		}
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
		
}
