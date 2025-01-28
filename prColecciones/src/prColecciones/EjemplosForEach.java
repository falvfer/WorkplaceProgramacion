package prColecciones;

import java.util.*;

public class EjemplosForEach {

	public static void main(String[] args) {
		// --------------------------------------------------------
        // Crear una lista de cadenas
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("María");

        // Iterar usando for-each
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }

        
		// --------------------------------------------------------
        // Crear un conjunto de números
        Set<Integer> numeros = new HashSet<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Iterar usando for-each
        for (Integer numero : numeros) {
            System.out.println("Número: " + numero);
        }
        
        
		// --------------------------------------------------------
        // Crear un mapa de ejemplo
        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Luis", 30);
        edades.put("María", 28);

        // Iterar sobre las claves
        System.out.println("Claves:");
        for (String clave : edades.keySet()) {
            System.out.println(clave);
        }

        // Iterar sobre los valores
        System.out.println("\nValores:");
        for (Integer valor : edades.values()) {
            System.out.println(valor);
        }

        // Iterar sobre las entradas (pares clave-valor)
        System.out.println("\nEntradas:");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println(entrada.getKey() + " tiene " + entrada.getValue() + " años.");
        }
	}

}
