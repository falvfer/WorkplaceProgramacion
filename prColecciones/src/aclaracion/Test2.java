package aclaracion;

import java.util.HashSet;

public class Test2 {

	public static void main(String[] args) {

		Persona persona1 = new Persona ("José", "Hernández López", 28);
		Persona persona2 = new Persona ("Ramiro", "Suárez Rodríguez", 19);

		HashSet<Persona> conjunto= new HashSet<Persona>();
		conjunto.add(persona1);
		conjunto.add(persona2);
		System.out.println(conjunto.contains(persona1));
	}

}
