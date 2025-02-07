package ejer06;

import java.util.LinkedList;

public class GrupoV2 extends LinkedList<Alumno> {
	
	private static final long serialVersionUID = -5571653245200009482L;

	// toString
	@Override
	public String toString() {
		String str = "LISTA DE CLASE"
				 + "\n--------------";
		
		for (Alumno a: this)
			str += "\n" + a.toString();
		
		return str;
	}
	
}
