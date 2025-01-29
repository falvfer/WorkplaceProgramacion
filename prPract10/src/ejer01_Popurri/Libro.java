package ejer01_Popurri;

import java.util.Objects;

public class Libro implements Comparable<Libro> {

// Variables de instancia
	private String autor, titulo;
	private boolean estado; // FALSE prestado, TRUE disponible
	
	// Constructores
	public Libro(String t, String a, boolean e) {
		this.titulo = t;
		this.autor = a;
		this.estado = e;
	}
	
// Overrides
	@Override
	public String toString() {
		return "Objeto Libro: "
				+ "\n\tAutor: " + this.getAutor()
				+ "\n\tTítulo: " + this.getTitulo()
				+ "\n\tEstado: " + (this.getEstado()?"Disponible":"Prestado");
	}
/*
	@Override
	public boolean equals(Object ob) {
		Libro otroLibro = (Libro)ob;
		return this.autor.equals(otroLibro.getAutor())
			&& this.titulo.equals(otroLibro.getTitulo());
	}*/
	
// Getters
	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public boolean getEstado() {
		return estado;
	}
	
// Setters
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, titulo);
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
		return Objects.equals(autor, other.autor) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Libro o) {
		// Comparar autores
		int comparacion = this.autor.compareTo(o.autor);
		// Devolver eso si no son iguales
		if (comparacion != 0)
			return comparacion;
		// Comparar títulos si es el mismo autor
		return this.titulo.compareTo(o.titulo);
	}
	
	
	
	
	
	
	
}
