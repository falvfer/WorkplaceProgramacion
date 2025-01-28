package prColecciones;

import java.util.SortedMap;
import java.util.TreeMap;

public class EjemploSortedMap {

	public static void main(String[] args) {
        // Crear un SortedMap usando TreeMap
        SortedMap<String, Integer> edades = new TreeMap<>();

        // Añadir pares clave-valor al SortedMap
        edades.put("Carlos", 30);
        edades.put("Ana", 25);
        edades.put("Juan", 35);
        edades.put("Beatriz", 28);

        // Las claves se ordenan automáticamente en orden ascendente
        System.out.println("SortedMap: " + edades);

        // Obtener la primera y última clave
        System.out.println("Primera clave: " + edades.firstKey());
        System.out.println("Última clave: " + edades.lastKey());

        // Obtener una vista de las claves menores que "Juan"
        SortedMap<String, Integer> headMap = edades.headMap("Juan");
        System.out.println("Claves menores que 'Juan': " + headMap);

      
	}

}
