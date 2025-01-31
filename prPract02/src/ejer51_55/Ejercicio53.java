package ejer51_55;

import java.util.Scanner;

public class Ejercicio53 {

	public static void main(String[] args) {
		// Diseñar un algoritmo que determine si la cadena “abc”, aparece en una
		// sucesión de caracteres cuyo final viene dado por un punto. No se lee una
		// cadena, sino caracteres sueltos.

		boolean check = false;
		byte cont = 0;
		char entrada;
		Scanner sc = new Scanner(System.in);

		System.out.print("Especifique una letra (minúscula): ");
		entrada = sc.next().charAt(0);

		while (entrada != '.') {
			
			if (check == false) {
				if (cont == 0 && entrada == 'a')
					cont++;
				else if (cont == 1 && entrada == 'b')
					cont++;
				else if (cont == 2 && entrada == 'c')
					check = true;
				else {
					cont = 0;
					if (entrada == 'a')
						cont++;
				}
			}

			System.out.print("Especifique otra letra (minúscula) ('.' para terminar): ");
			entrada = sc.next().charAt(0);
		}
		sc.close();

		if (check == true)
			System.out.println("Se ha encontrado la cadena 'abc'.");
		else
			System.out.println("No se ha encontrado la cadena 'abc'.");

	}
}
