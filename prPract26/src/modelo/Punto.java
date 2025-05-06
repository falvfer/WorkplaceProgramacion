package modelo;

public class Punto {

// Variables coordenadas
	private double coordX, coordY;
	// Doy por hecho que las coordenadas representan "kilometros"
	
// Getters y Setters
	public double getCoordX() {return coordX;}
	public double getCoordY() {return coordY;}
	
	public void setCoordX(double coordX) {this.coordX = coordX;}
	public void setCoordY(double coordY) {this.coordY = coordY;}
	
// Constructor
	public Punto(double coordX, double coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Punto(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Punto(double[] coords) {
		this(coords[0], coords[1]);
	}
	
	public Punto(int[] coords) {
		this(coords[0], coords[1]);
	}
	
	public Punto() {
		this(0,0);
	}
	
// Métodos públicos
	public double medirDistancia(Punto other) {
		return Math.sqrt(
				Math.pow(other.coordX-this.coordX, 2)
				+ Math.pow(other.coordY-this.coordY, 2));
	}
	
// toString 
	@Override
	public String toString() {
		return coordX + ", " + coordY;
	}
}
