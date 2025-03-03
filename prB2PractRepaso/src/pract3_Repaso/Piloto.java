package pract3_Repaso;

import java.time.LocalDate;
import java.util.Objects;

public class Piloto {

// Variables
	private String nombre, nacionalidad, escuderia;
	private LocalDate nacimiento;
	private int puntosTotales;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public String getNacionalidad() {return nacionalidad;}
	public String getEscuderia() {return escuderia;}
	public LocalDate getNacimiento() {return nacimiento;}
	public int getPuntosTotales() {return puntosTotales;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
	public void setEscuderia(String escuderia) {this.escuderia = escuderia;}
	public void setNacimiento(LocalDate nacimiento) {this.nacimiento = nacimiento;}
	public void setPuntosTotales(int puntosTotales) {this.puntosTotales = puntosTotales;}
	
// Constructor
	public Piloto(String nombre, String nacionalidad, String escuderia, String nacimiento) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.escuderia = escuderia;
		this.nacimiento = Fechas.toDate(nacimiento);
	}

// Métodos públicos
	public int getEdadPiloto() {
		if (this.nacimiento == null)
			return -1;
		else
			return Fechas.edad(nacimiento);
	}
	
	public void addPuntos(int puntos) {
		this.puntosTotales += puntos;
	}
	
// toString
	@Override
	public String toString() {
		return this.puntosTotales + " puntos - " + this.nombre + " (" + this.nacionalidad + "), "
				+ this.escuderia + " - " + this.getEdadPiloto() + " años";
	}
	
// hashCode, equals
	@Override
	public int hashCode() {
		return Objects.hash(escuderia, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		return Objects.equals(escuderia, other.escuderia) && Objects.equals(nombre, other.nombre);
	}
	
}
