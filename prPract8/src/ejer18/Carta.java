package ejer18;

public abstract class Carta {
	
	// Variables
	private byte palo, valor;
	
	// Getters and Setters
	public byte getPalo() {return palo;}
	public byte getValor() {return valor;}

	public void setPalo(byte palo) {this.palo = palo;}
	public void setValor(byte valor) {this.valor = valor;}
	
	// Constructor
	public Carta(byte palo, byte valor) {
		this.palo = palo;
		this.valor = valor;
	}

	// Métodos toString
	@Override
	public String toString() {
		return this.valorToString() + " de " + this.paloToString();
	}
	abstract public String claseToString();
	abstract public String paloToString();
	abstract public String valorToString();
	
	// equals
	@Override
	public boolean equals(Object ob) {
		Carta other = (Carta)ob;
		return this.palo == other.palo
			&& this.valor == other.valor;
	}
	
	public boolean isEqualTo(byte palo, byte valor) {
		return this.palo == palo
			&& this.valor == valor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
