package ejer1;

public class Juego {

// Variables
	private String nombre;
	private Plataforma plataf;
	private int udVendidas;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public Plataforma getPlataf() {return plataf;}
	public int getUdVendidas() {return udVendidas;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setPlataf(Plataforma plataf) {this.plataf = plataf;}
	public void setUdVendidas(int udVendidas) {this.udVendidas = udVendidas;}
	
// Constructores
	public Juego(String nombre, Plataforma plataf, int udVendidas) {
		this.nombre = nombre;
		this.plataf = plataf;
		this.udVendidas = udVendidas;
	}

	public Juego(String nombre, Plataforma plataf) {
		this(nombre, plataf, 0);
	}
	
// toString
	@Override
	public String toString() {
		return this.nombre + ", plataforma " + this.plataf.toString() + ", "
				+ this.udVendidas + " unidades vendidas";
	}
}
