package ejer06;

import java.util.LinkedList;
import java.util.List;

public class Grupo {

// Variables
	private List<Alumno> grupo;

// Getters y Setters
	public List<Alumno> getGrupo() {return grupo;}
	public void setGrupo(List<Alumno> grupo) {this.grupo = grupo;}
	
// Constructores
	public Grupo(List<Alumno> grupo) {
		this.grupo = grupo;
	}

	public Grupo() {
		this(new LinkedList<>());
	}
	
// Métodos
	public boolean añadeAlumno(Alumno alum) {
		return this.grupo.add(alum);
	}
	
	public void ordenar() {
		this.grupo.sort(null);
	}
	
// toString
	@Override
	public String toString() {
		String str = "LISTA DE CLASE"
				 + "\n--------------";
		
		for (Alumno a: grupo)
			str += "\n" + a.toString();
		
		return str;
	}
	
}
