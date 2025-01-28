package prColecciones;

import java.util.HashSet;
import java.util.Set;

public class EjemploSet {

	public static void main(String[] args) {
		// Crear un conjunto de ciudades
        Set<String> ciudades = new HashSet<>();

        // Añadir elementos al conjunto
        ciudades.add("Madrid");
        ciudades.add("Londres");
        ciudades.add("París");
        ciudades.add("Londres"); // Intentando añadir un duplicado

        // Mostrar los elementos del conjunto
        System.out.println("Ciudades: " + ciudades);

	}

}
