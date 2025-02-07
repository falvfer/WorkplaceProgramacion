package prColecciones;

import java.util.Iterator;
import java.util.List;

public class EjemploForEach_ForEachRemaining {

	public static void main(String[] args) {

		List<String> list = List.of("Java", "Python", "C++");

		// ------------------------------------------------------------------
		// Recorrer toda la lista con forEach - Forma 1
		list.forEach(lenguaje -> System.out.println(lenguaje));

		// Recorrer toda la lista con forEach - Forma 2
		list.forEach(System.out::println);

		// Usando un stream para recorrer la lista
		list.stream().forEach(System.out::println);

        // ------------------------------------------------------------------
		Iterator<String> iterator = list.iterator();

        // Procesar el primer elemento manualmente
        if (iterator.hasNext()) {
            System.out.println("\nPrimer elemento: " + iterator.next());
        }

        // Procesar los elementos restantes con foreEachRemaining
        iterator.forEachRemaining(lenguaje -> System.out.println("Restante: " + lenguaje));
	}

}
