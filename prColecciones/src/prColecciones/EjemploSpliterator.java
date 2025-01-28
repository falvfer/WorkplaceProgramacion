package prColecciones;

import java.util.List;
import java.util.Set;
import java.util.Spliterator;

public class EjemploSpliterator {

	public static void main(String[] args) {

		List<String> list = List.of("Java", "Python", "C++", "JavaScript");

        Spliterator<String> spliterator = list.spliterator();

        // Procesar cada elemento secuencialmente
        spliterator.forEachRemaining(System.out::println);
        
        // ----------------------------------------------------------------
        // Para procesamiento en paralelo
        List<String> list2 = List.of("Java", "Python", "C++", "JavaScript", "Ruby", "Go");

        Spliterator<String> spliterator1 = list2.spliterator();

        // Dividir el Spliterator
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        // Procesar los elementos de cada Spliterator
        System.out.println("\nSpliterator 1:");
        spliterator1.forEachRemaining(System.out::println);

        System.out.println("\nSpliterator 2:");
        spliterator2.forEachRemaining(System.out::println);
        
        
        // ----------------------------------------------------------------
        // El Spliterator es fundamental en el framework de streams de Java,
        // ya que permite dividir colecciones para procesarlas en paralelo:
        // Ejemplo con un Stream paralelo
        Set<String> set = Set.of("Java", "Python", "C++", "JavaScript");

        // Usar stream paralelo
        set.parallelStream()
           .forEach(System.out::println);
        
           // En este caso, Java utiliza internamente un Spliterator para dividir el
           // conjunto y procesar sus elementos en paralelo.
	}

}
