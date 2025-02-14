package clasesPractica;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Usuario implements InterfazUsuario, Comparable<Usuario> {

// Variables
	private String nombre;
	private Set<Libro> librosSacados;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public Set<Libro> getLibrosSacados() {return librosSacados;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setLibrosSacados(Set<Libro> librosSacados) {this.librosSacados = librosSacados;}
	
// Constructores
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.librosSacados = new HashSet<>();
	}
	
// Métodos
	@Override
	public boolean sacaLibro(Libro lib) {
		return this.librosSacados.add(lib);
	}
	
	@Override
	public int cantidadLibrosSacados() {
		return this.librosSacados.size();
	}
	@Override
	public boolean puedeSacarMasLibros() {
		return cantidadLibrosSacados() < 10;
	}
	@Override
	public Libro devuelveLibro(String tit) {
		Libro lib = null;
		boolean terminar = false;
		
		for (Iterator<Libro> it = this.librosSacados.iterator(); it.hasNext() && !terminar;) {
			lib = it.next();
			if (lib.getTitulo() == tit)
				terminar = true;
		}
		
		if (!terminar) lib = null;
		return lib;
	}
	
// hashCode, equals, toString
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return nombre.equalsIgnoreCase(other.nombre);
	}
	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder(this.nombre + " (");
		
		if (cantidadLibrosSacados() > 0) {
			for (Libro lib: this.librosSacados)
				cadena.append(lib.getTitulo() + "; ");
			
			cadena.deleteCharAt(cadena.length()-1);
			cadena.deleteCharAt(cadena.length()-1);
			cadena.append(")");
		} else {
			cadena.append("No tiene libros sacados)");
		}
		
		return cadena.toString();
	}
	
	@Override
	public int compareTo(Usuario o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
	
	
	
	
}
