package ejer01_Popurri;

import java.util.*;

public class ejer2 {

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
		
		// Borrar todos los números
		Object elem;
		for (Iterator<Object> it2 = lista.iterator(); it2.hasNext();) {
			elem = it2.next();
			if (elem instanceof Integer)
				it2.remove();
		}
		
		// Buscar un libro y guardarlo con el mismo nombre pero en mayuscula
		// Libro a buscar
		Libro libroABuscar = new Libro("Libro 1", "Panete", true);
		
		// Crear variables e iterator
		boolean encontrado = false;
		Object sigOb = null;
		it = lista.iterator();
		
		// Buscarlo y cambiarle el título a mayusculas
		while (it.hasNext() && !encontrado) {
			sigOb = it.next();
			if (sigOb instanceof Libro && libroABuscar.equals(sigOb)) {
				((Libro)sigOb).setTitulo(libroABuscar.getTitulo().toUpperCase());
				encontrado = true;
			}
		}
		for (Object ob: lista)
			System.out.println(ob);
		
		// Buscar en base al titulo solamente: En estos casos es mejor guardar
		// el objeto en una variable en lugar de hacer tantos casting
		String titulo = libroABuscar.getTitulo();
		encontrado = false;
		it = lista.iterator();
		
		while (it.hasNext() && !encontrado) {
			sigOb = it.next();
			if (sigOb instanceof Libro && ((Libro)sigOb).getTitulo().equals(titulo)) {
				((Libro)sigOb).setTitulo(((Libro)sigOb).getTitulo().toUpperCase());
				encontrado = true;
			}
		}
		for (Object ob: lista)
			System.out.println(ob);
		
		// Prueba los métodos contains y remove, tanto con cadenas y números como libros.
		it = lista.iterator();
		System.out.println("cadena 2:\t" + (lista.contains("cadena 2")?"Si existe":"No existe"));
		System.out.println("hola:\t\t" + (lista.contains("hola")?"Si existe":"No existe"));
		System.out.println("23:\t\t" + (lista.contains(23)?"Si existe":"No existe"));
		System.out.println("Libro 1:\t" + (lista.contains(new Libro("LIBRO 1", "Panete", true))?"Si existe":"No existe"));
		
		System.out.println(lista.remove("cadena 2")?"Se ha borrado":"No se ha borrado");
		System.out.println(lista.remove(new Libro("LIBRO 1", "Panete", true))?"Se ha borrado":"No se ha borrado");
		
		
	}
	
}