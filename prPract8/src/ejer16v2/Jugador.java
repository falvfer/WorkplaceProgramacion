package ejer16v2;

public class Jugador {
	
	// Variables
	private String nombre;
	private float totalPuntos;
	private boolean plantado;
	private int sueldo, apuesta;
	
	// Getters y Setters
	public String getNombre() {return nombre;}
	public float getTotalPuntos() {return totalPuntos;}
	public boolean isPlantado() {return plantado;}
	public int getSueldo() {return sueldo;}
	public int getApuesta() {return apuesta;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setTotalPuntos(float totalPuntos) {this.totalPuntos = totalPuntos;}
	public void setPlantado(boolean plantado) {this.plantado = plantado;}
	public void setSueldo(int sueldo) {this.sueldo = sueldo;}
	public void setApuesta(int apuesta) {this.apuesta = apuesta;}
	
	// Constructores
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.totalPuntos = 0;
		this.plantado = false;
	}
	
	// Métodos publicos
	public void reiniciar() {
		this.totalPuntos = 0;
		this.plantado = false;
	}
}
