package modelo;

import java.io.Serializable;
import java.util.Objects;

abstract public class Alojamiento implements Comparable<Alojamiento>, Serializable {
	private static final long serialVersionUID = 4610221954445704699L;
	
	// Variables
	private String nombre;
	private UbicacionesEnum ubicacion;
	private double precioBase;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public UbicacionesEnum getUbicacion() {return ubicacion;}
	public double getPrecioBase() {return precioBase;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setUbicacion(UbicacionesEnum ubicacion) {this.ubicacion = ubicacion;}
	public void setPrecioBase(double precioBase) {this.precioBase = precioBase;}
	
// Constructor
	public Alojamiento(String nombre, UbicacionesEnum ubicacion, double precioBase) throws MiExcepcion {
		if (precioBase < 0) throw new MiExcepcion("El precio base no puede ser negativo");
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precioBase = precioBase;
	}
	
// Métodos públicos
	abstract double calculaPrecio(int numNoches);
	
// hashCode, equals, compareTo
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alojamiento other = (Alojamiento) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Alojamiento o) {
		return this.nombre.compareTo(o.nombre);
	}
	
// toString
	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+ "\n\tNombre: " + this.nombre
				+ "\n\tUbicación: " + this.ubicacion
				+ "\n\tPrecio base: " + this.precioBase;
	}
	
}
