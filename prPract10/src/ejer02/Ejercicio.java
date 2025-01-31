package ejer02;

import java.util.*;

public class Ejercicio {
	/* Crear una colección tipo List, cuyos objetos sean cadenas de texto, parametrízala de forma adecuada.
	 * Cuando pidas memoria concreta a ArrayList o LinkedList, independiente de la clase que elijas, prueba
	 * posteriormente con la otra.
	 */
	public static void main(String args[]) {
		List<String> listaCadena = new LinkedList<>();
		
		// Añade diferentes elementos a la lista y recórrela para mostrar sus elementos.
		listaCadena.add("cadena 1");
		listaCadena.add("nombre y apellido");
		listaCadena.add("otro ejemplo de cadena de texto");
		listaCadena.add("estudiar mucho");
		listaCadena.add("Ejemplo número 3");
		
		for (String str: listaCadena)
			System.out.println(str);
		
		// Recorrerlo a la inversa
		for (ListIterator<String> it = listaCadena.listIterator(listaCadena.size()); it.hasPrevious();)
			System.out.println(it.previous());

		// Averigua el número de elementos de tu lista.
		System.out.println("\nTamaño de la cadena: " + listaCadena.size());
		
		// Prueba a mostrar distintos elementos de la lista, por ejemplo, el primero, el último,
		// el que ocupa la cuarta posición, ...
		System.out.println("\nPrimera posición: " + listaCadena.getFirst());
		System.out.println("Última posición: " + listaCadena.getLast());
		System.out.println("Cuarta posición: " + listaCadena.get(3));
		
		// De forma análoga, prueba a borrar determinados elementos tanto con el método remove de
		// la interfaz List, como con el de la interfaz Iterator.
		listaCadena.remove("estudiar mucho");
		System.out.println("\nBorrado la cadena 'estudiar mucho': " + listaCadena);
		
		if (listaCadena.remove("aaaa"))
			System.out.println("Se ha borrado 'aaaa'.");
		else
			System.out.println("No se ha encontrado 'aaaa'.");
		
		for (Iterator<String> it = listaCadena.iterator(); it.hasNext();) {
			if (it.next().equals("otro ejemplo de cadena de texto"))
				it.remove();
		}
		
		System.out.println("Lista después de borrado con iterator: " + listaCadena);
		
		// Prueba a llamar algún método que sea propio de la clase (no de la interfaz List).
		((LinkedList<String>)listaCadena).descendingIterator(); // Hay que hacer un casting a LinkedList
		
		//Prueba a ordenar tu lista, tanto de forma ascendente, como descendente.
		Collections.sort(listaCadena);
		System.out.println();
		for (String str: listaCadena)
			System.out.println(str);
		
		Collections.sort(listaCadena, new OrdenInversoCadena());
		System.out.println();
		for (String str: listaCadena)
			System.out.println(str);
		
		// Cambiarlo a mayuscula y mostrarlo
		System.out.println(); // Un metodo puede ser con previousIndex
		for (ListIterator<String> it = listaCadena.listIterator(); it.hasNext();) {
			it.set(it.next().toUpperCase());
			System.out.println(listaCadena.get(it.previousIndex()));
		}
		System.out.println(); // Otro metodo guardando la cadena en mayuscula y usando set
		String cadena;		  // (minuscula para ver la diferencia)
		for (ListIterator<String> it = listaCadena.listIterator(); it.hasNext();) {
			cadena = it.next().toLowerCase();
			it.set(cadena);
			System.out.println(cadena);
		}
	}
}
