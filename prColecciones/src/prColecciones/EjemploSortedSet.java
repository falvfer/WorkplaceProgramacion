package prColecciones;

import java.util.SortedSet;
import java.util.TreeSet;

public class EjemploSortedSet {

	public static void main(String[] args) {
		// Crear un SortedSet usando TreeSet
        SortedSet<Integer> numeros = new TreeSet<>();

        // Añadir elementos al SortedSet
        numeros.add(50);
        numeros.add(10);
        numeros.add(30);
        numeros.add(40);

        // Los elementos se ordenan automáticamente en orden ascendente
        System.out.println("SortedSet: " + numeros);

        // Obtener el primer y último elemento
        System.out.println("Primer elemento: " + numeros.first());
        System.out.println("Último elemento: " + numeros.last());

        // Obtener una vista de los elementos menores que 40
        SortedSet<Integer> headSet = numeros.headSet(40);
        System.out.println("Elementos menores que 40: " + headSet);

	}

}
