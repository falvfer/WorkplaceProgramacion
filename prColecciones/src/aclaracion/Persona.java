package aclaracion;

import java.util.Objects;

public class Persona {
	
	private String nombre, apellidos;
	private int edad;
	
	
	public Persona(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidos, edad, nombre);
	}

	
	// Generación errónea de hashCode, no es compatible con equals
/*
	@Override
	public int hashCode() {
		return (int)(Math.random()*1000);
	}
	*/
	
	/**
	 * Redefinición de equals en la clase Persona 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
	
		
	
}