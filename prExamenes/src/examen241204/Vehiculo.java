package examen241204;

public class Vehiculo {

// Variables de instancia
	private String matricula, modelo;
	private byte numPlazas;
	private float precioAlquilerDia;
	private double consumoKm;

// Getters y Setters
	public String getMatricula() {return matricula;}
	public String getModelo() {return modelo;}
	public byte getNumPlazas() {return numPlazas;}
	public float getPrecioAlquilerDia() {return precioAlquilerDia;}
	public double getConsumoKm() {return consumoKm;}
	
	public void setMatricula(String matricula) {this.matricula = matricula;}
	public void setModelo(String modelo) {this.modelo = modelo;}
	public void setNumPlazas(byte numPlazas) {this.numPlazas = numPlazas;}
	public void setPrecioAlquilerDia(float precioAlquilerDia) {this.precioAlquilerDia = precioAlquilerDia;}
	public void setConsumoKm(double consumoKm) {this.consumoKm = consumoKm;}

// Constructores
	public Vehiculo(String matricula, String modelo, byte numPlazas, float precioAlquilerDia, double consumoKm) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.numPlazas = numPlazas;
		this.precioAlquilerDia = precioAlquilerDia;
		this.consumoKm = consumoKm;
	}
	
// Métodos públicos
	public float impuestosAnuales() {
		return 10 * this.numPlazas;
	}
	
	public float consumo100Km(float precioCombustiblePorLitro) {
		return UtilidadesVehiculos.costeCombustible(100, this.consumoKm, precioCombustiblePorLitro);
	}
	
// toString, equals
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase() + ": " + this.matricula + " - " + this.modelo
				+ "\n\tImpuestos anuales: " + this.impuestosAnuales() + "€"
				+ "\n\tPrecio alquiler diario: " + this.precioAlquilerDia + "€"
				+ "\n\tNúmero de plazas: " + this.numPlazas;
	}

	@Override
	public boolean equals(Object ob) {
		Vehiculo otro = (Vehiculo)ob;
		return this.matricula.equals(otro.matricula);
	}
	
}
