package ejer18;

public abstract class Carta {
	
	// Variables
	private byte palo, valor, posicion;
	
	// Getters and Setters
	public byte getPalo() {return palo;}
	public byte getValor() {return valor;}
	public byte getPosicion() {return posicion;}

	public void setPalo(byte palo) {this.palo = palo;}
	public void setValor(byte valor) {this.valor = valor;}
	public void setPosicion(byte posicion) {this.posicion = posicion;}
	
	// Constructor
	public Carta(byte palo, byte valor, byte posicion) {
		this.palo = palo;
		this.valor = valor;
		this.posicion = posicion;
	}

	// Métodos toString
	@Override
	public String toString() {
		return this.valorToString() + " de " + this.paloToString();
	}
	abstract public String claseToString();
	abstract public String paloToString();
	abstract public String valorToString();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
