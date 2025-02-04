package ejer04;

import java.util.*;

public class Ejercicio {

	public static void main(String args[]) {
		
		/*ES MEJOR SIMULAR LA COLA CON UNA LISTA NORMAL*/
		
		Queue<Integer> miCola = new LinkedList<>();
		
		// ".add" y ".offer" añaden elementos
		miCola.add(1); // Lanza excepciones, y siempre verdadero
		miCola.add(2);
		miCola.offer(23); // Da verdadero o falso
		miCola.offer(-53);
		miCola.offer(0);
		
		System.out.println(miCola);
		
		// Mirar el primero de la cola
		System.out.println("Primer elemento de la cola: " + miCola.peek()); // Verdadero / Falso
		System.out.println("Primer elemento de la cola: " + miCola.element()); // Lanza excepciones
		
	}
}
