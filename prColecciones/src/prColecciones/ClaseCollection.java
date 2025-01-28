package prColecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class ClaseCollection {

	public static void main(String[] args) {
		// Crear una colección de tipo ArrayList
        Collection<String> frutas = new ArrayList<>();

        // Añadir elementos a la colección
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");

        // Mostrar el tamaño de la colección
        System.out.println("Tamaño de la colección: " + frutas.size());

        // Verificar si un elemento está en la colección
        if (frutas.contains("Manzana")) {
            System.out.println("La colección contiene 'Manzana'.");
        }

        // Eliminar un elemento de la colección
        frutas.remove("Banana");

        // Mostrar los elementos restantes en la colección
        System.out.println("Elementos en la colección: " + frutas);

        //https://oregoom.com/java/colecciones/
        


	}

}
