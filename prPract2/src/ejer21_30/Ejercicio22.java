package ejer21_30;

import java.util.Scanner;

public class Ejercicio22 {
	
	public static void main(String[] args) {
		// Programa que calcula la media aritmética de una serie de números introducidos
		// por teclado, que finaliza con la introducción del valor 0.

		// Crear las variables necesarias
		int num, suma = 0, cont = 0;
		Scanner sc = new Scanner(System.in);

		// Objeto Scanner, pedir número
		try {
			System.out.print("Di un número: ");
			num = sc.nextInt();

			while (num != 0) { // Comprobar que sea distinto a 0
				suma += num; // Sumar el número a la media
				cont++;
				// Pedir otro número
				System.out.print("Di otro número (0 para terminar): ");
				num = sc.nextInt();
			}
			sc.close(); // Cerrar el objeto Scanner
			if (cont == 0)
				throw new ArithmeticException("Error: No introduzcas 0 como primer número.");

			// Imprimir el resultado por pantalla
			System.out.println("La media aritmética es: " + (double) suma / cont); // Calcular la media

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
