package ejer04;

import java.util.*;

public class Ejercicio2 {

	public static void main(String args[]) {

		/*ES MEJOR SIMULAR LA PILA CON UNA LISTA NORMAL*/
		
		Deque<Integer> miPila = new ArrayDeque<>();
		
		miPila.addFirst(1);
		miPila.add(2); // Equivale a addLast
		miPila.push(3);
		miPila.push(4);
		miPila.push(80);
	
		System.out.println(miPila);
		
		System.out.println("Primero de la Pila: " + miPila);
		
		
	}
}
