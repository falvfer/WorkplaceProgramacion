package modelo;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Persona implements Comparable<Persona> {

	private String nombre;

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public static SortedSet<Persona> splitNombres(String nombres) {
		SortedSet<Persona> personas = new TreeSet<>();
		for (String nombre: nombres.split("\\s*,\\s*"))
			personas.add(new Persona(nombre));
		
		return personas;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
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
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
}
