package examen241204;

public class Turismo extends Vehiculo {

// Variables de instancia
	private String clasificacion;
	private boolean electrico;

// Getters y Setters
	public String getClasificacion() {return clasificacion;}
	public boolean isElectrico() {return electrico;}
	
	public void setClasificacion(String clasificacion) {this.clasificacion = clasificacion;}
	public void setElectrico(boolean electrico) {this.electrico = electrico;}

// Constructores
	public Turismo(String matricula, String modelo, byte numPlazas, float precioAlquilerDia, double consumoKm,
							String clasificacion, boolean electrico) {
		super(matricula, modelo, numPlazas, precioAlquilerDia, consumoKm);
		this.clasificacion = clasificacion;
		this.electrico = electrico;
	}
	
// Métodos públicos
	@Override
	public float impuestosAnuales() {
		return super.impuestosAnuales() + (this.electrico? -20: 50) + (this.clasificacion.equalsIgnoreCase("SUV")? 25: 0);
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n   " + (this.electrico?"Electrico - ":"") + "Tipo: " + this.clasificacion;
	}
}
