package prColecciones;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EjemploOf {

	public static void main(String[] args) {
		

		Set<String> fruits = Set.of("Apple", "Banana", "Cherry");
		// El método of, crea un conjunto de objeto inmutables

		System.out.println(fruits); // [Apple, Banana, Cherry]

		// Intentar modificar el conjunto lanza UnsupportedOperationException
		// fruits.add("Orange"); // Error en tiempo de ejecución

		// Lanzará IllegalArgumentException debido a elementos duplicados
		Set<String> animals = Set.of("Dog", "Cat", "Dog");

		// Lanzará NullPointerException porque no se permiten valores null
		Set<String> items = Set.of("Table", null, "Chair");
		
		
		// ------------------------------------------------------------------------------------
		// Antes de que existiese el método Of había que trabajar con el método unmodifiableSet
		// que era más engorroso de utilizar
		Set<String> oldSet = new HashSet<>();
        oldSet.add("Apple");
        oldSet.add("Banana");
        oldSet.add("Cherry");

        Set<String> immutableSet = Collections.unmodifiableSet(oldSet);
        System.out.println(immutableSet);
        
        
        // Método of con List y Map
        List<String> list = List.of("A", "B", "A"); // Permitido elementos repetidos
        Map<String, Integer> map = Map.of("Apple", 1, "Banana", 2);
	}

}
