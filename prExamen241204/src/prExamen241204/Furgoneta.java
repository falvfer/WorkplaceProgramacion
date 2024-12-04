package prExamen241204;

public class Furgoneta extends Vehiculo {

// Variables de instancia
	private double volCarga; // m^3

// Getters y Setters
	public double getVolCarga() {return volCarga;}
	public void setVolCarga(double volCarga) {this.volCarga = volCarga;}

// Constructores
	public Furgoneta(String matricula, String modelo, byte numPlazas, float precioAlquilerDia, double consumoKm, double volCarga) {
		super(matricula, modelo, numPlazas, precioAlquilerDia, consumoKm);
		this.volCarga = volCarga;
	}
	
// Métodos públicos
	@Override
	public float impuestosAnuales() {
		return super.impuestosAnuales() + (this.volCarga>5?100:50);
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n   Volumen de carga: " + this.volCarga + " mt. cúbicos";
	}
}
