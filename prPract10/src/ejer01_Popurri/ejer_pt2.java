package ejer01_Popurri;

import java.util.*;

public class ejer_pt2 {

	public static void main(String[] args) {
		
		// Crear una colección de números tipo List
		List<Integer> miLista = new ArrayList<>();
		
		miLista.add(25);
		miLista.add(78);
		miLista.add(10);
		miLista.add(17);
		miLista.add(99);
		System.out.println(miLista);

		// Recorrer la colección como si fuese un array
		for (int i=0; i < miLista.size(); i++) {
			System.out.print(miLista.get(i) + " ");
		}
		
		// Comprobar si existe un número
		System.out.println("\n\n" + (miLista.contains(17)?"Existe el 17":"No existe el 17"));
		System.out.println(miLista.contains(123)?"Existe el 123":"No existe el 123");
		
		// Borrar un número
		System.out.println("\n" + (miLista.remove(Integer.valueOf(17))?"Se ha podido borrar el 17":"No se ha podido borrar el 17"));
		System.out.println(miLista.remove(Integer.valueOf(123))?"Se ha podido borrar el 123":"No se ha podido borrar el 123");

		// Ordenar por orden ascendente (orden natural)
		System.out.println("\n" + miLista);
		Collections.sort(miLista);
		System.out.println(miLista);
		
		// Ordenar de forma descendente (orden alternativo)
		miLista.sort(new ComparatorInteger());
		System.out.println("\n" + miLista);
		Collections.sort(miLista, new ComparatorInteger());
	}
	
}
