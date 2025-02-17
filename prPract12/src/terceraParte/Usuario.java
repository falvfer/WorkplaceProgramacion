package terceraParte;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Usuario implements InterfazUsuario, Comparable<Usuario> {

// Variables
	private String nombre;
	private Libro[] librosSacados;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public Libro[] getLibrosSacados() {return librosSacados;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setLibrosSacados(Libro[] librosSacados) {this.librosSacados = librosSacados;}
	
// Constructores
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.librosSacados = new Libro[5];
		Arrays.fill(librosSacados, null);
	}
	
// Métodos
	private int primerNull() {
		int posNull = -1;
		
		for (int i = 0; i < this.librosSacados.length && posNull == -1; i++)
			if (this.librosSacados[i] == null)
				posNull = i;
		
		return posNull;
	}
	
	@Override
	public boolean sacaLibro(Libro lib) {
		int pos = this.primerNull();
		if (pos == -1) return false;
		
		this.librosSacados[pos] = lib;
		return true;
	}
	
	@Override
	public int cantidadLibrosSacados() {
		return this.primerNull();
	}
	@Override
	public boolean puedeSacarMasLibros() {
		return this.primerNull() == -1;
	}
	@Override
	public Libro devuelveLibro(String tit) {
		Libro lib = null;
		boolean terminar = false;
		
		int ultPosicion = this.primerNull();
		if (ultPosicion == -1)
			ultPosicion = 10;
		
		for (int i = 0; i < ultPosicion && !terminar; i++)
			if (this.librosSacados[i].getTitulo() == tit) {
				terminar = true;
				lib = this.librosSacados[i];
			}
		
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
