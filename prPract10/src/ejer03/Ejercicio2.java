package ejer03;

import java.util.*;

public class Ejercicio2 {

	public static void main(String args[]) {
		
		List<Libro> misLibros = new ArrayList<>();
		
		misLibros.add(new Libro("María Dueñas","Entre costuras",false));
		misLibros.add(new Libro("Sarah Lark","En el país de la nube blanca",true));
		misLibros.add(new Libro("Eduardo Punset","Viaje al optimismo",false));
		misLibros.add(new Libro("María Dueñas","Misión olvido",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Señor de los Anillos",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Hobbit",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Silmarillion",true));
		misLibros.add(new Libro("Kate Morton","El jardín olvidado",true));
		misLibros.add(new Libro("Sarah Lark","La canción de los maoríes",true));
		
		System.out.println("Con LinkedList:");
		for (Libro lib: misLibros)
			System.out.println("\t" + lib);
		
		for (Libro lib: misLibros)
			System.out.println("\t" + lib);

		// Recorrer con iterator en orden inverso
		System.out.println("\nColección en orden inverso:");
		for (ListIterator<Libro> lit = new ArrayList<>(misLibros).listIterator(misLibros.size());
				lit.hasPrevious();)
			System.out.println("\t" + lit.previous());
		
		// Añadir libro repetido
		System.out.println("\nAñadir un libro invertido:");
		if (misLibros.add(new Libro("J.R.R. Tolkien","El Señor de los Anillos",true)))
			System.out.println("Libro añadido");
		else
			System.out.println("El libro no se ha podido añadir");
		
		for (Libro lib: misLibros)
			System.out.println("\t" + lib);
		
		// Ordenar de forma inversa solamente el título
		System.out.println("\nOrdenar de forma inversa solamente el título:");
		Collections.sort(misLibros,
			(o1, o2) -> {
				int comparacion = o1.getAutor().compareTo(o2.getAutor());
				
				if (comparacion != 0)
					return comparacion;

				return o2.getTitulo().compareTo(o1.getTitulo());
			}
		);
		
		for (Libro lib: misLibros)
			System.out.println("\t" + lib);
		
		
	}
}
