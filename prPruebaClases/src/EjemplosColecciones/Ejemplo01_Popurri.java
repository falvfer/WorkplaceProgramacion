package EjemplosColecciones;

import java.util.*;

public class Ejemplo01_Popurri {

	// colection -> 3 cadenas, 1 objrandom, 2 libros, 3 enteros
	public static void main(String[] args) {
		
		Collection<Object> lista = new ArrayList<>();
		
		lista.add("cadena 1");
		lista.add("cadena 2");
		lista.add("cadena 3");
		lista.add(new Random());
		lista.add(new Libro("Libro 1", "Panete", true));
		lista.add(new Libro("Libro 2", "Juanito", false));
		lista.add(13);
		lista.add(230288);
		lista.add(-2313);
		
		// Recorrer para mostrar los datos
		for (Object ob: lista)
			System.out.println(ob);
		
		// Recorrer con while y con iterator
		Iterator<Object> it = lista.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		// Recorrer con for y con iterator
		for (Iterator<Object> it2 = lista.iterator(); it.hasNext();) {
			System.out.println(it2.next());
		}
		
		// Borrar números
		Object elem;
		for (Iterator<Object> it2 = lista.iterator(); it.hasNext();) {
			elem = it2.next();
			if (elem instanceof Integer || elem instanceof Double)
				it2.remove();
		}
		// Buscar un libro y guardarlo con el mismo nombre pero en mayuscula
		
	}
	
}
