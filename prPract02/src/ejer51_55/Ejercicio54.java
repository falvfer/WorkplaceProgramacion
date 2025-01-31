package ejer51_55;

import java.util.Scanner;

public class Ejercicio54 {

	public static void main(String[] args) {
		// Diseñar un algoritmo que lee una lista de números enteros terminada en 0, y
		// que encuentre y escriba en pantalla la posición de la primera y última
		// ocurrencia del número 12 dentro de la lista. Si el número 12 no está en la
		// lista, el algoritmo debería escribir 0. Por ejemplo, si el octavo número de
		// la lista es el único 12, entonces 8 sería la primera y la última posición de
		// las ocurrencias de 12.		
		
		int prim12 = 0, ult12 = 0, num = 1, cont = 1;
		boolean primero = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Especifica el número: ");
		num = sc.nextInt();
		
		while (num != 0) {
			if (num == 12)
				if (primero) {
					prim12 = cont;
					primero = false;
				} else
					ult12 = cont;
			
			System.out.print("Especifica el número (0 para terminar): ");
			num = sc.nextInt();
			cont++;
		}
		sc.close();

		if (prim12 == 0)
			System.out.println("No ha habido ningún 12");
		else if (ult12 == 0)
			System.out.println("El unico 12 está en la posición "+prim12);
		else {
			System.out.println("El primer 12 está en la posición "+prim12);
			System.out.println("El ultimo 12 está en la posición "+ult12);
		}
		
	}
}
