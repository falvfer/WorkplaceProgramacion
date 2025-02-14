package clasesPractica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Libro implements Comparable<Libro> {
	
// Variables
	private String codigo, titulo, autor;
	private List<String> personajes;
	
// Getters y Setters
	public String getCodigo() {return codigo;}
	public String getTitulo() {return titulo;}
	public String getAutor() {return autor;}
	public List<String> getPersonajes() {return personajes;}
	
	public void setCodigo(String codigo) {this.codigo = codigo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public void setAutor(String autor) {this.autor = autor;}
	public void setPersonajes(List<String> personajes) {this.personajes = personajes;}
	
// Constructores
	public Libro(String codigo, String titulo, String autor, List<String> personajes) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.personajes = personajes;
	}
	
	public Libro(String codigo, String titulo, String autor) {
		this(codigo, titulo, autor, new ArrayList<>());
	}
	
// Métodos
	public boolean añadirPersonaje(String personaje) {
		return personajes.add(personaje);
	}
	
	public int añadirPersonajes(String[] personajes) {
		int personajesAñadidos = 0;
		
		for (int i = 0; i < personajes.length; i++) {
			if (this.personajes.add(personajes[i]))
				personajesAñadidos++;
		}
		
		return personajesAñadidos;
	}

	public boolean borrarPersonaje(String personaje) {
		return personajes.remove(personaje);
	}
	
	
// hashCode, equals, toString
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	@Override
	public String toString() {
		return this.codigo + ": " + this.titulo + " (escrito por " + this.autor + " " + this.personajes + ")";
	}
	@Override
	public int compareTo(Libro o) {
		return this.codigo.compareTo(o.codigo);
	}
	
}
