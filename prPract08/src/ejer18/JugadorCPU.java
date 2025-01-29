package ejer18;

public class JugadorCPU extends Jugador {

	// Variables
	private byte dificultad;
	private float puntosOcultos;
	private static int contCPU = 1;
	
	// Getters y Setters
	public byte getDificultad() {return dificultad;}
	public float getPuntosOcultos() {return puntosOcultos;}
	public void setDificultad(byte dificultad) {this.dificultad = dificultad;}
	public void setPuntosOcultos(float puntosOcultos) {this.puntosOcultos = puntosOcultos;}

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
