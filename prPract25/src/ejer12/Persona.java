package ejer12;

import java.io.Serializable;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 4164664826267262930L;

// Variables privadas
	private String nombre, apellido, telefono;

// Getters y Setters
	public String getNombre() {return nombre;}
	public String getApellido() {return apellido;}
	public String getTelefono() {return telefono;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellido(String apellido) {this.apellido = apellido;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	
// Constructor
	public Persona(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
// toString
	@Override
	public String toString() {
		return nombre+" "+apellido+", "+telefono;
	}
	
}
