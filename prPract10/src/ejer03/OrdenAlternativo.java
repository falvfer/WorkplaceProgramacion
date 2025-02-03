package ejer03;

import java.util.Comparator;

public class OrdenAlternativo implements Comparator<Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		int comparacion = o1.getAutor().compareTo(o2.getAutor());
		
		if (comparacion != 0)
			return comparacion;

		return o2.getTitulo().compareTo(o1.getTitulo());
	}

}
