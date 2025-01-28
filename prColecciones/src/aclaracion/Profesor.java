package aclaracion;

import java.util.Objects;

public class Profesor extends Persona{

	private String idProfesor;

	public Profesor(String nombre, String apellidos, int edad, String idProfesor) {
		super(nombre, apellidos, edad);
		this.idProfesor = idProfesor;
	}

	
	/**
	 * Redefinicón de hashCode de Profesor
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idProfesor);
		return result;
	}

	/**
	 * Redefinición de equals en la clase Profesor
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Profesor other = (Profesor) obj;
		return Objects.equals(idProfesor, other.idProfesor);
	}

	
    	
}
