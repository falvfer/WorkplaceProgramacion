package modelo;

import java.io.Serializable;

public class CasaRural extends Alojamiento implements Serializable {
	private static final long serialVersionUID = 4264257476127786884L;
	
	// Variables
	private byte numHabitaciones;

// Getters y Setters
	public byte getNumHabitaciones() {return numHabitaciones;}
	public void setNumHabitaciones(byte numHabitaciones) {this.numHabitaciones = numHabitaciones;}

// Constructor
	public CasaRural(String nombre, UbicacionesEnum ubicacion, double precioBase,
			byte numHabitaciones) throws MiExcepcion {
		
		super(nombre, ubicacion, precioBase);
		this.numHabitaciones = numHabitaciones;
	}

// Métodos
	@Override
	public double calculaPrecio(int numNoches) {
		if (numNoches <= 0) return -1;
		double precioTotal = super.getPrecioBase() * numNoches;
		
		if (numNoches < 10 && numNoches >= 5)
			precioTotal *= 0.95;
		else 
			precioTotal *= 0.9;
		
		return precioTotal;
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tNúmero de habitaciones: " + this.numHabitaciones;
	}
	
}
