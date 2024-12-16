package examen241204;

public class Cliente {

// Variables de instancia
	private String nombre, dni;
	private int numTlf;
	private boolean vip;

// Getters y Setters
	public String getNombre() {return nombre;}
	public String getDni() {return dni;}
	public int getNumTlf() {return numTlf;}
	public boolean isVip() {return vip;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setDni(String dni) {this.dni = dni;}
	public void setNumTlf(int numTlf) {this.numTlf = numTlf;}
	public void setVip(boolean vip) {this.vip = vip;}

// Constructores
	public Cliente(String nombre, String dni, int numTlf) {
		this.nombre = nombre;
		this.dni = dni;
		this.numTlf = numTlf;
		this.vip = false;
	}
	
	public Cliente(String nombre, String dni) {
		this(nombre, dni, 0);
	}
	
// Métodos públicos
	
	
// toString, equals
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + this.nombre
				+ " (DNI: " + this.dni
				+ ", Tlf.: " + (this.numTlf==0?"No disponible":this.numTlf)
				+ " - " + (this.vip?"":"NO ") + "VIP)";
	}
	
	@Override
	public boolean equals(Object ob) {
		Cliente otro = (Cliente)ob;
		return this.dni.equals(otro.dni);
	}
	
	
	
	
	
	
	
	
}
