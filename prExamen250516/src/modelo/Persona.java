package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {
	private static final long serialVersionUID = -9037927575200954944L;
	
	// Variables
	private String nombre, dni, telefono;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public String getDni() {return dni;}
	public String getTelefono() {return telefono;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setDni(String dni) {this.dni = dni;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	
// Constructor
	public Persona(String nombre, String dni, String telefono) throws MiExcepcion {
		if (dni != null && !validarDNI(dni))
			throw new MiExcepcion("DNI no válido");
		
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}
	public Persona(String nombre, String telefono) throws MiExcepcion {
		this(nombre, null, telefono);
	}
	
// Métodos
	public static boolean validarDNI(String dni) {
		return dni.matches("^[0-9]{8}[A-Z]$");
	}
	
// hashCode, equals
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	
}
