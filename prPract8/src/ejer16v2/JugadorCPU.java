package ejer16v2;

public class JugadorCPU extends Jugador {

	// Variables
	private byte dificultad;
	private static int contCPU = 1;
	
	// Getters y Setters
	public byte getDificultad() {return dificultad;}
	public void setDificultad(byte dificultad) {this.dificultad = dificultad;}

	// Constructores
	public JugadorCPU(byte dificultad) {
		super("CPU" + (contCPU==1?"": contCPU));
		this.dificultad = dificultad;
		contCPU++;
	}
	
	public JugadorCPU() {
		this((byte)0);
	}
	
	
}
